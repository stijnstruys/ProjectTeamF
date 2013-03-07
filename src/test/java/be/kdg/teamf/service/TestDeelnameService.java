package be.kdg.teamf.service;

import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.ArrayList;
import java.util.Collection;

import static junit.framework.Assert.*;
import static org.junit.Assert.assertNull;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 27/02/13
 * Time: 12:50
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring-servlet.xml")
public class TestDeelnameService extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    DeelnameService deelnameService;
    @Autowired
    private TripService tripService;
    @Autowired
    private UserService userService;

    @Test
    public void addDeelname(){


        Deelname d = new Deelname();
        Collection<String> equipment = new ArrayList<>();
        equipment.add("test");
        d.setEquipment(equipment);
        deelnameService.addDeelname(d);

        assertEquals("categorie niet gevonden", d.getEquipment().size(), deelnameService.findDeelname(d.getDeelnameID()).getEquipment().size());
    }
    @Test
    public void updateDeelname(){


        Deelname d = new Deelname();
        Collection<String> equipment = new ArrayList<>();
        equipment.add("test");
        d.setEquipment(equipment);
        deelnameService.addDeelname(d);
        equipment.add("blabla");
        d.setEquipment(equipment);
        deelnameService.updateDeelname(d);

        assertEquals("categorie niet gevonden", d.getEquipment().size(), deelnameService.findDeelname(d.getDeelnameID()).getEquipment().size());
    }
    @Test
    public void deleteDeelname(){


        Deelname d = new Deelname();
        deelnameService.addDeelname(d);
        deelnameService.deleteDeelname(d);

        assertNull(deelnameService.findDeelname(d.getDeelnameID()));
    }
    @Test
    public void testIsRegistered(){

        Trip t = new Trip();
        Trip t2 = new Trip();
        User u = new User();

        userService.addUser(u);
        tripService.addTrip(t);
        tripService.addTrip(t2);
        Deelname d  =new Deelname(t,u);
        deelnameService.addDeelname(d);

        assertTrue("user neemt niet deel", deelnameService.userIsRegistered(t, u));
        assertFalse("user neemt deel", deelnameService.userIsRegistered(t2, u));
    }

    @Test
    public void testAlreadyExists(){
        Trip t = new Trip();
        User u = new User();
        Trip t2 = new Trip();

        userService.addUser(u);
        tripService.addTrip(t);
        tripService.addTrip(t2);

        Deelname d  = new Deelname(t,u);
        Deelname d2  = new Deelname(t2,u);
        deelnameService.addDeelname(d);


        assertFalse(deelnameService.alreadyExists(d2));
        d2.setTrip(t);
        assertTrue(deelnameService.alreadyExists(d2));

    }

    @Test
    public void testFindDeelname(){
        Trip t = new Trip();

        User u = new User();

        userService.addUser(u);
        tripService.addTrip(t);

        Deelname d  =new Deelname(t,u);
        deelnameService.addDeelname(d);

        assertNotNull("deelname is null", deelnameService.findDeelname(d.getTrip(),d.getUser()));

    }
    @Test
    public void testGetDeelnames(){
        Trip t = new Trip();

        User u = new User();

        userService.addUser(u);
        tripService.addTrip(t);

        Deelname d  =new Deelname(t,u);
        deelnameService.addDeelname(d);

        ArrayList<Deelname> deelnames = new ArrayList();
        deelnames.add(d);

        assertEquals("deelname is null", deelnames.size(),deelnameService.getDeelnames(t).size());

    }

    @Test
       public void testGetDeelnamesByUser(){
           Trip t = new Trip();

           User u = new User();

           userService.addUser(u);
           tripService.addTrip(t);

           Deelname d  = new Deelname(t,u);
           deelnameService.addDeelname(d);

           ArrayList<Deelname> deelnames = new ArrayList();
           deelnames.add(d);

           assertEquals("deelname is null", deelnames.size(),deelnameService.getDeelnamesByUser(u).size());

       }
}