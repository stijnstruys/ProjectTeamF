package be.kdg.teamf.dao;

import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

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

    @Test
    public void testAddDeelname() {
        Deelname dn = getDeelname();
        deelnameDAO.addDeelname(dn);
        assertEquals("Expected: ", "Stijn", deelnameDAO.findDeelname(dn.getDeelnameID()).getUser().getFirstName());
        assertEquals("Expecxted: ", "Dropping", deelnameDAO.findDeelname(dn.getDeelnameID()).getTrip().getTripName());
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
        dn.getTrip().setTripName("Reis naar Spangje");
        assertEquals("Expected: ", "Jeroen", deelnameDAO.findDeelname(dn.getDeelnameID()).getUser().getFirstName());
        assertEquals("Expecxted: ", "Reis naar Spangje", deelnameDAO.findDeelname(dn.getDeelnameID()).getTrip().getTripName());

    }

    @Test
    public void testFindDeelname() {
        Deelname dn = getDeelname();
        deelnameDAO.addDeelname(dn);
        assertEquals("Expected: ", "Stijn", deelnameDAO.findDeelname(dn.getDeelnameID()).getUser().getFirstName());
        assertEquals("Expecxted: ", "Dropping", deelnameDAO.findDeelname(dn.getDeelnameID()).getTrip().getTripName());
    }

    private Deelname  getDeelname() {
        Deelname dn = new Deelname();
        User u1 = new User();
        u1.setFirstName("Stijn");
        Trip t1 = new Trip();
        t1.setTripName("Dropping");
        dn.setTrip(t1);
        dn.setUser(u1);
        return dn;
    }
}
