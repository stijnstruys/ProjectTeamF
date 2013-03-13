package be.kdg.teamf.model;

import be.kdg.teamf.dao.BroadcastMessageDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 12/03/13
 * Time: 19:46
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations = {"classpath:spring-servlet.xml"})
public class TestBroadcastMessageModel {

    @Autowired
    protected BroadcastMessageDAO broadcastMessageDAO;

    @Test
    public void addBroadcastMessage() throws Exception {

        BroadcastMessage bm = new BroadcastMessage();
        Trip t = new Trip();
        Date d = new Date();
        bm.setTrip(t);
        bm.setDate(d);
        bm.setMsg("bericht");
        bm.setBroadcastMessageID(1);

        assertEquals("Expected trip: ", t, bm.getTrip());
        assertEquals("Expected msg: ", "bericht", bm.getMsg());
        assertEquals("Expected date: ", d, bm.getDate());
    }
}
