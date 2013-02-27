package be.kdg.teamf.service;

import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.TripCategorie;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 27/02/13
 * Time: 12:37
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring-servlet.xml")
public class TestTripCategorieService extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    TripCategorieService tripCategorieService;
    @Autowired
    TripService tripService;

    @Test
    public void addCategorie(){


        TripCategorie tc = new TripCategorie();
        tc.setTripCategorieName("categorie");
        tripCategorieService.addTripCategorie(tc);

        assertEquals("categorie niet gevonden",tc.getTripCategorieName(),tripCategorieService.findTripCategorie(tc.getTripCategorieId()).getTripCategorieName());
    }
    @Test
    public void updateCategorie(){


        TripCategorie tc = new TripCategorie();
        tc.setTripCategorieName("categorie");
        tripCategorieService.addTripCategorie(tc);
        tc.setTripCategorieName("anders");
        tripCategorieService.updateTripCategorie(tc);

        assertEquals("categorie niet gevonden", tc.getTripCategorieName(), tripCategorieService.findTripCategorie(tc.getTripCategorieId()).getTripCategorieName());
    }
    @Test
    public void deleteCategorie(){


        TripCategorie tc = new TripCategorie();

        tc.setTripCategorieName("categorie");
        tripCategorieService.addTripCategorie(tc);
        tripCategorieService.removeTripCategorie(tc);

        assertNull(tripCategorieService.findTripCategorie(tc.getTripCategorieId()));
    }
    @Test
    public void listCategories(){

        TripCategorie tc = new TripCategorie();
        tc.setTripCategorieName("test");
        Trip t = new Trip();

        t.setTripCategorieen(new ArrayList<TripCategorie>());
        t.getTripCategorieen().add(tc);
        tc.setTrip(t);
        tripService.addTrip(t);

        assertEquals("Excepted : ", t.getTripCategorieen().size(), tripCategorieService.getTripCategories(t.getTripId()).size());

    }
}
