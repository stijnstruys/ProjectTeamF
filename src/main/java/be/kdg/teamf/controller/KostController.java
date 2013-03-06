package be.kdg.teamf.controller;

import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Kost;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.service.DeelnameService;
import be.kdg.teamf.service.KostService;
import be.kdg.teamf.service.TripService;
import be.kdg.teamf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    @Autowired
    DeelnameService deelnameService;


    @RequestMapping(value = "/kost/kostManagment", method = RequestMethod.GET)
    public ModelAndView manageKosts(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("deelnames", deelnameService.getDeelnamesByUser(userService.getCurrentUser()));
        ModelAndView model = new ModelAndView("Kost/kostManagment");
        return model;
    }

    @RequestMapping(value = "/kost/addKost{tripID}", method = RequestMethod.GET)
    public ModelAndView addKostPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("tripID") int tripID) {


        Trip t =  tripService.findTrip(tripID);
        Kost k = new Kost();
        request.setAttribute("kost", k);
        request.setAttribute("trip", t);
        ModelAndView model = new ModelAndView("Kost/AddKost");
        return model;
    }
    @RequestMapping(value = "/kost/add", method = RequestMethod.POST)
    public String addKost(@ModelAttribute("kost") Kost kost, @RequestParam("tripId") int tripId,HttpServletRequest request) {


        Trip t = tripService.findTrip(tripId);
        kost.setDeelname(deelnameService.findDeelname(t, userService.getCurrentUser()));


        kostService.addKost(kost);
        return "redirect:/trip/" + t.getTripId() + ".html";
    }
    @RequestMapping(value = "/kost/delete", method = RequestMethod.POST)
    public String deleteKost(@RequestParam("kostId") int kostId, BindingResult result, HttpServletRequest request) {

        kostService.deleteKost(kostService.findKost(kostId));
        return "manageKosts.html";
    }

    @RequestMapping(value = "/kost/kostenPerTrip{tripId}", method = RequestMethod.GET)
    public ModelAndView kostenPerTrip(@PathVariable("tripId") int tripId, HttpServletRequest request) {

        Deelname d = deelnameService.findDeelname(tripService.findTrip(tripId),userService.getCurrentUser());
        request.setAttribute("deelname",d);
        request.setAttribute("deelnameUser",d.getUser());
        request.setAttribute("trip",d.getTrip());
        ModelAndView model = new ModelAndView("Kost/kostenPerTrip");

        return model;
    }
}
