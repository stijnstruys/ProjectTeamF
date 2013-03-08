package be.kdg.teamf.model;

import be.kdg.teamf.dao.DeelnameDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 18/02/13
 * Time: 21:21
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations = {"classpath:spring-servlet.xml"})
public class TestDeelnameModel {
    @Autowired
    protected DeelnameDAO deelnameDAO;


    @Test
    public void addDeelname() throws Exception {
        Deelname d = new Deelname();
        List<String> equipment = new ArrayList();
       // Collection<Kost> kosten = new ArrayList();
       // Kost k = new Kost();
        //kosten.add(k);
        User u = new User();
        Trip t = new Trip();
        Deelname d2 = new Deelname(t,u);

        d2.setDeelnameID(2);
        d2.setEquipment(equipment);
        d.setDeelnameID(1);
        d.setTrip(t);
        d.setUser(u);
        d.setEquipment(equipment);
        d.setKosten(null);

//        deelnameDAO.addDeelname(d);
        assertEquals("Expected deelnameID", 1, d.getDeelnameID());
        assertEquals("Expected trip:", t, d.getTrip());
        assertEquals("Expected user:", u, d.getUser());
        assertEquals("Expected deelnameID", 2, d2.getDeelnameID());
        assertEquals("Expected trip:", t, d2.getTrip());
        assertEquals("Expected user:", u, d2.getUser());
        assertEquals("Expected kosten:", null, d2.getKosten());
    }
}
