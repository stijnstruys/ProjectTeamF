package be.kdg.teamf.model;

import be.kdg.teamf.dao.UserDAO;
import be.kdg.teamf.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ContextConfiguration
public class UserTests extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    protected UserDAO user;
    @Autowired
    protected UserService userService;

    @Test
    public void sampleTest() {
        System.out.println("Number of rows is: " + userService.listUsers().size());
        System.out.println("Creating a new user");
        User u = new User();
        u.setEmail("bart@hotmail.com");
        u.setLastName("Leemans");
        u.setFirstName("Bart");
        u.setTelephone("00306985587996");
        System.out.println("Before saving contact");
        userService.addUser(u);
        System.out.println("After saving user. Id if contact is: " + u.getUserID());
        System.out.println("Number of rows now is: " + user.listUsers().size());
    }
}
