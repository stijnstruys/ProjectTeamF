package be.kdg.teamf.service;

import be.kdg.teamf.dao.UserDAO;
import be.kdg.teamf.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: BART.LEEMANS
 * Date: 11/02/13
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration("classpath:spring-servlet.xml")
public class TestUserService extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    protected UserService userService;

    @Test
    public void addUser() {
        User u = new User();
        u.setEmail("bart@hotmail.com");
        u.setLastName("Leemans");
        u.setFirstName("Bart");
        u.setUsername("Bart Leemans");
        u.setTelephone("00306985587996");
        userService.addUser(u);

        assertEquals("Expected firstname: ", "Bart Leemans", userService.findUser(u.getUserID()).getUsername());
    }
}
