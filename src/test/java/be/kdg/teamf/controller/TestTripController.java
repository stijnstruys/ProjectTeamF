package be.kdg.teamf.controller;

import be.kdg.teamf.dao.TripTypeDAO;
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

    @Autowired
    TripTypeDAO tripTypeDAO;

    private final MockMultipartFile mockMultipartFile = new MockMultipartFile("test",new byte[0]);

    @Test
    public void testTripOverzichtPage() {
        ModelAndView mav=  tripController.tripOverzichtPage(new MockHttpServletRequest(),null);

        assertEquals("Trip/tripOverzicht", mav.getViewName());
    }

    @Test
    public void tripSearchResult() {
        ModelAndView mav= tripController.tripSearchResult(new MockHttpServletRequest(),"Test");

        assertEquals("Trip/tripSearchResult", mav.getViewName());
    }

    @Test
    public void testAddTripPage() {
        ModelAndView mav= tripController.addTripPage(new MockHttpServletRequest(),null);

        assertEquals("Trip/addTrip", mav.getViewName());
    }

    @Test
    public void testAddTrip() {
         TripType tt=  getTripType();
        Trip t = getTrip();
        User u = getUser();
        userController.addUser(u,mockMultipartFile);
        authenticateUser(u);

        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();


      String  s = tripController.addTrip(t,null,tt.getTripTypeId(),mockHttpServletRequest);

        assertEquals("add trip","redirect:/trip/tripOverzicht.html",s);
    }
    @Test
    public void testRepeatingTrip() {
        TripType tt=  new TripType();
        tt.setTripTypeName("repeating");
        tripTypeDAO.addTripType(tt);
        String s="";
        Trip t = getTrip();
        t.setStartDate(new Date(2013,3,1));
        t.setEndDate(new Date(2013, 3, 10));
        User u = getUser();
        userController.addUser(u,mockMultipartFile);
        authenticateUser(u);

        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setParameter("dateUntil","2013/05/30");

        mockHttpServletRequest.setParameter("repetition","1d");
        s = tripController.addTrip(t,null,tt.getTripTypeId(),mockHttpServletRequest);
        assertEquals("add trip","redirect:/trip/tripOverzicht.html",s);

        mockHttpServletRequest.setParameter("repetition","1w");
        s = tripController.addTrip(t,null,tt.getTripTypeId(),mockHttpServletRequest);
        assertEquals("add trip","redirect:/trip/tripOverzicht.html",s);

        mockHttpServletRequest.setParameter("repetition","2w");
        s = tripController.addTrip(t,null,tt.getTripTypeId(),mockHttpServletRequest);
        assertEquals("add trip","redirect:/trip/tripOverzicht.html",s);

        mockHttpServletRequest.setParameter("repetition","4m");
        s = tripController.addTrip(t,null,tt.getTripTypeId(),mockHttpServletRequest);
        assertEquals("add trip","redirect:/trip/tripOverzicht.html",s);
    }
    @Test
    public void testViewTripPage() {
        TripType tt= getTripType();

        User u = getUser();
        userController.addUser(u,mockMultipartFile);
        authenticateUser(u);
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();

        Trip t = getTrip();
        t.setStopPlaatsen(new ArrayList<StopPlaats>());

        tripController.addTrip(t,null,tt.getTripTypeId(),mockHttpServletRequest);
        ModelAndView mav=   mav = tripController.viewTripPage(mockHttpServletRequest, null, t.getTripId());

        assertEquals("Trip/viewTrip", mav.getViewName());
    }

    private TripType getTripType() {

        TripType tt = new TripType();
        tt.setTripTypeName("test");
        tripTypeDAO.addTripType(tt);
        return  tt;
    }

    @Test
    public void testJoinTrip() {
        TripType tt=  getTripType();
        String s ="";
        User u = getUser();
        userController.addUser(u,mockMultipartFile);
        authenticateUser(u);
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        Trip t = getTrip();
        t.setDeelnames(new ArrayList<Deelname>());

        tripController.addTrip(t,null,tt.getTripTypeId(),mockHttpServletRequest);
        s = tripController.joinTrip(mockHttpServletRequest,null,t.getTripId());


        assertEquals("join trip","redirect:/trip/"+t.getTripId()+".html",s);
    }

    @Test
    public void testLeaveTrip() {
        TripType tt=  getTripType();
        String s ="";
        User u = getUser();
        userController.addUser(u,mockMultipartFile);
        authenticateUser(u);
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();

        Trip t = getTrip();
        t.setDeelnames(new ArrayList<Deelname>());

        tripController.addTrip(t,null,tt.getTripTypeId(),mockHttpServletRequest);
        tripController.joinTrip(mockHttpServletRequest, null, t.getTripId());
        s = tripController.leaveTrip(mockHttpServletRequest, null, t.getTripId());


        assertEquals("join trip","redirect:/trip/"+t.getTripId()+".html",s);
    }

    @Test
    public void updateTrip(){
        TripType tt = getTripType();
        User u = getUser();
        authenticateUser(u);

        Trip t = getTrip();
        tripController.addTrip(t,null,tt.getTripTypeId(),new MockHttpServletRequest());
        t.setTripDescription("blabla");
        String s = tripController.updateTrip(t,null);
        assertEquals("correct","redirect:/user/admincp-" + t.getTripId() + ".html",s);

    }
    @Test
    public void deleteTrip(){
        TripType tt = getTripType();

        User u = getUser();
        userController.addUser(u,mockMultipartFile);
        authenticateUser(u);
        Trip t = getTrip();
        t.setOrganiser(u);
        tripController.addTrip(t,null,tt.getTripTypeId(),new MockHttpServletRequest());

        tripController.deleteTrip(t.getTripId());
    }

    public Trip getTrip() {
        Trip t = new Trip();
        t.setTripName("Test");
        return t;
    }

    public User getUser(){
        User u = new User();
        u.setUsername("testunit");
        u.setPassword("test");
        return u;
    }
    public void authenticateUser(User u){
        ArrayList<GrantedAuthority> g = new ArrayList<>();
        g.add(new SimpleGrantedAuthority("ROLE_USER"));


        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(u, u.getPassword(),g);

        Authentication auth = token;

        SecurityContextHolder.getContext().setAuthentication(auth);
    }


}
