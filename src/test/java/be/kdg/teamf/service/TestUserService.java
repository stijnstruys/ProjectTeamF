package be.kdg.teamf.service;

import be.kdg.teamf.dao.UserDAO;
import be.kdg.teamf.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;

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

    @Test
    public void listUsers() {
        User user1 = new User();
        user1.setUsername("Bart Leemans");
        User user2 = new User();
        user2.setUsername("Jeroen Dierckx");
        userService.addUser(user1);
        userService.addUser(user2);

        assertEquals("Niet alle gebruikers worden opgehaald", 2, userService.listUsers().size());
    }

    @Test
    public void deleteUser() {
        User u = new User();
        u.setUsername("Bart Leemans");
        userService.addUser(u);
        userService.deleteUser(u);
        assertTrue("User not found", !userService.listUsers().contains(u));
    }

    @Test
    public void findUser() {
        User u = new User();
        u.setUsername("Bart Leemans");
        userService.addUser(u);
        assertSame("you are not getting the expected user from the db", "Bart Leemans", userService.findUser(u.getUsername()).getUsername());
    }

    @Test
    public void findUserId() {
        User u = new User();
        u.setUsername("Bart Leemans");
        userService.addUser(u);
        int id = u.getUserID();
        assertSame("you are not getting the expected user from the db", "Bart Leemans", userService.findUser(id).getUsername());
    }

    @Test
    public void updateUser() {
        User u = new User();
        u.setEmail("bart@hotmail.com");
        u.setLastName("Leemans");
        u.setFirstName("Bart");
        u.setUsername("Bart Leemans");
        u.setTelephone("00306985587996");
        userService.addUser(u);
        u.setUsername("updated");
        userService.updateUser(u);

        assertEquals("De user is niet gewijzigd", "updated", userService.findUser("updated").getUsername());
    }
}
