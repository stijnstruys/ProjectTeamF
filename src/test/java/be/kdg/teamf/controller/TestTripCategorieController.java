package be.kdg.teamf.controller;

import be.kdg.teamf.dao.TripCategorieDAO;
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

    @Autowired
    TripCategorieDAO tripCategorieDAO;

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
        TripCategorie tc = getTripCategorie();
        Trip t = maakTrip();

        String s = tripCategorieController.addTripCategorie(tc,null,t.getTripId());
        assertEquals("add trip","redirect:/TripCategorie/"+t.getTripId()+".html",s);
    }

    @Test
    public void testDeleteTripCategorie() {

        TripCategorie tc = getTripCategorie();
        Trip t = maakTrip();
        tc.setTrip(t);
        tripCategorieDAO.addTripCategorie(tc);
        String s = tripCategorieController.deleteTripCategorie(tc.getTripCategorieId());
        assertEquals("delete trip","redirect:/TripCategorie/" + tc.getTrip().getTripId() + ".html",s);
    }

    @Test
    public void testUpdateTripCategoriePage() {
        ModelAndView mav= null;
        TripCategorie tc = getTripCategorie();
        Trip t = maakTrip();
        t.setTripCategorieen(new ArrayList<TripCategorie>());
        tripDAO.addTrip(t);;
        tc.setTrip(t);

        tripCategorieDAO.addTripCategorie(tc);

        try {
            mav = tripCategorieController.updateTripCategoriePage(new MockHttpServletRequest(), null, tc.getTripCategorieId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("TripCategorie/updateTripCategorie", mav.getViewName());
    }

    @Test
    public void testUpdateTripCategorie() {

        Trip t = maakTrip();
        TripCategorie tc = getTripCategorie();
        String s = tripCategorieController.updateTripCategorie(tc,null,t.getTripId());
        assertEquals("update trip categorie","redirect:/TripCategorie/"+t.getTripId()+".html",s);
    }

    public TripCategorie getTripCategorie() {
        TripCategorie tc = new TripCategorie();
        tc.setTripCategorieName("Test");
        return tc;
    }
    private Trip maakTrip(){
        Trip t = new Trip();
        t.setTripCategorieen(new ArrayList<TripCategorie>());
        t.setTripName("TestTrip");
        tripDAO.addTrip(t);
        return  t;
    }
}
