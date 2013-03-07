package be.kdg.teamf.service;

import be.kdg.teamf.model.StopPlaats;
import be.kdg.teamf.model.Trip;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 27/02/13
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring-servlet.xml")
public class TestStopPlaatsService extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    StopPlaatsService stopPlaatsService;
    @Autowired
    TripService tripService;
    @Test
    public void addStopPlaats(){
        StopPlaats s = new StopPlaats();
        stopPlaatsService.addStopPlaats(s);
        assertEquals("stopplaats not found",s.getStopPlaatsID(),stopPlaatsService.findStopPlaats(s.getStopPlaatsID()).getStopPlaatsID());

    }

    @Test
    public void updateStopPlaats(){
        StopPlaats s = new StopPlaats();
        s.setAdres("Antwerpen");
        stopPlaatsService.addStopPlaats(s);
        s.setAdres("Groenplaats");
        stopPlaatsService.updateStopPlaats(s);
        assertEquals("stopplaats not found", s.getAdres(), stopPlaatsService.findStopPlaats(s.getStopPlaatsID()).getAdres());

    }

    @Test
    public void deleteStopPlaats(){
        StopPlaats s = new StopPlaats();
        stopPlaatsService.addStopPlaats(s);
        stopPlaatsService.deleteStopPlaats(s);
        assertFalse("triptype  found", stopPlaatsService.listStopPlaatsen().contains(s));
    }

    @Test
    public void testStopPlaatsenByTrip(){

        Trip t = new Trip();
        t.setStopPlaatsen(new ArrayList<StopPlaats>());
        t.setTripId(1);

        StopPlaats s = new StopPlaats();
        t.getStopPlaatsen().add(s);

        s.setTrip(t);
        tripService.addTrip(t);

        ArrayList<Trip>  trips = new ArrayList<>();
        trips.add(t);

        assertEquals("tripsize not 1",trips.size() ,stopPlaatsService.getStopPlaatsenByTripId(t.getTripId()).size());
    }

    @Test
       public void controleerAntwoord(){
        StopPlaats sp = new StopPlaats();
        sp.setCorrectAntwoord("antw1");
           stopPlaatsService.controleerAntwoord("antw1", sp);
       }
}
