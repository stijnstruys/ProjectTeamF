package be.kdg.teamf.controller;

import be.kdg.teamf.model.StopPlaats;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.service.StopPlaatsService;
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
import java.util.List;

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

    @Autowired
    private TripService tripService;

   /* @RequestMapping(value = "/StopPlaats/{tripID}",method = RequestMethod.GET)
    public ModelAndView stopPlaatsPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("tripID") int tripID) throws Exception {

        User userlogin  = new User();
        request.setAttribute("loginuser",userlogin);

        StopPlaats s  = new StopPlaats();
        Trip t = tripService.findTrip(tripID);

        request.setAttribute("stopPlaats",s);

        request.setAttribute("trip", t);
        ModelAndView model = new ModelAndView("StopPlaats/stopPlaats");

        return model;
    }        */

    @RequestMapping(value = "/StopPlaats/{tripID}.html",method = RequestMethod.GET)
        public ModelAndView manageStopPlaatsPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("tripID") int tripID) throws Exception {

            StopPlaats s  = new StopPlaats();
            Trip t = tripService.findTrip(tripID);
            List<StopPlaats> stopPlaatsList = stopPlaatsService.getStopplaatsenByTrip(tripID);
            request.setAttribute("stopPlaats",s);
            //request.setAttribute("stopPlaatsList",stopPlaatsList);
            request.setAttribute("trip", t);
            ModelAndView model = new ModelAndView("StopPlaats/ManageStopPlaatsen");

            return model;
        }

    @RequestMapping(value = "/StopPlaats/add/{tripID}", method = RequestMethod.POST)
    public String addStopPlaats(@ModelAttribute("stopplaats") StopPlaats stopPlaats, BindingResult result, @PathVariable("tripID") int tripID) {

        //stopPlaatsService.addStopPlaats(stopPlaats);
        Trip t = tripService.findTrip(tripID);
        stopPlaats.setTrip(t);
        t.getStopPlaatsen().add(stopPlaats);
        tripService.updateTrip(t);
        return "redirect:/StopPlaats/" + t.getTripId() + ".html";
    }

    @RequestMapping("/StopPlaats/delete/{stopPlaatsID}")
    public String deleteUser(@PathVariable("stopPlaatsID") int stopPlaatsID) {
        StopPlaats s =  stopPlaatsService.findStopPlaats(stopPlaatsID);
        stopPlaatsService.deleteStopPlaats(s);
        return "redirect:/StopPlaats/" + s.getTrip().getTripId() + ".html";

    }
    @RequestMapping("/StopPlaats/update/{stopPlaatsID}")
    public ModelAndView updateStopPlaatsPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("stopPlaatsID") int stopPlaatsID) throws Exception {

       /* User userlogin  = new User();
        request.setAttribute("loginuser",userlogin); */

        StopPlaats s  = stopPlaatsService.findStopPlaats(stopPlaatsID);
        request.setAttribute("stopPlaats",s);
        request.setAttribute("tripID",s.getTrip().getTripId());
        ModelAndView model = new ModelAndView("StopPlaats/updateStopPlaats");
        return model;

    }
    @RequestMapping(value = "/StopPlaats/update/updateStopPlaats/{tripID}", method = RequestMethod.POST)
    public String updateStopPlaats(@ModelAttribute("stopPlaats")
                                       StopPlaats stopPlaats, BindingResult result, @PathVariable("tripID") int tripID) {

        Trip t = tripService.findTrip(tripID);
        stopPlaats.setTrip(t);
        stopPlaatsService.updateStopPlaats(stopPlaats);

        return "redirect:/user/admincp-" + t.getTripId() + ".html";

    }
    @RequestMapping(value = "/StopPlaats/release/{stopplaatsId}", method = RequestMethod.GET)
    public String releaseStopPlaats(@ModelAttribute("stopPlaats")
                                   StopPlaats stopPlaats,  BindingResult result, @PathVariable("stopplaatsId") int stopplaatsId) {


        StopPlaats s = stopPlaatsService.findStopPlaats(stopplaatsId);
        s.setVrijgegeven(true);
        stopPlaatsService.updateStopPlaats(s);
        return "redirect:/user/admincp-" + s.getTrip().getTripId() + ".html";

    }
}
