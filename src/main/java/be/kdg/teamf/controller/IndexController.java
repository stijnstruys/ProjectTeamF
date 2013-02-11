package be.kdg.teamf.controller;

import be.kdg.teamf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
@RequestMapping("general/index.html")
public class IndexController  {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {

        User userlogin  = new User();
        request.setAttribute("loginuser",userlogin);


        ModelAndView model = new ModelAndView("General/index");
        //be.kdg.teamf.model.addObject("msg", "hello world");

        return model;
    }



}
