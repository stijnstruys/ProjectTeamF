package be.kdg.teamf.dao;

import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: BART.LEEMANS
 * Date: 15/02/13
 * Time: 9:30
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring-servlet.xml")
public class TestTripDAO extends AbstractTransactionalJUnit4SpringContextTests{
    private Trip trip;

    @Autowired
    protected TripDAO tripDAO;

    @Autowired
    protected UserDAO userDAO;
    @Test
    public void testAddTrip() {
        int id = 1;
        User u = new User();

        Trip t = getTrip();
        tripDAO.addTrip(t);
        assertEquals("Expected organiser: ", u, tripDAO.findTrip(t.getTripId()).getOrganiser());
        assertEquals("Expected name: ", "Dropping", tripDAO.findTrip(t.getTripId()).getTripName());
    }

    @Test
    public void updateTrip() {
        Trip t = getTrip();
        t.setTripName("Dropping");
        tripDAO.addTrip(t);
        t.setTripName("Dropping door scouts");
        tripDAO.updateTrip(t);
        assertEquals("Expected name: ", "Dropping door scouts", tripDAO.findTrip(t.getTripId()).getTripName());

    }

    @Test
    public void removeTrip() {
        addTrip();
        tripDAO.removeTrip(trip.getTripId());
        assertTrue("Trip not found", !tripDAO.listTrips().contains(trip));
    }

    @Test
    public void listTrips() {
        addTrip();
        assertNotNull("Trip", tripDAO.listTrips());
    }


    @Test
    public void searchTrips() {
        addTrip();
        List<Trip> trips = tripDAO.searchTrips("Dropping");
        assertNotNull("Trip", trips);
    }

    @Test
    public void findTrip() {
        addTrip();
        Trip findT = tripDAO.findTrip(trip.getTripId());
        assertEquals("Excpected name: ", "Dropping", findT.getTripName());
    }

    @Test
    public void getTripNames() {
        addTrip();
        assertNotNull("  ", tripDAO.getTripNames());
    }

    private Trip getTrip() {
        Trip t = new Trip();
        List deelnames = new ArrayList();
        Deelname d1 = new Deelname();
        Deelname d2 = new Deelname();
        User u1 = new User();
        u1.setUsername("JeroenD");
        User u2 = new User();
        u2.setUsername("JeroenV");
        User u3 = new User();
        u3.setUsername("JeroenVerb");
       /* d1.setDeelnameID(1);
        d1.setUser(u1);
        deelnames.add(d1);
        d2.setDeelnameID(2);
        d2.setUser(u2);
        deelnames.add(d2);*/

        //t.setTripId(1);
        userDAO.addUser(u3);

        t.setTripName("Dropping");
        t.setStartDate(new Date("02/05/2013"));
        t.setEndDate(new Date("02/05/2013"));
        t.setOrganiser(u3);

        t.setDeelnames(deelnames);
        return t;
    }

    private void addTrip() {
        trip = getTrip();
        tripDAO.addTrip(trip);
    }
}
