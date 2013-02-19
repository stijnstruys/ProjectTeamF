package be.kdg.teamf.model;

import be.kdg.teamf.dao.DeelnameDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

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
        Trip t = new Trip();
        User u = new User();

        d.setDeelnameID(1);
        d.setTrip(t);
        d.setUser(u);

        assertEquals("Expected deelnameID", 1, d.getDeelnameID());
        assertEquals("Expected trip:", t, d.getTrip());
        assertEquals("Expected user:", u, d.getUser());
    }
}