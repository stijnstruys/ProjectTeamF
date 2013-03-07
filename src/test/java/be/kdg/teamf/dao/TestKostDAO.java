package be.kdg.teamf.dao;

import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Kost;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 7/03/13
 * Time: 13:08
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring-servlet.xml")
public class TestKostDAO extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    protected KostDAO kostDAO;

    @Autowired
    protected DeelnameDAO deelnameDAO;

    @Autowired
    protected UserDAO userDAO;

    @Autowired
    protected TripDAO tripDAO;

    @Test
    public void testAddKost() {
        Kost k = getKost();
        kostDAO.addKost(k);
        assertEquals("Expected prijs: ", 5.0, kostDAO.findKost(k.getKostId()).getPrijs());
        assertEquals("Expected Beschrijving", "lunch", kostDAO.findKost(k.getKostId()).getBeschrijving());
        assertEquals("Expected deelname", k.getDeelname(), kostDAO.findKost(k.getKostId()).getDeelname());
    }

    @Test
    public void testDeleteKost() {
        Kost k = getKost();
        kostDAO.addKost(k);
        kostDAO.deleteKost(k);

        assertEquals("Kost not found", k, kostDAO.findKost(k.getKostId()));
    }

    @Test
    public void testUpdateKost() {

        Kost k = getKost();
        kostDAO.addKost(k);
        k.setBeschrijving("ontbijt");
        kostDAO.updateKost(k);

        assertEquals("Expected beschrijving: ", "ontbijt", kostDAO.findKost(k.getKostId()).getBeschrijving());
    }

    @Test
    public void testkostenPerUser() {
        Kost k = new Kost();
        Deelname dn = new Deelname();
        User u = new User();
        u.setUserID(1);
        dn.setDeelnameID(1);
        dn.setUser(u);

        userDAO.addUser(u);
        deelnameDAO.addDeelname(dn);
        kostDAO.addKost(k);

        assertEquals("Expected size: ", 1, kostDAO.kostenPerUser(u).size());
    }

    @Test
    public void testkostenPerTrip() {
        Kost k = new Kost();
        Deelname dn = new Deelname();
        Trip t = new Trip();
        t.setTripId(1);
        dn.setDeelnameID(1);
        dn.setTrip(t);

        tripDAO.addTrip(t);
        deelnameDAO.addDeelname(dn);
        kostDAO.addKost(k);

        assertEquals("Expected size: ", 1, kostDAO.kostenPerTrip(t).size());
    }

    @Test
    public void testkostenPerTripEnUser() {
        Kost k = new Kost();
        Deelname dn = new Deelname();
        Trip t = new Trip();
        User u = new User();
        u.setUserID(1);
        t.setTripId(1);
        dn.setDeelnameID(1);
        dn.setTrip(t);
        dn.setUser(u);

        userDAO.addUser(u);
        tripDAO.addTrip(t);
        deelnameDAO.addDeelname(dn);
        kostDAO.addKost(k);

        assertEquals("Expected size: ", 1, kostDAO.kostenPerTripEnUser(t, u).size());
    }

    private Kost getKost() {
        Kost k = new Kost();
        Deelname d = new Deelname();
        deelnameDAO.addDeelname(d);
        k.setDeelname(d);
        k.setBeschrijving("lunch");
        k.setPrijs(5.0);
        k.setKostId(1);

        return k;
    }

}
