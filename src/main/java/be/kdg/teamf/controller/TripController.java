package be.kdg.teamf.controller;

import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import be.kdg.teamf.service.TripService;
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

    @RequestMapping(value = "/trip/tripOverzicht.html", method = RequestMethod.GET)
    public ModelAndView tripOverzichtPage(HttpServletRequest request, HttpServletResponse response) throws Exception {



        Trip t = new Trip();
        request.setAttribute("trip", t);
        request.setAttribute("tripList", tripService.listTrips());
        ModelAndView model = new ModelAndView("Trip/tripOverzicht");
        return model;
    }


   /* @RequestMapping(value = "/trip/tripNames", method = RequestMethod.GET)
                    public List<String> tripNames(@ModelAttribute("trip")
                      Trip trip, BindingResult result) {

                        List<String> tripN = tripService.getTripNames();

                        return tripN;
                    }      */

    @RequestMapping(value = "/search/tripSearchResult.html", params = {"searchInput"}, method = RequestMethod.GET)
    public ModelAndView tripSearchResult(HttpServletRequest request, HttpServletResponse response, @RequestParam("searchInput") String searchInput) throws Exception {

        /*User userlogin = new User();
        request.setAttribute("loginuser", userlogin); */
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
        ModelAndView model = new ModelAndView("Trip/addTrip");
        return model;
    }

    @RequestMapping("/trip/{tripID}")
    public ModelAndView viewTripPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("tripID") int tripID) throws Exception {

       /* User userlogin = new User();
        request.setAttribute("loginuser", userlogin);  */
        Trip t = tripService.findTrip(tripID);
        request.setAttribute("trip", t);
        ModelAndView model = new ModelAndView("Trip/viewTrip");
        return model;
    }

    @RequestMapping(value = "trip/add", method = RequestMethod.POST)
    public String addTrip(@ModelAttribute("trip")
                          Trip trip, BindingResult result) {

        tripService.addTrip(trip);

        return "redirect:/trip/tripOverzicht.html";
    }

    @RequestMapping(value = "trip/update", method = RequestMethod.POST)
    public String updateTrip(@ModelAttribute("trip")
                             Trip trip, BindingResult result) {

        //tripService.sendMail("kdgteamf@gmail.com", "Trip update", "This is text content");

        tripService.updateTrip(trip);

        return "redirect:/trip/tripOverzicht.html";
    }

    @RequestMapping("trip/mail/{formulier}")
        public void mailTripUpdate(@PathVariable("formulier") String formulier) {

            tripService.sendMail("kdgteamf@gmail.com", "Trip update", formulier);

        }

    @RequestMapping(value = "trip/mail", method = RequestMethod.POST)
        public String mailTripUpdate2(@ModelAttribute("formulier")
                                 String formulier, BindingResult result) {

            tripService.sendMail("kdgteamf@gmail.com", "Trip update", formulier);
             return "oke";
        }

    @RequestMapping("trip/delete/{tripId}")
    public String deleteTrip(@PathVariable("tripId") Integer tripId) {

        tripService.deleteTrip(tripId);

        return "redirect:/trip/tripOverzicht.html";
    }

    @RequestMapping("/trip/admincp-{tripID}")
    public ModelAndView viewAdminTripPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("tripID") int tripID) throws Exception {
        Trip t = tripService.findTrip(tripID);
        request.setAttribute("trip", t);

        ModelAndView model = new ModelAndView("Trip/adminTrip");
        return model;
    }

}
