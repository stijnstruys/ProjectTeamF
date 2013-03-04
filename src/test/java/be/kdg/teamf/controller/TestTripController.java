package be.kdg.teamf.controller;

import be.kdg.teamf.model.StopPlaats;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import be.kdg.teamf.service.UserService;
import com.sun.security.auth.UserPrincipal;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.text.ParseException;
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

    private final MockMultipartFile mockMultipartFile = new MockMultipartFile("test",new byte[0]);

    @Test
    public void testTripOverzichtPage() {
        ModelAndView mav= null;
        try {
            mav = tripController.tripOverzichtPage(new MockHttpServletRequest(),null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("Trip/tripOverzicht", mav.getViewName());
    }

    @Test
    public void tripSearchResult() {
        ModelAndView mav= null;
        try {
            mav = tripController.tripSearchResult(new MockHttpServletRequest(),"Test");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("Trip/tripSearchResult", mav.getViewName());
    }

    @Test
    public void testAddTripPage() {
        ModelAndView mav= null;
        try {
            mav = tripController.addTripPage(new MockHttpServletRequest(),null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("Trip/addTrip", mav.getViewName());
    }

    @Test
    public void testAddTrip() {
      String s="";
        Trip t = getTrip();
        User u = getUser();
        userController.addUser(u,mockMultipartFile);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(u.getUsername(), u.getPassword());
        Authentication auth = token;
        SecurityContextHolder.getContext().setAuthentication(auth);

        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();

        try {
            s = tripController.addTrip(t,null,"1",mockHttpServletRequest);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals("add trip","redirect:/trip/tripOverzicht.html",s);
    }

    @Test
    public void testViewTripPage() {
        ModelAndView mav= null;
        User u = getUser();
        userController.addUser(u,mockMultipartFile);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(u.getUsername(), u.getPassword());
        Authentication auth = token;
        SecurityContextHolder.getContext().setAuthentication(auth);
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();

        Trip t = getTrip();
        t.setStopPlaatsen(new ArrayList<StopPlaats>());
        try {
            tripController.addTrip(t,null,"1",mockHttpServletRequest);
            mav = tripController.viewTripPage(mockHttpServletRequest, null, t.getTripId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("Trip/viewTrip", mav.getViewName());
    }

    @Test
    public void testJoinTrip() {
        String s ="";
        User u = getUser();
        userController.addUser(u,mockMultipartFile);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(u.getUsername(), u.getPassword());
        Authentication auth = token;
        SecurityContextHolder.getContext().setAuthentication(auth);
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();

        try {
            s = tripController.joinTrip(mockHttpServletRequest,null,91);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals("join trip","redirect:/trip/91.html",s);
    }

    @Test
    public void testLeaveTrip() {
        String s ="";
        User u = getUser();
        userController.addUser(u,mockMultipartFile);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(u.getUsername(), u.getPassword());
        Authentication auth = token;
        SecurityContextHolder.getContext().setAuthentication(auth);
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();

        try {
            s = tripController.leaveTrip(mockHttpServletRequest, null, 91);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals("join trip","redirect:/trip/91.html",s);
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



}
