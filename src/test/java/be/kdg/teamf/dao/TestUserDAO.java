package be.kdg.teamf.dao;

import be.kdg.teamf.model.User;
import be.kdg.teamf.service.UserService;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;

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

    @Test
    public void updateUser() {
        User u = new User();
        u.setEmail("bart@hotmail.com");
        u.setLastName("Leemans");
        u.setFirstName("Bart");
        u.setUsername("Bart Leemans");
        u.setTelephone("00306985587996");
        userDAO.addUser(u);
        u.setUsername("updated");
        userDAO.updateUser(u);

        assertEquals("De user is niet gewijzigd", "updated", userDAO.findUser("updated").getUsername());
    }

    @Test
    public void listUsers() {
        User user1 = new User();
        user1.setUsername("Bart Leemans");
        User user2 = new User();
        user2.setUsername("Jeroen Dierckx");
        userDAO.addUser(user1);
        userDAO.addUser(user2);

        assertEquals("Niet alle gebruikers worden opgehaald", 2, userDAO.listUsers().size());
    }

    @Test
    public void deleteUser() {
        User u = new User();
        u.setUsername("Bart Leemans");
        userDAO.addUser(u);
        userDAO.deleteUser(u);
        assertTrue("User not found", !userDAO.listUsers().contains(u));
    }

    @Test
    public void findUser() {
        User u = new User();
        u.setUsername("Bart Leemans");
        userDAO.addUser(u);
        assertSame("you are not getting the expected user from the db", "Bart Leemans", userDAO.findUser(u.getUsername()).getUsername());
    }

    @Test
    public void findUserId() {
        User u = new User();
        u.setUsername("Bart Leemans");
        userDAO.addUser(u);
        int id = u.getUserID();
        assertSame("you are not getting the expected user from the db","Bart Leemans",userDAO.findUser(id).getUsername());
    }
}
