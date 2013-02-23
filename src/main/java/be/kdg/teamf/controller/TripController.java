package be.kdg.teamf.controller;

import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import be.kdg.teamf.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 7/02/13
 * Time: 21:51
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class TripController {

    @Qualifier("tripServiceImpl")
    @Autowired
    private TripService tripService;

    @Autowired
    private TripTypeService tripTypeService;

    @Autowired
    private UserService userService;
    @Autowired
    private DeelnameService deelnameService;
    @Autowired
    private TripCategorieService tripCategorieService;

    @RequestMapping(value = "/trip/tripOverzicht.html", method = RequestMethod.GET)
    public ModelAndView tripOverzichtPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Trip t = new Trip();
        request.setAttribute("trip", t);
        request.setAttribute("tripList", tripService.listTrips());

        ModelAndView model = new ModelAndView("Trip/tripOverzicht");
        return model;
    }

    @RequestMapping(value = "/search/tripSearchResult.html", params = {"searchInput"}, method = RequestMethod.GET)
    public ModelAndView tripSearchResult(HttpServletRequest request, @RequestParam("searchInput") String searchInput) throws Exception {

        Trip t = new Trip();
        request.setAttribute("trip", t);
        request.setAttribute("tripSearchList", tripService.searchTrips(searchInput));
        ModelAndView model = new ModelAndView("Trip/tripSearchResult");
        return model;
    }

    @RequestMapping(value = "/trip/addTrip.html", method = RequestMethod.GET)
    public ModelAndView addTripPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        User userlogin = new User();
        request.setAttribute("loginuser", userlogin);
        Trip t = new Trip();
        request.setAttribute("trip", t);
        request.setAttribute("tripTypeList", tripTypeService.listTripTypes());
        ModelAndView model = new ModelAndView("Trip/addTrip");
        return model;
    }

    @RequestMapping("/trip/{tripID}")
    public ModelAndView viewTripPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("tripID") int tripID) throws Exception {

        User u = userService.getCurrentUser();
        Trip t = tripService.findTrip(tripID);

        request.setAttribute("deelnemers", deelnameService.getDeelnames(t));
        request.setAttribute("equipment", t.getEquipment());
        request.setAttribute("categories", tripCategorieService.getTripCategories(t.getTripId()));
        if (u != null && deelnameService.userIsRegistered(t, u)) {
            request.setAttribute("registered", true);
        } else {
            request.setAttribute("registered", false);
        }
        request.setAttribute("trip", t);
        ModelAndView model = new ModelAndView("Trip/viewTrip");
        return model;
    }

    @RequestMapping(value = "trip/add", method = RequestMethod.POST)
    public String addTrip(@ModelAttribute("trip")
                          Trip trip, BindingResult result) {


        trip.setOrganiser(userService.getCurrentUser());
        tripService.addTrip(trip);

        return "redirect:/trip/tripOverzicht.html";
    }

    @RequestMapping("/trip/join/{tripID}")
    public String joinTrip(HttpServletRequest request, HttpServletResponse response, @PathVariable("tripID") int tripID) throws Exception {

        User u = userService.getCurrentUser();
        Trip t = tripService.findTrip(tripID);

        Deelname d = new Deelname(t, u);

        if (!deelnameService.alreadyExists(d)) {
            t.getDeelnames().add(d);
            //t.setOrganiser(userService.getCurrentUser());
            tripService.updateTrip(t);
        }

        return "redirect:/trip/" + tripID + ".html";
    }

    @RequestMapping("/trip/leave/{tripID}")
    public String leaveTrip(HttpServletRequest request, HttpServletResponse response, @PathVariable("tripID") int tripID) throws Exception {

        User u = userService.getCurrentUser();
        Trip t = tripService.findTrip(tripID);

        Deelname d = deelnameService.findDeelname(t, u);
        deelnameService.deleteDeelname(d);

        return "redirect:/trip/" + tripID + ".html";
    }

}