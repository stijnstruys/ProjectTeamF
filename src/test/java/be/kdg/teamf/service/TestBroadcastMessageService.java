package be.kdg.teamf.service;

import be.kdg.teamf.model.BroadcastMessage;
import be.kdg.teamf.model.Trip;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 12/03/13
 * Time: 19:58
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring-servlet.xml")
public class TestBroadcastMessageService extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    BroadcastMessageService broadcastMessageService;
    @Autowired
    TripService tripService;

    @Test
    public void addBroadcastMessage() {
        BroadcastMessage bm = new BroadcastMessage();
        bm.setMsg("bericht");

        broadcastMessageService.addBroadcastMessage(bm);

        assertEquals("message not found: ", "bericht", broadcastMessageService.findBroadcastMessage(bm.getBroadcastMessageID()).getMsg());
    }

    @Test
    public void updateBroadcastMessage() {


        BroadcastMessage bm = new BroadcastMessage();
        bm.setMsg("bericht");
        broadcastMessageService.addBroadcastMessage(bm);
        bm.setMsg("bericht2");
        broadcastMessageService.updateBroadcastMessage(bm);

        assertEquals("Broadcast message niet gevonden", "bericht2", broadcastMessageService.findBroadcastMessage(bm.getBroadcastMessageID()).getMsg());
    }

    @Test
    public void deleteBroadcastMessage() {
        BroadcastMessage bm = new BroadcastMessage();

        bm.setMsg("bericht");
        broadcastMessageService.addBroadcastMessage(bm);
        broadcastMessageService.removeBroadcastMessage(bm);

        assertNull(broadcastMessageService.findBroadcastMessage(bm.getBroadcastMessageID()));
    }

    @Test
    public void listBroadcastMessage() {
        BroadcastMessage bm = new BroadcastMessage();
        bm.setMsg("bericht");

        Trip t = new Trip();

        t.setBroadcastMessages(new ArrayList<BroadcastMessage>());
        t.getBroadcastMessages().add(bm);
        bm.setTrip(t);
        tripService.addTrip(t);

        assertEquals("Excepted : ", t.getBroadcastMessages().size(), broadcastMessageService.getBroadcastMessages(t.getTripId()).size());

    }
}
