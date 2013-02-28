package be.kdg.teamf.model;

import be.kdg.teamf.dao.StopPlaatsDAO;
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
public class TestStopPlaatsModel {

    @Autowired
    protected StopPlaatsDAO stopPlaatsDAO;

    @Test
    public void addDeelname() throws Exception {
         StopPlaats s = new StopPlaats();
        Trip t = new Trip();

        s.setAdres("Straat 1");
        s.setStopPlaatsID(1);
        s.setTrip(t);
        s.setVrijgegeven(true);
         s.setInformatie("test");
        s.setType("Start");
        s.setNaam("stopNaam");
        assertEquals("Expected adres: Straat 1", "Straat 1", s.getAdres());
        assertEquals("Expected stopplaats:", 1, s.getStopPlaatsID());
        assertEquals("Expected trip:", t, s.getTrip());
        assertEquals("Expected vrijgegeven:", true, s.isVrijgegeven());
        assertEquals("Expected vrijgegeven:", "test", s.getInformatie());
        assertEquals("Expected vrijgegeven:", "Start", s.getType());
        assertEquals("Expected naam", "stopNaam", s.getNaam());
    }
}
