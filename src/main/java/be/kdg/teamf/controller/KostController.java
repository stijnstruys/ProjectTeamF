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


    @RequestMapping(value = "/kost/kostManagement", method = RequestMethod.GET)
    public ModelAndView manageKosts(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("deelnames", deelnameService.getDeelnamesByUser(userService.getCurrentUser()));
        ModelAndView model = new ModelAndView("Kost/kostManagement");
        return model;
    }

    @RequestMapping(value = "/kost/adminKostTrip{tripId}", method = RequestMethod.GET)
    public ModelAndView adminKostTrip(HttpServletRequest request, HttpServletResponse response, @PathVariable("tripId") int tripId) {

        Trip t = tripService.findTrip(tripId);

        request.setAttribute("deelnames", deelnameService.getDeelnames(t));
        request.setAttribute("trip", t);

        ModelAndView model = new ModelAndView("Kost/adminKostTrip");
        return model;
    }

    @RequestMapping(value = "/kost/add", method = RequestMethod.POST)
    public String addKost(@ModelAttribute("kost") Kost kost, @RequestParam("tripId") int tripId, HttpServletRequest request) {

        Trip t = tripService.findTrip(tripId);
        kost.setDeelname(deelnameService.findDeelname(t, userService.getCurrentUser()));

        kostService.addKost(kost);
        return "redirect:/kost/kostenPerTrip" + tripId + ".html";
    }

    @RequestMapping(value = "kost/update/{kostId}", method = RequestMethod.POST)
    public String updateKost(@ModelAttribute("kost") Kost kost, BindingResult result) {
        Kost k = kostService.findKost(kost.getKostId());
        kost.setDeelname(k.getDeelname());
        kostService.updateKost(kost);
        return "redirect:/kost/kostenPerTrip" + kost.getDeelname().getTrip().getTripId() + ".html";
    }

    @RequestMapping(value = "/kost/delete/{kostId}", method = RequestMethod.GET)
    public String deleteKost(@PathVariable("kostId") int kostId) {
        Kost k = kostService.findKost(kostId);
        kostService.deleteKost(k);
        return "redirect:/kost/kostenPerTrip" + k.getDeelname().getTrip().getTripId() + ".html";
    }

    @RequestMapping(value = "/kost/kostenPerTrip{tripId}", method = RequestMethod.GET)
    public ModelAndView kostenPerTrip(@PathVariable("tripId") int tripId, HttpServletRequest request) {

        Deelname d = deelnameService.findDeelname(tripService.findTrip(tripId), userService.getCurrentUser());
        Kost k = new Kost();
        request.setAttribute("kost", k);
        request.setAttribute("deelname", d);
        request.setAttribute("trip", d.getTrip());
        ModelAndView model = new ModelAndView("Kost/kostenPerTrip");

        return model;
    }

    @RequestMapping("/kost/update-{kostId}")
        public ModelAndView updateKostPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("kostId") int kostId) throws Exception {

            Kost k = kostService.findKost(kostId);
            request.setAttribute("kost", k);
            ModelAndView model = new ModelAndView("Kost/updateKost");
            return model;

        }
}
