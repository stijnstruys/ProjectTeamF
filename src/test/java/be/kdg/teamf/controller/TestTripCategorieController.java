package be.kdg.teamf.controller;

import be.kdg.teamf.model.TripCategorie;
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
 * Time: 18:14
 * To change this template use File | Settings | File Templates.
 */
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring-servlet.xml")
public class TestTripCategorieController extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    TripCategorieController tripCategorieController;

    @Test
    public void testTripCategoriePage() {
        ModelAndView mav= null;

        try {
            mav = tripCategorieController.tripCategoriePage(new MockHttpServletRequest(),null,101);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        assertEquals("TripCategorie/tripCategorie", mav.getViewName());
    }

    @Test
    public void testAddTripCategorie() {
        String s ="";
        TripCategorie tc = getTripCategorie();

        s = tripCategorieController.addTripCategorie(tc,null,91);
        assertEquals("add trip","redirect:/TripCategorie/91.html",s);
    }

    @Test
    public void testDeleteTripCategorie() {
        String s ="";
        s = tripCategorieController.deleteTripCategorie(4);
        assertEquals("delete trip","redirect:/TripCategorie/91.html",s);
    }

    @Test
    public void testUpdateTripCategoriePage() {
        ModelAndView mav= null;

        try {
            mav = tripCategorieController.updateTripCategoriePage(new MockHttpServletRequest(),null,4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("TripCategorie/updateTripCategorie", mav.getViewName());
    }

    @Test
    public void testUpdateTripCategorie() {
        String s ="";
        TripCategorie tc = getTripCategorie();
        s = tripCategorieController.updateTripCategorie(tc,null,91);
        assertEquals("update trip","redirect:/TripCategorie/91.html",s);
    }

    public TripCategorie getTripCategorie() {
        TripCategorie tc = new TripCategorie();
        tc.setTripCategorieName("Test");
        return tc;
    }

}
