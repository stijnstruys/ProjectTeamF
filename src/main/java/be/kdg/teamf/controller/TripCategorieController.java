package be.kdg.teamf.controller;

import be.kdg.teamf.model.TripCategorie;
import be.kdg.teamf.model.User;
import be.kdg.teamf.service.TripCategorieService;
import be.kdg.teamf.service.TripService;
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

  /*  @RequestMapping(value = "tripCategorie/add", method = RequestMethod.POST)
               public String addTripCategorie(@ModelAttribute("tripCategorie")
                         TripCategorie tripCategorie, BindingResult result) {

                   tripCategorieService.addTripCategorie(tripCategorie);

                   return "redirect:/trip/addTrip.html";
               }      */
}
