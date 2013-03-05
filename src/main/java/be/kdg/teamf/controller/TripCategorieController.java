package be.kdg.teamf.controller;

import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.TripCategorie;
import be.kdg.teamf.service.TripCategorieService;
import be.kdg.teamf.service.TripService;
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
 * Date: 12/02/13
 * Time: 14:32
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class TripCategorieController {

    @Autowired
    private TripCategorieService tripCategorieService;
    @Autowired
    private TripService tripService;

    @RequestMapping(value = "/TripCategorie/{tripID}", method = RequestMethod.GET)
    public ModelAndView tripCategoriePage(HttpServletRequest request, HttpServletResponse response, @PathVariable("tripID") int tripID)  {

        TripCategorie s = new TripCategorie();
        Trip t = tripService.findTrip(tripID);

        request.setAttribute("tripCategorie", s);

        request.setAttribute("trip", t);
        ModelAndView model = new ModelAndView("TripCategorie/tripCategorie");

        return model;
    }


    @RequestMapping(value = "/TripCategorie/add/{tripID}", method = RequestMethod.POST)
    public String addTripCategorie(@ModelAttribute("tripCategorie") TripCategorie tripCategorie, BindingResult result, @PathVariable("tripID") int tripID) {

        Trip t = tripService.findTrip(tripID);
        tripCategorie.setTrip(t);
        t.getTripCategorieen().add(tripCategorie);
        tripService.updateTrip(t);
        tripCategorieService.addTripCategorie(tripCategorie);
        return "redirect:/TripCategorie/" + t.getTripId() + ".html";
    }

    @RequestMapping("/TripCategorie/delete/{tripCategorieId}")
    public String deleteTripCategorie(@PathVariable("tripCategorieId") int tripCategorieId) {
        TripCategorie tc = tripCategorieService.findTripCategorie(tripCategorieId);
        tripCategorieService.removeTripCategorie(tc);
        return "redirect:/TripCategorie/" + tc.getTrip().getTripId() + ".html";

    }

    @RequestMapping("/TripCategorie/update-{tripCategorieId}")
    public ModelAndView updateTripCategoriePage(HttpServletRequest request, HttpServletResponse response, @PathVariable("tripCategorieId") int tripCategorieId) throws Exception {



        TripCategorie tc = tripCategorieService.findTripCategorie(tripCategorieId);
        request.setAttribute("tripCategorie", tc);
        request.setAttribute("tripID", tc.getTrip().getTripId());
        ModelAndView model = new ModelAndView("TripCategorie/updateTripCategorie");
        return model;

    }

    @RequestMapping(value = "/TripCategorie/update/{tripID}", method = RequestMethod.POST)
    public String updateTripCategorie(@ModelAttribute("tripCategorie")
                                      TripCategorie tripCategorie, BindingResult result, @PathVariable("tripID") int tripID) {

        tripCategorie.setTrip(tripService.findTrip(tripID));
        tripCategorieService.updateTripCategorie(tripCategorie);

        return "redirect:/TripCategorie/" + tripID + ".html";

    }

}
