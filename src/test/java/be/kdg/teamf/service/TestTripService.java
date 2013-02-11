package be.kdg.teamf.service;

import be.kdg.teamf.model.Trip;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertSame;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 11/02/13
 * Time: 23:46
 * To change this template use File | Settings | File Templates.
 */

@ContextConfiguration("classpath:spring-servlet.xml")
public class TestTripService extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    protected TripService tripService;

    @Test
    public void testSearchTrips() throws Exception {

        Trip trip = new Trip();
        trip.setTripName("tripJeroen123");
        tripService.addTrip(trip);
        assertTrue("User not found", tripService.searchTrips("Jeroen").contains(trip));

    }
}
