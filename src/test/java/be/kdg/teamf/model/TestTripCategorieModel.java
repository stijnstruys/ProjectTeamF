package be.kdg.teamf.model;

import be.kdg.teamf.dao.TripCategorieDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 18/02/13
 * Time: 21:21
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations = {"classpath:spring-servlet.xml"})
public class TestTripCategorieModel {

    @Autowired
    protected TripCategorieDAO tripCategorieDAO;

    @Test
    public void addTripCategorie() throws Exception {

        TripCategorie tc = new TripCategorie();
        Trip t = new Trip();

        tc.setTrip(t);
        tc.setTripCategorieId(1);
        tc.setTripCategorieName("stadswandeling");

        assertEquals("Expected adres: ", t, tc.getTrip());
        assertEquals("Expected adres: ", 1, tc.getTripCategorieId());
        assertEquals("Expected adres: ", "stadswandeling", tc.getTripCategorieName());
    }
}
