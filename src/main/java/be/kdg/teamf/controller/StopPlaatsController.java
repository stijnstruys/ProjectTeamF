package be.kdg.teamf.controller;

import be.kdg.teamf.model.StopPlaats;
import be.kdg.teamf.service.StopPlaatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 8/02/13
 * Time: 12:01
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class StopPlaatsController
{
    @Autowired
    private StopPlaatsService stopPlaatsService;

    @RequestMapping(value = "/StopPlaats/stopPlaats.html",method = RequestMethod.GET)
    public ModelAndView userPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        StopPlaats s  = new StopPlaats();
        request.setAttribute("stopPlaats",s);
        //request.setAttribute("userList",userService.listUsers());
        ModelAndView model = new ModelAndView("StopPlaats/stopPlaats");

        return model;
    }



    @RequestMapping(value = "/StopPlaats/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("stopplaats")
                          StopPlaats stopPlaats, BindingResult result) {

        stopPlaatsService.addStopPlaats(stopPlaats);

        return "redirect:/StopPlaats/stopPlaats.html";
    }

    @RequestMapping("/StopPlaats/delete/{stopPlaatsID}")
    public String deleteUser(@PathVariable("stopPlaatsID") int stopPlaatsID) {

        stopPlaatsService.deleteStopPlaats(stopPlaatsService.findStopPlaats(stopPlaatsID));
        return "redirect:/user/user.html";

    }
    @RequestMapping("/StopPlaats/update/{stopPlaatsID}")
    public ModelAndView userPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("stopPlaatsID") int stopPlaatsID) throws Exception {

        StopPlaats s  = stopPlaatsService.findStopPlaats(stopPlaatsID);
        request.setAttribute("stopPlaats",s);
        ModelAndView model = new ModelAndView("StopPlaats/updateStopPlaats");
        return model;

    }
    @RequestMapping(value = "/StopPlaats/update/updateStopPlaats", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("stopPlaats")
                             StopPlaats stopPlaats, BindingResult result) {

        stopPlaatsService.updateStopPlaats(stopPlaats);

        return "redirect:/StopPlaats/stopPlaats.html";

    }

}
