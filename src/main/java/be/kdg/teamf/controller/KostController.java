package be.kdg.teamf.controller;

import be.kdg.teamf.model.Kost;
import be.kdg.teamf.service.KostService;
import be.kdg.teamf.service.TripService;
import be.kdg.teamf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 5/03/13
 * Time: 11:12
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class KostController {

    @Autowired
    KostService kostService;
    @Autowired
    TripService tripService;
    @Autowired
    UserService userService;


    @RequestMapping(value = "/kost/manageKosts", method = RequestMethod.GET)
    public ModelAndView manageKosts(HttpServletRequest request, HttpServletResponse response) {
        Kost k = new Kost();
        request.setAttribute("kost", k);

        ModelAndView model = new ModelAndView("Trip/addTrip");
        return model;
    }

    @RequestMapping(value = "/kost/addKost", method = RequestMethod.GET)
    public ModelAndView addTripPage(HttpServletRequest request, HttpServletResponse response) {
        Kost k = new Kost();
        request.setAttribute("kost", k);

        ModelAndView model = new ModelAndView("Trip/addTrip");
        return model;
    }
    @RequestMapping(value = "kost/add", method = RequestMethod.POST)
    public String addTrip(@ModelAttribute("trip") Kost kost, @RequestParam("tripId") int tripId, @RequestParam("userId") int userId , BindingResult result, HttpServletRequest request) {

        kost.setTrip(tripService.findTrip(tripId));
        kost.setUser(userService.findUser(userId));

        kostService.addKost(kost);
        return "";
    }


}
