package be.kdg.teamf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 11/02/13
 * Time: 15:27
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class GeneralController {


    @RequestMapping(value = "general/about.html", method = RequestMethod.GET)
    public ModelAndView getAbout(HttpServletRequest request, HttpServletResponse response){

            ModelAndView model = new ModelAndView("General/about");

            return model;
    }

    @RequestMapping(value = "general/loginfailed.html")
    public ModelAndView getLoginfailed(){
        ModelAndView m = new ModelAndView("General/loginFailed");
        return m;
    }

}