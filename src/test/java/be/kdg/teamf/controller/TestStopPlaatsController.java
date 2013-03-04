package be.kdg.teamf.controller;

import be.kdg.teamf.dao.TripDAO;
import be.kdg.teamf.model.StopPlaats;
import be.kdg.teamf.model.Trip;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 4-3-13
 * Time: 19:37
 * To change this template use File | Settings | File Templates.
 */
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring-servlet.xml")
public class TestStopPlaatsController extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    StopPlaatsController stopPlaatsController;

    @Autowired
    TripDAO tripDAO;

    @Test
    public void testManageStopPlaatsPage() {
        ModelAndView mav= null;
        Trip t = new Trip();
        tripDAO.addTrip(t);
        try {
            mav = stopPlaatsController.manageStopPlaatsPage(new MockHttpServletRequest(),null,t.getTripId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals("StopPlaats/ManageStopPlaatsen", mav.getViewName());
    }

    @Test
    public void testAddStopPlaats() {
        Trip t = new Trip();
        tripDAO.addTrip(t);
        StopPlaats sp = getStopPlaats();
        String s ="";

        s = stopPlaatsController.addStopPlaats(sp,null, t.getTripId());

        assertEquals("add trip","redirect:/StopPlaats/"+t.getTripId()+".html",s);
    }

    @Test
    public void testDeleteStopPlaats() {

    }

    @Test
    public void testUpdateStopPlaatsPage() {
        ModelAndView mav= null;

        try {
            mav = stopPlaatsController.updateStopPlaatsPage(new MockHttpServletRequest(), null, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals("StopPlaats/updateStopPlaats", mav.getViewName());
    }

    @Test
    public void testUpdateStopPlaats() {
        Trip t = new Trip();
        tripDAO.addTrip(t);
        StopPlaats sp = getStopPlaats();
        String s ="";

        s = stopPlaatsController.updateStopPlaats(sp,null,t.getTripId());

        assertEquals("update trip","redirect:/StopPlaats/"+t.getTripId()+".html",s);
    }

    @Test
    public void testReleaseStopPlaats() {
        StopPlaats sp = getStopPlaats();
        String s="";

        s = stopPlaatsController.releaseStopPlaats(sp,null,1);
        assertEquals("release trip","redirect:/user/admincp-91.html",s);
    }

    @Test
    public void testUpdateTrip() {
        Trip t = new Trip();
        tripDAO.addTrip(t);
        String s="";

        s = stopPlaatsController.updateTrip(t,null);

        assertEquals("update trip","redirect:/StopPlaats/" + t.getTripId() + ".html",s);
    }


    public StopPlaats getStopPlaats() {
        StopPlaats sp = new StopPlaats();
        sp.setVrijgegeven(true);
        sp.setAdres("Test");
        sp.setInformatie("Test");
        return sp;
    }
}
