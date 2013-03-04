package be.kdg.teamf.controller;

import be.kdg.teamf.model.User;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Stijn
 * Date: 4-3-13
 * Time: 14:45
 * To change this template use File | Settings | File Templates.
 */
public class UserControllerTest {


    @Test
    public void loginTest() {
        UserController userController = new UserController();
        User u = new User();
        u.setUsername("test");
        u.setPassword("test");
        assertEquals("Expected: ","redirect:/general/index.html",userController.logIn(u, null));
    }
}
