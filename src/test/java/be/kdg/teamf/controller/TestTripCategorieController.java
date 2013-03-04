package be.kdg.teamf.controller;

import be.kdg.teamf.dao.TripDAO;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.TripCategorie;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 4-3-13
 * Time: 18:14
 * To change this template use File | Settings | File Templates.
 */
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring-servlet.xml")
public class TestTripCategorieController extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    TripCategorieController tripCategorieController;

    @Autowired
    TripDAO tripDAO;

    @Test
    public void testTripCategoriePage() {
        ModelAndView mav= null;
        Trip t = new Trip();
        tripDAO.addTrip(t);

        try {
            mav = tripCategorieController.tripCategoriePage(new MockHttpServletRequest(),null,t.getTripId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("TripCategorie/tripCategorie", mav.getViewName());
    }

    @Test
    public void testAddTripCategorie() {
        String s ="";
        TripCategorie tc = getTripCategorie();
        Trip t = new Trip();
        t.setTripCategorieen(new ArrayList<TripCategorie>());
        t.setTripName("TestTrip");
        tripDAO.addTrip(t);

        s = tripCategorieController.addTripCategorie(tc,null,t.getTripId());
        assertEquals("add trip","redirect:/TripCategorie/"+t.getTripId()+".html",s);
    }

    @Test
    public void testDeleteTripCategorie() {
        String s ="";
        Trip t = new Trip();
        tripDAO.addTrip(t);

        s = tripCategorieController.deleteTripCategorie(4);
        assertEquals("delete trip","redirect:/TripCategorie/91.html",s);
    }

    @Test
    public void testUpdateTripCategoriePage() {
        ModelAndView mav= null;

        try {
            mav = tripCategorieController.updateTripCategoriePage(new MockHttpServletRequest(), null, 4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("TripCategorie/updateTripCategorie", mav.getViewName());
    }

    @Test
    public void testUpdateTripCategorie() {
        String s ="";
        Trip t = new Trip();
        tripDAO.addTrip(t);
        TripCategorie tc = getTripCategorie();
        s = tripCategorieController.updateTripCategorie(tc,null,t.getTripId());
        assertEquals("update trip categorie","redirect:/TripCategorie/"+t.getTripId()+".html",s);
    }

    public TripCategorie getTripCategorie() {
        TripCategorie tc = new TripCategorie();
        tc.setTripCategorieName("Test");
        return tc;
    }

}
