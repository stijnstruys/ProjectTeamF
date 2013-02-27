package be.kdg.teamf.dao;

import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.TripCategorie;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 17-2-13
 * Time: 11:52
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring-servlet.xml")
public class TestTripCategorieDAO extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    protected TripCategorieDAO tripCategorieDAO;
    @Autowired
    private TripDAO tripDAO;

    @Test
    public void testAddTripCategorie() {
        TripCategorie tc = getTripCategorie();
        tripCategorieDAO.addTripCategorie(tc);
        assertEquals("Excepeted name: ", "Dropping", tripCategorieDAO.findTripCategorie(tc.getTripCategorieId()).getTripCategorieName());
    }

    @Test
    public void testDeleteTripCategorie(){
        TripCategorie tc = getTripCategorie();
        tripCategorieDAO.addTripCategorie(tc);
        tripCategorieDAO.removeTripCategorie(tc);
    }

    @Test
    public void testUpdateTripCategorie() {
        TripCategorie tc = getTripCategorie();
        tripCategorieDAO.addTripCategorie(tc);

        tc.setTripCategorieName("Iets anders");
        tripCategorieDAO.updateTripCategorie(tc);
        tc.setTripCategorieName("Reis");
        tripCategorieDAO.updateTripCategorie(tc);
        assertEquals("Excepeted name: ", "Reis", tripCategorieDAO.findTripCategorie(tc.getTripCategorieId()).getTripCategorieName());

    }

    @Test
    public void testFindTripCategorie() {
        TripCategorie tc = getTripCategorie();
        tripCategorieDAO.addTripCategorie(tc);
        assertEquals("Excepted : ", tc.getTripCategorieName(), tripCategorieDAO.findTripCategorie(tc.getTripCategorieId()).getTripCategorieName());
    }
    @Test
    public void testCategoriesVanTrip() {
        TripCategorie tc = getTripCategorie();
        Trip t = new Trip();

        t.setTripCategorieen(new ArrayList<TripCategorie>());
        t.getTripCategorieen().add(tc);
        tc.setTrip(t);
        tripDAO.addTrip(t);

        assertEquals("Excepted : ",t.getTripCategorieen().size(), tripCategorieDAO.getTripCategories(t.getTripId()).size());
    }

    private TripCategorie  getTripCategorie() {
        TripCategorie tc = new TripCategorie();
        tc.setTripCategorieName("Dropping");
        return tc;
    }

}
