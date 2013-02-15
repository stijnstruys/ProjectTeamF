package be.kdg.teamf.dao;

import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: BART.LEEMANS
 * Date: 15/02/13
 * Time: 9:30
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring-servlet.xml")
public class TestTripDAO extends AbstractTransactionalJUnit4SpringContextTests{
    @Autowired
    protected TripDAO tripDAO;

    @Test
    public void addTrip() {
        int id = 1;
        Trip t = new Trip();
        List deelnames = new ArrayList();
        Deelname d1 = new Deelname();
        Deelname d2 = new Deelname();
        User u1 = new User();
        u1.setUsername("JeroenD");
        User u2 = new User();
        u2.setUsername("JeroenV");

        d1.setDeelnameID(1);
        d1.setUser(u1);
        deelnames.add(d1);
        d2.setDeelnameID(2);
        d2.setUser(u2);
        deelnames.add(d2);

        t.setTripId(1);
        t.setTripName("Dropping");
        t.setStartDate(new Date("02/05/2013"));
        t.setEndDate(new Date("02/05/2013"));
        t.setOrganiser("Bart");

        t.setDeelnames(deelnames);

        tripDAO.addTrip(t);

        assertEquals("Expected organiser: ", "Bart", tripDAO.findTrip(t.getTripId()).getOrganiser());
        assertEquals("Expected name: ", "Dropping", tripDAO.findTrip(t.getTripId()).getTripName());

    }

    @Test
    public void updateTrip() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Test
    public void removeTrip() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Test
    public void listTrips() {

    }

    @Test
    public void searchTrips() {

    }

    @Test
    public void findTrip() {

    }

    @Test
    public void getTripNames() {

    }
}
