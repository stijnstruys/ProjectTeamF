package be.kdg.teamf.controller;

import be.kdg.teamf.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 4/03/13
 * Time: 16:10
 * To change this template use File | Settings | File Templates.
 */

@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring-servlet.xml")
public class TestUserController extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    UserController userController;

    @Test
    public void testAddUser(){
        User u = getUser();
        String s;

        s = userController.addUser(u,new MockMultipartFile("test",new byte[0]));
        assertEquals("correcte login","redirect:/general/index.html",s);
    }
    @Test
    public void testDeleteUser(){
        User u = getUser();

        userController.addUser(u,new MockMultipartFile("test",new byte[0]));
        String s =  userController.deleteUser(u.getUserID());
        assertEquals("correcte login","redirect:/user/user.html",s);

    }
    public User getUser(){
        User u = new User();
        u.setUsername("unittestuser");
        u.setPassword("test");
        return u;
    }
}
