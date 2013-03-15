package be.kdg.teamf.controller;

import be.kdg.teamf.dao.TripDAO;
import be.kdg.teamf.model.BroadcastMessage;
import be.kdg.teamf.model.Trip;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 13-3-13
 * Time: 9:39
 * To change this template use File | Settings | File Templates.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring-servlet.xml")
public class TestBroadcastMessageController extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    BroadcastMessageController broadcastMessageController;
    @Autowired
    TripDAO tripDAO;

    @Test
    public void testBroadcastMessagePage() {
        Trip t = getTrip();
        tripDAO.addTrip(t);

        ModelAndView mav = broadcastMessageController.broadcastMessagePage(new MockHttpServletRequest(),new MockHttpServletResponse(),t.getTripId());

        assertEquals("Correct","Broadcast/broadcastMessage",mav.getViewName());
    }

    @Test
    public void testAddBroadcastMessage() {
        Trip t = getTrip();
        tripDAO.addTrip(t);
        BroadcastMessage broadcastMessage = new BroadcastMessage();
        broadcastMessage.setMsg("Test");

        String s = broadcastMessageController.addBroadcastMessage(broadcastMessage, null,t.getTripId());

        assertEquals("Correct:","redirect:/BroadcastMessage/" + t.getTripId() + ".html",s);
    }

    private Trip getTrip() {
        Trip t = new Trip();
        t.setTripName("Test");
        t.setBroadcastMessages(new ArrayList<BroadcastMessage>());
        return t;
    }
}
