package be.kdg.teamf.model;

import be.kdg.teamf.dao.UserDAO;
import be.kdg.teamf.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;


@ContextConfiguration(locations = {"classpath:spring-servlet.xml"})
public class TestUserModel extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    protected UserDAO userDAO;

    @Test
    public void addUser() {
        User u = new User();
        Date geboorteDatum = new Date();
        u.setUserID(1);
        u.setUsername("username");
        u.setPassword("password");
        u.setEmail("email");
        u.setFirstName("firstname");
        u.setTelephone("telephone");
        u.setFirstName("firstname");
        u.setLastName("lastname");
        u.setDateOfBirth(geboorteDatum);
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
        assertEquals("Expected dateofbirth: dateofbirth", geboorteDatum, u.getDateOfBirth());
        assertEquals("Expected street: street", "street", u.getStreet());
        assertEquals("Expected number: number", "number", u.getNumber());
        assertEquals("Expected zipcode: zipcode", "zipcode", u.getZipcode());
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
       User u2 = new User();

       u1.setUsername("jef");
       u2 = u1;
       assertTrue(u1.equals(u2));
   }

}
