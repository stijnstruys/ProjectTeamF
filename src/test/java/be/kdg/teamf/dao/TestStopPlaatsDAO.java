package be.kdg.teamf.dao;

import be.kdg.teamf.model.StopPlaats;
import be.kdg.teamf.model.Trip;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 15-2-13
 * Time: 15:13
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring-servlet.xml")
public class TestStopPlaatsDAO extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    protected StopPlaatsDAO stopPlaatsDAO;

    @Test
    public void testAddStopPlaats() {
        StopPlaats sp = getStopPlaats();
        stopPlaatsDAO.addStopPlaats(sp);
        assertEquals("Expected adres: ", "Test 1250", stopPlaatsDAO.findStopPlaats(sp.getStopPlaatsID()).getAdres());
        assertEquals("Expected vrijgegeven: ", false,stopPlaatsDAO.findStopPlaats(sp.getStopPlaatsID()).isVrijgegeven());
    }

    @Test
    public void testDeleteStopPlaats(){
        StopPlaats sp = getStopPlaats();
        stopPlaatsDAO.addStopPlaats(sp);
        stopPlaatsDAO.deleteStopPlaats(sp);
    }

    @Test
    public void testUpdateStopPlaats() {
        StopPlaats sp = getStopPlaats();
        stopPlaatsDAO.addStopPlaats(sp);

    }

    @Test
    public void testFindStopPlaats() {

    }

    private StopPlaats getStopPlaats() {
        StopPlaats sp = new StopPlaats();
        sp.setAdres("Test 1250");
        sp.setVrijgegeven(false);
        Trip t = new Trip();
        t.setTripName("lol");
        sp.setTrip(t);
        return sp;
    }
}
