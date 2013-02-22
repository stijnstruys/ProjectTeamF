package be.kdg.teamf.dao;

import be.kdg.teamf.model.*;
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
 * Time: 12:51
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring-servlet.xml")
public class TestDeelnameDAO extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    protected DeelnameDAO deelnameDAO;
    @Autowired
    protected UserDAO userDAO;
    @Autowired
    protected TripDAO tripDAO;

    @Test
    public void testAddDeelname() {
        Deelname dn = getDeelname();
        deelnameDAO.addDeelname(dn);

        Deelname dn2 = deelnameDAO.findDeelname(dn.getTrip().getTripId(), dn.getUser().getUserID());
        assertEquals("Expected: ", "Stijn", dn2.getUser().getFirstName());
        assertEquals("Expected: ", "Dropping", deelnameDAO.findDeelname(dn.getDeelnameID()).getTrip().getTripName());
    }

    @Test
    public void testDeleteDeelname(){
       Deelname dn = getDeelname();
       deelnameDAO.addDeelname(dn);
       deelnameDAO.deleteDeelname(dn);
    }

    @Test
    public void testUpdateDeelname() {
        Deelname dn = getDeelname();
        deelnameDAO.addDeelname(dn);
        dn.getUser().setFirstName("Jeroen");
        dn.getTrip().setTripName("Reis naar Spanje");
        assertEquals("Expected: ", "Jeroen", deelnameDAO.findDeelname(dn.getDeelnameID()).getUser().getFirstName());
        assertEquals("Expected: ", "Reis naar Spanje", deelnameDAO.findDeelname(dn.getDeelnameID()).getTrip().getTripName());

    }

    @Test
    public void testFindDeelname() {
        Deelname dn = getDeelname();
        deelnameDAO.addDeelname(dn);
        assertEquals("Expected: ", "Stijn", deelnameDAO.findDeelname(dn.getDeelnameID()).getUser().getFirstName());
        assertEquals("Expected: ", "Dropping", deelnameDAO.findDeelname(dn.getDeelnameID()).getTrip().getTripName());
    }

    private Deelname  getDeelname() {
        Deelname dn = new Deelname();

        User u1 = new User();
        u1.setFirstName("Stijn");
        u1.setDeelnames(new ArrayList<Deelname>());
        u1.setTrips(new ArrayList<Trip>());

        Trip t1 = new Trip();
        t1.setOrganiser(u1);
        t1.setDeelnames(new ArrayList<Deelname>());
        t1.setTripName("Dropping");

        t1.getDeelnames().add(dn);
        u1.getTrips().add(t1);
        u1.getDeelnames().add(dn);


        userDAO.addUser(u1);
        tripDAO.addTrip(t1);

        dn.setTrip(t1);
        dn.setUser(u1);

        return dn;
    }
}