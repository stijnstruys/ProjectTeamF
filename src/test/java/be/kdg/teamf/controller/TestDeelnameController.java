package be.kdg.teamf.controller;

import be.kdg.teamf.dao.DeelnameDAO;
import be.kdg.teamf.dao.TripDAO;
import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Trip;
import org.apache.struts.mock.MockHttpServletResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 5/03/13
 * Time: 13:07
 * To change this template use File | Settings | File Templates.
 */
public class TestDeelnameController {

    @Autowired
    TripDAO tripDAO;
    @Autowired
    DeelnameDAO deelnameDAO;

    @Autowired
    DeelnameController deelnameController;
    @Test
    public void testMails(){
        Trip t = new Trip();
        tripDAO.addTrip(t);
        String s = deelnameController.sendInvite(t.getTripId(),"kdgteamf@gmail.com");
        assertEquals("correct","redirect:/TripParticipants/" + t.getTripId() + ".html",s);
    }
    @Test
    public void testParticipants(){
        Trip t = new Trip();
        tripDAO.addTrip(t);
        ModelAndView mav =  deelnameController.tripParticipantsPage(new MockHttpServletRequest(),new MockHttpServletResponse(),t.getTripId());
        assertEquals("correct","User/tripParticipants",mav.getViewName());
    }
    @Test
    public void testUserEquipment(){
        Deelname d = new Deelname();
        deelnameDAO.addDeelname(d);
        ModelAndView mav = deelnameController.editUserequipment(new MockHttpServletRequest(),new MockHttpServletResponse(),d.getDeelnameID());
        assertEquals("correct","User/editEquipment",mav.getViewName());
    }
}
