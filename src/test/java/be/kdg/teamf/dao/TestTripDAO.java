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
public class TestTripDAO extends AbstractTransactionalJUnit4SpringContextTests {
    private Trip trip;

    @Autowired
    protected TripDAO tripDAO;

    @Autowired
    protected UserDAO userDAO;

    @Autowired
    protected DeelnameDAO deelnameDAO;

    @Test
    public void testAddTrip() {


        Trip t = getTrip();

        tripDAO.addTrip(t);
        assertEquals("Expected organiser: ", t.getOrganiser().getUserID(), tripDAO.findTrip(t.getTripId()).getOrganiser().getUserID());
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

    @Test
    public void testListPublicTrips() {
        Trip t = new Trip();
        t.setTripId(1);
        t.setVisible(true);
        tripDAO.addTrip(t);
        assertEquals("Expected size:", 1, tripDAO.listPublicTrips().size());
    }

    @Test
    public void testListUserEmailPerTrips() {
        User u = new User();
        u.setUserID(1);
        u.setEmail("kdgteamf@gmail.com");
        u.setNotificationEmail(true);
        Trip t = new Trip();
        t.setTripId(1);
        Deelname d = new Deelname();
        d.setTrip(t);
        d.setUser(u);
        userDAO.addUser(u);
        tripDAO.addTrip(t);
        deelnameDAO.addDeelname(d);
        assertEquals("Expected size:", 1, tripDAO.listUserEmailPerTrips(t.getTripId()).size());
    }

    private Trip getTrip() {
        Trip t = new Trip();
        List deelnames = new ArrayList();
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
        t.setNotification("Kijk daar");
        t.setEquipment(new ArrayList<String>());
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
