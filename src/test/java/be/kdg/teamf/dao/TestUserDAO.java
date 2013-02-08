package be.kdg.teamf.dao;

import be.kdg.teamf.util.OpenSessionInTestBase;
import org.junit.Test;
import be.kdg.teamf.model.User;

import java.util.Date;

import static org.junit.Assert.assertSame;

/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 8-2-13
 * Time: 10:24
 * To change this template use File | Settings | File Templates.
 */
public class TestUserDAO extends OpenSessionInTestBase {
    private UserDAO userDao;
    Date datum = new Date(30/12/1988);

    @Override
    protected String[] getConfigLocations() {
        return new String[]{"classpath:dao/userDaoContext.xml"};
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

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
