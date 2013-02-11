package be.kdg.teamf.controller;

import be.kdg.teamf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import be.kdg.teamf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("general/about.html")
public class AboutController {

    @RequestMapping(method = RequestMethod.GET)
        public ModelAndView handleRequestInternal(HttpServletRequest request,
                                                     HttpServletResponse response) throws Exception {

            User userlogin  = new User();
            request.setAttribute("loginuser",userlogin);

            ModelAndView model = new ModelAndView("General/about");

            return model;

    }
}