package be.kdg.teamf.controller;

import be.kdg.teamf.model.Trip;
import be.kdg.teamf.service.*;
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
 * User: Jeroen
 * Date: 7/02/13
 * Time: 21:51
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class TripController {

    @Autowired
    private TripService tripService;

    @RequestMapping(value = "/trip/trip.html",method = RequestMethod.GET)
        public ModelAndView tripPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

            Trip t  = new Trip();
            request.setAttribute("trip",t);
            ModelAndView model = new ModelAndView("Trip/trip");
            return model;
        }

    @RequestMapping(value = "trip/add", method = RequestMethod.POST)
                public String addTrip(@ModelAttribute("trip")
                  Trip trip, BindingResult result) {

                    tripService.addTrip(trip);

                    return "redirect:/";
                }

    @RequestMapping(value = "trip/update", method = RequestMethod.POST)
            public String updateTrip(@ModelAttribute("trip")
              Trip trip, BindingResult result) {

                tripService.updateTrip(trip);

                return "redirect:/";
            }

    @RequestMapping("trip/delete/{contactId}")
        public String deleteTrip(@PathVariable("tripId")
        Integer tripId) {

            tripService.deleteTrip(tripId);

            return "redirect:/";
        }

}
