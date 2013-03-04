package be.kdg.teamf.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;


/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 4/03/13
 * Time: 15:49
 * To change this template use File | Settings | File Templates.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring-servlet.xml")
public class TestIndexController {

    @Autowired
    IndexController indexController;

    @Test
    public void testIndex(){


        ModelAndView mav= null;
        try {
            mav = indexController.indexPage(null,null);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        assertEquals("General/index", mav.getViewName());

    }
    @Test
    public void testLoginPage(){


        ModelAndView mav= null;
        try {
            mav = indexController.loginPage(null,null);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        assertEquals("General/login", mav.getViewName());

    }
}

