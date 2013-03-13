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
 * Time: 16:38
 * To change this template use File | Settings | File Templates.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring-servlet.xml")
public class TestGeneralController {
    @Autowired
    GeneralController generalController;

    @Test
    public void testAbout(){


        ModelAndView mav= null;

            mav = generalController.getAbout(null, null);

        assertEquals("General/about", mav.getViewName());

    }
}
