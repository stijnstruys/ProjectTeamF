package be.kdg.teamf.service;

import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.TripCategorie;
import be.kdg.teamf.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.ui.ModelMap;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.*;


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
    private SimpleMailMessage message;
    @Autowired
    protected TripService tripService;
    @Autowired
    protected UserService userService;
    @Autowired
    protected DeelnameService deelnameService;
    @Autowired
    protected TripCategorieService tripCategorieService;

    @Test
    public void testSearchTrip() {

        Trip trip = new Trip();
        Date d = new Date("31/12/2020");
        trip.setEndDate(d);
        trip.setTripName("tripJeroen123");
        tripService.addTrip(trip);
        assertTrue("Trip not found", tripService.searchTrips("Jeroen").contains(trip));

    }

    @Test
    public void testUpdateTrip() {

        Trip trip = new Trip();
        trip.setTripName("tripJeroen123");
        tripService.addTrip(trip);
        trip.setTripName("trip321");
        tripService.updateTrip(trip);
        assertEquals("Trip not found", "trip321", tripService.findTrip(trip.getTripId()).getTripName());

    }

    @Test
    public void testDeleteTrip() {

        Trip trip = new Trip();
        trip.setTripName("tripJeroen123");
        tripService.addTrip(trip);
        tripService.deleteTrip(trip.getTripId());
        assertFalse("Trip not found", tripService.searchTrips("tripJeroen123").contains(trip));

    }

    @Test
    public void testSendMail() {

        ModelMap mailModel = new ModelMap();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        mailModel.addAttribute("title", "Trip update");
        mailModel.addAttribute("subtitle1", "Message from organiser");
        mailModel.addAttribute("message", "testmessage");
        mailModel.addAttribute("subtitle2", "The following trip changes occured");
        mailModel.addAttribute("text", "testtext");
        mailModel.addAttribute("date", format.format(new Date()));
        SimpleMailMessage msg = new SimpleMailMessage(message);
        SimpleMailMessage msg2 = new SimpleMailMessage(message);
        msg.setCc("kdgteamf@gmail.com");
        msg2.setTo("kdgteamf@gmail.com");
        try {
            tripService.sendInvite(mailModel, msg2);
            tripService.sendMail(mailModel, msg);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void testSearchTripsCategorie() {
        Date d = new Date("31/12/2020");
        Trip trip = new Trip();
        ArrayList<TripCategorie> tcs = new ArrayList<>();
        TripCategorie tc = new TripCategorie();
        tc.setTrip(trip);
        tc.setTripCategorieName("test");

        tcs.add(tc);
        trip.setTripCategorieen(tcs);
        trip.setTripName("tripJeroen123");
        trip.setVisible(true);
        trip.setEndDate(d);
        tripCategorieService.addTripCategorie(tc);
        tripService.addTrip(trip);
        assertTrue("Trip not found", tripService.searchTripsCategories("test").contains(trip));

    }

    @Test
    public void testListTrip() {
        Trip trip = new Trip();
        trip.setTripName("tripJeroen123");
        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(trip);
        tripService.addTrip(trip);
        assertEquals("Trips not found", trips.size(), tripService.listTrips().size());

    }

    @Test
    public void testOwnership() {
        User u1 = new User();
        User u2 = new User();

        u1.setUserID(1);
        u2.setUserID(2);
        Trip trip = new Trip();
        trip.setTripName("tripJeroen123");
        trip.setOrganiser(u1);
        userService.addUser(u1);
        userService.addUser(u2);
        tripService.addTrip(trip);
        assertTrue("Not owner", tripService.checkOwnership(trip, u1));
        assertFalse("owner", tripService.checkOwnership(trip, u2));

    }

    @Test
    public void testFindTrip() {

        Trip trip = new Trip();
        trip.setTripName("tripJeroen123");
        ArrayList<String> tripnames = new ArrayList<>();
        tripnames.add("tripJeroen123");
        tripService.addTrip(trip);
        assertEquals("Not owner", tripnames, tripService.getTripNames());

    }

    @Test
    public void testListUserParticipateTrips() {
        User u = new User();
        u.setUserID(1);
        Trip trip = new Trip();
        trip.setTripId(1);
        Deelname d = new Deelname();
        d.setDeelnameID(1);
        d.setTrip(trip);
        d.setUser(u);
        ArrayList<Trip> trips = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Deelname> deelnames = new ArrayList<>();
        trips.add(trip);
        users.add(u);
        deelnames.add(d);
        tripService.addTrip(trip);
        userService.addUser(u);
        deelnameService.addDeelname(d);
        assertEquals("Participants", trips, tripService.listUserParticipateTrips(u.getUserID()));
    }

    @Test
    public void testListUserTrip() {
        User u = new User();
        u.setUserID(1);
        Trip trip = new Trip();
        trip.setOrganiser(u);
        trip.setTripName("tripJeroen123");
        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(trip);
        userService.addUser(u);
        tripService.addTrip(trip);
        assertEquals("Not owner", trips, tripService.listUserTrips(u.getUserID()));
    }

    @Test
    public void testFindTripID() {

        Trip trip = new Trip();
        trip.setTripName("tripJeroen123");
        trip.setTripId(1);
        tripService.addTrip(trip);

        assertEquals("Trip not found", trip, tripService.findTrip(trip.getTripId()));
    }

    @Test
    public void testListPublicTrip() {
        Trip trip = new Trip();
        trip.setVisible(true);
        trip.setTripName("tripJeroen123");
        Date d = new Date("31/12/2020");
        trip.setEndDate(d);
        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(trip);
        tripService.addTrip(trip);
        assertEquals("public trips", trips, tripService.listPublicTrips());
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
        userService.addUser(u);
        tripService.addTrip(t);
        deelnameService.addDeelname(d);
        List<String> emails = new ArrayList<>();
        emails.add("kdgteamf@gmail.com");
        assertEquals("public trips", emails, tripService.listUserEmailPerTrips(t.getTripId()));
    }


}
