package be.kdg.teamf.model;

import be.kdg.teamf.dao.TripDAO;
import be.kdg.teamf.service.TripService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Jerre
 * Date: 8/02/13
 * Time: 20:20
 * To change this template use File | Settings | File Templates.
 */

@ContextConfiguration(locations = {"classpath:spring-servlet.xml"})
public class TestTripModel {
     @Autowired
     protected TripDAO tripDAO;

    @Autowired
    protected TripService tripService;

    @Test
    public void addTrip() {
        Date d = new Date();
        Trip t = new Trip();

        t.setTripName("tripname");
        t.setEndDate(d);
        t.setOrganiser("organizer");
        t.setStartDate(d);
        t.setStartLocation("startlocation");
        t.setTripId(1);

        assertEquals("Expected id: 1", 1, t.getTripId());
        assertEquals("Expected tripname: tripname", "tripname", t.getTripName());
        assertEquals("Enddate", d, t.getEndDate());
        assertEquals("StartDate", d, t.getStartDate());
        assertEquals("Expected organizer: organizer", "organizer", t.getOrganiser());
        assertEquals("Expected startlocation: startlocation", "startlocation", t.getStartLocation());


    }



}
