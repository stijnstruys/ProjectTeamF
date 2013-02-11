package be.kdg.teamf.model;

import be.kdg.teamf.dao.UserDAO;
import be.kdg.teamf.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-servlet.xml"})
public class TestUsers extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    protected UserDAO user;
    @Autowired
    protected UserService userService;

    @Test
    public void sampleTest() {
        System.out.println("Number of rows is: " + userService.listUsers().size());
        System.out.println("Creating a new user");
        User u = new User();
        u.setUserID(1);
        u.setEmail("bart@hotmail.com");
        u.setLastName("Leemans");
        u.setFirstName("Bart");
        u.setTelephone("00306985587996");
        System.out.println("Before saving contact");
        // Lukt nog niet
        userService.addUser(u);
        System.out.println("After saving user. Id if contact is: " + u.getUserID());
        System.out.println("Number of rows now is: " + user.listUsers().size());
    }


    @Test
    public void createUser1() {
        User u = new User();

        u.setUserID(1);
        u.setUsername("username");
        u.setPassword("password");
        u.setEmail("email");
        u.setFirstName("firstname");
        u.setTelephone("telephone");
        u.setFirstName("firstname");
        u.setLastName("lastname");
        u.setDateOfBirth("dateofbirth");
        u.setStreet("street");
        u.setNumber("number");
        u.setZipcode("zipcode");
        u.setCity("city");

        assertEquals("Expected id: 1", 1, u.getUserID());
        assertEquals("Expected username: username", "username", u.getUsername());
        assertEquals("Expected password: password", "password", u.getPassword());
        assertEquals("Expected email: email", "email", u.getEmail());
        assertEquals("Expected firstname: firstname", "firstname", u.getFirstName());
        assertEquals("Expected firstname: telephone", "telephone", u.getTelephone());
        assertEquals("Expected lastname: lastname", "lastname", u.getLastName());
        assertEquals("Expected dateofbirth: dateofbirth", "dateofbirth", u.getDateOfBirth());
        assertEquals("Expected street: street", "street", u.getStreet());
        assertEquals("Expected number: number", "number", u.getNumber());
        assertEquals("Expected zipcode: zipcode", "zipcode", u.getZipcode());
        assertEquals("Expected city: city", "city", u.getCity());
    }

    @Test
    public void createUser2() {
        User u = new User("city", "zip", "number", "street", "dob", "lastname", "firstname", "tel", "email", "pwd", "username");

        assertEquals("Expected username: username", "username", u.getUsername());
        assertEquals("Expected password: pwd", "pwd", u.getPassword());
        assertEquals("Expected email: email", "email", u.getEmail());
        assertEquals("Expected firstname: firstname", "firstname", u.getFirstName());
        assertEquals("Expected firstname: tel", "tel", u.getTelephone());
        assertEquals("Expected lastname: lastname", "lastname", u.getLastName());
        assertEquals("Expected dateofbirth: dob", "dob", u.getDateOfBirth());
        assertEquals("Expected street: street", "street", u.getStreet());
        assertEquals("Expected number: number", "number", u.getNumber());
        assertEquals("Expected zipcode: zip", "zip", u.getZipcode());
        assertEquals("Expected city: city", "city", u.getCity());
    }

    @Test
    public void checkEqualsNotSameUser() {
        User u1 = new User();
        User u2 = new User();

        u1.setLastName("user1");
        u2.setLastName("user2");
        assertEquals(true, u1.equals(u2));
    }

   @Test
    public void checkEqualsSameUser() {
       User u1 = new User();
       User u2;

       u1.setUsername("jef");
       u2 = u1;
       assertTrue(u1.equals(u2));
   }

}
