package be.kdg.teamf.dao;

import be.kdg.teamf.model.User;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertSame;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 8/02/13
 * Time: 10:23
 * To change this template use File | Settings | File Templates.
 */
public class TestTripDAO {
    private UserDAO userDao = new UserDAOImpl();
        Date datum = new Date(30/12/1988);

        @Test
        public void testGetUser() throws Exception {
            User u = new User();
            u.setUsername("tester");
            u.setPassword("jeroen");
            u.setFirstName("Jeroen");
            u.setLastName("Verbunt");
            u.setCity("Hoogstraten");
            u.setDateOfBirth(datum);
            u.setEmail("jeroen.verbunt@student.kdg.be");
            u.setStreet("Hoogstraatsesteenweg");
            u.setNumber("15");
            u.setTelephone("0332554846");
            userDao.addUser(u);
            assertSame("you are not getting the expected user from the db","Jeroen",userDao.getUser("tester").getFirstName());
        }
}
