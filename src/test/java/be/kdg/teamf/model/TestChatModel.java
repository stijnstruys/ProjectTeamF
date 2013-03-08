package be.kdg.teamf.model;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 8-3-13
 * Time: 9:45
 * To change this template use File | Settings | File Templates.
 */
public class TestChatModel {
   @Test
   public void addChat() {
     User u = new User();
       u.setUserID(1);

     Trip t = new Trip();
       t.setTripId(1);
      Chat c = new Chat(t,u,"Test");
       c.setChatID(1);

      assertEquals("Expected chatId",1,c.getChatID());
      assertEquals("Expected tripId",1,c.getTrip().getTripId());
      assertEquals("Expected userId",1,c.getUser().getUserID());
   }

}
