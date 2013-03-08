package be.kdg.teamf.service;

import be.kdg.teamf.dao.TripDAO;
import be.kdg.teamf.model.Chat;
import be.kdg.teamf.model.Trip;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 8-3-13
 * Time: 9:50
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring-servlet.xml")
public class TestChatService extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    ChatService chatService;
    @Autowired
    private TripService tripService;
    @Autowired
    private TripDAO tripDAO;

    @Test
    public void testAddChat(){
        Chat c = new Chat();
        Trip t = new Trip();

        tripDAO.addTrip(t);
        c.setTrip(t);
        c.setMsg("Test");
       chatService.addChat(c);

        assertEquals("Expected msg:",c.getMsg(),chatService.getChats(t.getTripId()).get(0).getMsg());

    }

}
