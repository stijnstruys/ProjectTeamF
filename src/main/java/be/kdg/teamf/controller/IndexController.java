package be.kdg.teamf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller

public class IndexController {




    @RequestMapping(value ="general/index.html", method = RequestMethod.GET)
    public ModelAndView indexPage(HttpServletRequest request, HttpServletResponse response)  {

        ModelAndView model = new ModelAndView("General/index");


        return model;
    }
    @RequestMapping(value ="general/login.html", method = RequestMethod.GET)
    public ModelAndView loginPage(HttpServletRequest request,HttpServletResponse response){

        ModelAndView model = new ModelAndView("General/login");


        return model;
    }

}
