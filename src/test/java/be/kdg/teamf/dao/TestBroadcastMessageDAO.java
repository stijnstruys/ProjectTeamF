package be.kdg.teamf.dao;

import be.kdg.teamf.model.BroadcastMessage;
import be.kdg.teamf.model.Trip;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 12/03/13
 * Time: 19:49
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring-servlet.xml")
public class TestBroadcastMessageDAO extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    protected BroadcastMessageDAO broadcastMessageDAO;
    @Autowired
    private TripDAO tripDAO;

    @Test
    public void testAddBroadcastMessage() {
        BroadcastMessage bm = getBroadcastMessage();
        bm.setBroadcastMessageID(1);
        broadcastMessageDAO.addBroadcastMessage(bm);

        assertEquals("Excepeted msg: ", "bericht", broadcastMessageDAO.findBroadcastMessage(bm.getBroadcastMessageID()).getMsg());
    }

    @Test
    public void testDeleteBroadcastMessage() {
        BroadcastMessage bm = getBroadcastMessage();
        broadcastMessageDAO.addBroadcastMessage(bm);
        broadcastMessageDAO.removeBroadcastMessage(bm);

        assertEquals("Excepeted msg: ", null, broadcastMessageDAO.findBroadcastMessage(bm.getBroadcastMessageID()));
    }

    @Test
    public void testUpdateBroadcastMessage() {
        BroadcastMessage bm = getBroadcastMessage();
        broadcastMessageDAO.addBroadcastMessage(bm);

        bm.setMsg("bericht2");
        broadcastMessageDAO.updateBroadcastMessage(bm);

        assertEquals("Excepeted msg: ", "bericht2", broadcastMessageDAO.findBroadcastMessage(bm.getBroadcastMessageID()).getMsg());

    }

    @Test
    public void testFindBroadcastMessage() {
        BroadcastMessage bm = getBroadcastMessage();
        broadcastMessageDAO.addBroadcastMessage(bm);

        assertEquals("Excepted : ", bm.getMsg(), broadcastMessageDAO.findBroadcastMessage(bm.getBroadcastMessageID()).getMsg());
    }

    @Test
    public void testBroadcastMessages() {
        BroadcastMessage bm = getBroadcastMessage();
        Trip t = new Trip();
        t.setTripId(1);
        t.setBroadcastMessages(new ArrayList<BroadcastMessage>());
        bm.setTrip(t);
        t.getBroadcastMessages().add(bm);

        tripDAO.addTrip(t);
        broadcastMessageDAO.addBroadcastMessage(bm);
        assertEquals("Excepted : ", t.getBroadcastMessages().size(), broadcastMessageDAO.getBroadcastMessages(t.getTripId()).size());
    }

    private BroadcastMessage getBroadcastMessage() {
        BroadcastMessage bm = new BroadcastMessage();
        bm.setMsg("bericht");
        return bm;
    }
}
