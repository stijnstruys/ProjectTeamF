package be.kdg.teamf.dao;

import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

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

        saveOtherStuff(dn.getTrip(), dn.getUser());
        Deelname dn2 = deelnameDAO.findDeelname(dn.getTrip().getTripId(), dn.getUser().getUserID());
        assertEquals("Expected: ", "Stijn", dn2.getUser().getFirstName());
        assertEquals("Expected: ", "Dropping", deelnameDAO.findDeelname(dn.getDeelnameID()).getTrip().getTripName());
    }

    private void saveOtherStuff(Trip t, User u) {
        tripDAO.addTrip(t);
        userDAO.addUser(u);

    }

    @Test
    public void testDeleteDeelname() {
        Deelname dn = getDeelname();
        deelnameDAO.addDeelname(dn);
        saveOtherStuff(dn.getTrip(), dn.getUser());
        deelnameDAO.deleteDeelname(dn);
    }

    @Test
    public void testUpdateDeelname() {
        List<String> equipment = new ArrayList<>();
        Deelname dn = getDeelname();
        deelnameDAO.addDeelname(dn);
        saveOtherStuff(dn.getTrip(), dn.getUser());
        dn.getUser().setFirstName("Jeroen");
        dn.getTrip().setTripName("Reis naar Spanje");
        dn.setEquipment(equipment);
        deelnameDAO.updateDeelname(dn);
        assertEquals("Expected: ", "Jeroen", deelnameDAO.findDeelname(dn.getDeelnameID()).getUser().getFirstName());
        assertEquals("Expected: ", "Reis naar Spanje", deelnameDAO.findDeelname(dn.getDeelnameID()).getTrip().getTripName());
        assertEquals("Expected: ", equipment, deelnameDAO.findDeelname(dn.getDeelnameID()).getEquipment());
    }

    @Test
    public void testFindDeelname() {
        Deelname dn = getDeelname();
        deelnameDAO.addDeelname(dn);
        saveOtherStuff(dn.getTrip(), dn.getUser());
        assertEquals("Expected: ", "Stijn", deelnameDAO.findDeelname(dn.getDeelnameID()).getUser().getFirstName());
        assertEquals("Expecxted: ", "Dropping", deelnameDAO.findDeelname(dn.getDeelnameID()).getTrip().getTripName());
    }

    @Test
    public void listDeelnames() {
        Deelname d1 = getDeelname();
        deelnameDAO.addDeelname(d1);
        saveOtherStuff(d1.getTrip(), d1.getUser());
        assertEquals("Niet alle deelnames worden opgehaald", 1, deelnameDAO.findDeelnames(d1.getTrip()).size());
    }

    @Test
    public void geenDeelnames() {
        Trip t = new Trip();
        t.setTripId(123456789);
        assertEquals("Niet alle deelnames worden opgehaald", null, deelnameDAO.findDeelname(1));
        assertEquals("Niet alle deelnames worden opgehaald", new ArrayList<>(), deelnameDAO.findDeelnames(t));
    }

    private Deelname getDeelname() {
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

        dn.setTrip(t1);
        dn.setUser(u1);
        dn.setEquipment(new ArrayList<String>());
        return dn;
    }

    @Test
    public void geenDeelname() {
        assertNull(deelnameDAO.findDeelname(123456789, 123456879));
    }

    @Test
    public void testFindDeelnamesByUser() {
        Deelname dn = new Deelname();
        Deelname dn2 = new Deelname();
        User u = new User();
        u.setUserID(1);
        dn.setDeelnameID(1);
        dn.setUser(u);
        dn2.setDeelnameID(2);
        dn2.setUser(u);
        userDAO.addUser(u);
        deelnameDAO.addDeelname(dn);
        deelnameDAO.addDeelname(dn2);

        List<Deelname> deelnames = new ArrayList();
        deelnames.add(dn);
        deelnames.add(dn2);
        assertEquals("Expected: ", deelnames, deelnameDAO.findDeelnamesByUser(u));
    }
}
