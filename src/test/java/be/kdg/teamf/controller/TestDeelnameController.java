package be.kdg.teamf.controller;

import be.kdg.teamf.dao.DeelnameDAO;
import be.kdg.teamf.dao.TripDAO;
import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Trip;
import org.apache.struts.mock.MockHttpServletResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 5/03/13
 * Time: 13:07
 * To change this template use File | Settings | File Templates.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring-servlet.xml")
public class TestDeelnameController extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    TripDAO tripDAO;
    @Autowired
    DeelnameDAO deelnameDAO;

    @Autowired
    DeelnameController deelnameController;
    @Test
    public void testSendInvite(){
        Trip t = new Trip();
        tripDAO.addTrip(t);
        String s = deelnameController.sendInvite(t.getTripId(),"kdgteamf@gmail.com");
        assertEquals("correct","redirect:/TripParticipants/" + t.getTripId() + ".html",s);
    }

    @Test
    public void testTripParticipantsPage(){
        Trip t = new Trip();
        tripDAO.addTrip(t);
        ModelAndView mav =  deelnameController.tripParticipantsPage(new MockHttpServletRequest(),new MockHttpServletResponse(),t.getTripId());
        assertEquals("correct","User/tripParticipants",mav.getViewName());
    }

    @Test
    public void testEditUserequipment(){
        Deelname d = new Deelname();
        deelnameDAO.addDeelname(d);
        ModelAndView mav = deelnameController.editUserequipment(new MockHttpServletRequest(),new MockHttpServletResponse(),d.getDeelnameID());
        assertEquals("correct","User/editEquipment",mav.getViewName());
    }

    @Test
    public void testUpdateTripParticipants() {
        Trip t = new Trip();
        tripDAO.addTrip(t) ;
        Deelname d = new Deelname();
        d.setTrip(t);
        deelnameDAO.addDeelname(d);

        String s = deelnameController.updateTripParticipants(d,null,t.getTripId());

        assertEquals("correct","redirect:/user/admincp-" + d.getTrip().getTripId() + ".html",s);
    }

    @Test
    public void testUpdateDeelnemer() {
       Deelname d = new Deelname();
       Trip t = new Trip();
       tripDAO.addTrip(t);
        d.setTrip(t);
       deelnameDAO.addDeelname(d);
       String s = deelnameController.updateDeelnemer(d,null);
       assertEquals("correct","redirect:/TripParticipants/" + d.getTrip().getTripId() + ".html",s);
    }
}
