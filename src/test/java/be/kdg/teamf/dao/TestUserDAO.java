package be.kdg.teamf.dao;

import be.kdg.teamf.model.User;
import be.kdg.teamf.service.UserService;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: BART.LEEMANS
 * Date: 11/02/13
 * Time: 9:34
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring-servlet.xml")
public class TestUserDAO extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    protected UserDAO userDAO;

    @Test
    public void addUser() {
        User u = new User();
        u.setEmail("bart@hotmail.com");
        u.setLastName("Leemans");
        u.setFirstName("Bart");
        u.setUsername("Bart Leemans");
        u.setTelephone("00306985587996");
        userDAO.addUser(u);

        assertEquals("Expected firstname: ", "Bart Leemans", userDAO.findUser(u.getUserID()).getUsername());
    }

}
