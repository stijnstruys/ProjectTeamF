package be.kdg.teamf.controller;

import be.kdg.teamf.model.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 4-3-13
 * Time: 16:53
 * To change this template use File | Settings | File Templates.
 */
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring-servlet.xml")
public class TestTripController extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    TripController tripController;

    @Autowired
    UserController userController;

    private final MockMultipartFile mockMultipartFile = new MockMultipartFile("test", new byte[0]);

    @Test
    public void testTripOverzichtPage() {
        ModelAndView mav = tripController.tripOverzichtPage(new MockHttpServletRequest(), null);

        assertEquals("Trip/tripOverzicht", mav.getViewName());
    }

    @Test
    public void tripSearchResult() {
        ModelAndView mav = tripController.tripSearchResult(new MockHttpServletRequest(), "Test");

        assertEquals("Trip/tripSearchResult", mav.getViewName());
    }

    @Test
    public void testAddTripPage() {
        ModelAndView mav = tripController.addTripPage(new MockHttpServletRequest(), null);

        assertEquals("Trip/addTrip", mav.getViewName());
    }

    @Test
    public void testAddTrip() {
        Trip t = getTrip();
        User u = getUser();
        t.setTripType("Tijdsgebonden");
        t.setStartDate(new java.util.Date(2013/03/15));
        t.setEndDate(new java.util.Date(2013/03/16));
        userController.addUser(u, mockMultipartFile);
        authenticateUser(u);

        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setParameter("dateUntill","2013/09/12");
        mockHttpServletRequest.setParameter("repetition","4m");
        String s = tripController.addTrip(t, null, mockHttpServletRequest);

        assertEquals("add trip", "redirect:/trip/tripOverzicht.html", s);
    }


    @Test
    public void testRepeatingTrip() {
        String s = "";
        Trip t = getTrip();
        t.setStartDate(new Date(2013, 3, 1));
        t.setEndDate(new Date(2013, 3, 10));
        User u = getUser();
        userController.addUser(u, mockMultipartFile);
        authenticateUser(u);

        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setParameter("dateUntil", "2013/05/30");

        mockHttpServletRequest.setParameter("repetition", "1d");
        s = tripController.addTrip(t, null, mockHttpServletRequest);
        assertEquals("add trip", "redirect:/trip/tripOverzicht.html", s);

        mockHttpServletRequest.setParameter("repetition", "1w");
        s = tripController.addTrip(t, null, mockHttpServletRequest);
        assertEquals("add trip", "redirect:/trip/tripOverzicht.html", s);

        mockHttpServletRequest.setParameter("repetition", "2w");
        s = tripController.addTrip(t, null, mockHttpServletRequest);
        assertEquals("add trip", "redirect:/trip/tripOverzicht.html", s);

        mockHttpServletRequest.setParameter("repetition", "4m");
        s = tripController.addTrip(t, null, mockHttpServletRequest);
        assertEquals("add trip", "redirect:/trip/tripOverzicht.html", s);
    }

    @Test
    public void testViewTripPage() {

        User u = getUser();
        userController.addUser(u, mockMultipartFile);
        authenticateUser(u);
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();

        Trip t = getTrip();
        ArrayList<StopPlaats> spList = new ArrayList<>();
        StopPlaats sp = new StopPlaats();
        sp.setInformatie("Test");
        spList.add(0,sp);
        t.setStopPlaatsen(spList);
        tripController.addTrip(t, null, mockHttpServletRequest);
        ModelAndView mav = tripController.viewTripPage(mockHttpServletRequest, null, t.getTripId());

        assertEquals("Trip/viewTrip", mav.getViewName());
    }

    @Test
    public void testJoinTrip() {
        String s = "";
        User u = getUser();
        userController.addUser(u, mockMultipartFile);
        authenticateUser(u);
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        Trip t = getTrip();
        t.setDeelnames(new ArrayList<Deelname>());

        tripController.addTrip(t, null, mockHttpServletRequest);
        s = tripController.joinTrip(mockHttpServletRequest, null, t.getTripId());


        assertEquals("join trip", "redirect:/trip/" + t.getTripId() + ".html", s);
    }

    @Test
    public void testLeaveTrip() {
        String s = "";
        User u = getUser();
        userController.addUser(u, mockMultipartFile);
        authenticateUser(u);
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();

        Trip t = getTrip();
        t.setDeelnames(new ArrayList<Deelname>());

        tripController.addTrip(t, null, mockHttpServletRequest);
        tripController.joinTrip(mockHttpServletRequest, null, t.getTripId());
        s = tripController.leaveTrip(mockHttpServletRequest, null, t.getTripId());


        assertEquals("join trip", "redirect:/trip/" + t.getTripId() + ".html", s);
    }

    @Test
    public void updateTrip() {
        User u = getUser();
        authenticateUser(u);

        Trip t = getTrip();
        tripController.addTrip(t, null, new MockHttpServletRequest());
        t.setTripDescription("blabla");
        String s = tripController.updateTrip(t, null);
        assertEquals("correct", "redirect:/user/admincp-" + t.getTripId() + ".html", s);

    }

    @Test
    public void deleteTrip() {

        User u = getUser();
        userController.addUser(u, mockMultipartFile);
        authenticateUser(u);
        Trip t = getTrip();
        t.setOrganiser(u);
        tripController.addTrip(t, null, new MockHttpServletRequest());

        tripController.deleteTrip(t.getTripId());
    }


    /*Chat gedeelte*/

    @Test
    public void testChat() {
        User u = getUser();
        userController.addUser(u, mockMultipartFile);
       Trip t = getTrip();

        authenticateUser(u);
        String s = tripController.addTrip(t, null, new MockHttpServletRequest());
        String msg = "test";
        tripController.addChat(t.getTripId(),msg);

        //TripController.ChatList cl = new TripController.ChatList();

      //  cl = tripController.getChats(t.getTripId());

       // assertEquals("correct",msg,cl.get(0).getMsg());

    }

    public Trip getTrip() {
        Trip t = new Trip();
        t.setTripName("Test");
        return t;
    }

    public User getUser() {
        User u = new User();
        u.setUsername("testunit");
        u.setPassword("test");
        return u;
    }

    public void authenticateUser(User u) {
        ArrayList<GrantedAuthority> g = new ArrayList<>();
        g.add(new SimpleGrantedAuthority("ROLE_USER"));


        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(u, u.getPassword(), g);

        Authentication auth = token;

        SecurityContextHolder.getContext().setAuthentication(auth);
    }


}
