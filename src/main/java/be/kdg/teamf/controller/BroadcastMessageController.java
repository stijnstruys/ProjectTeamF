package be.kdg.teamf.controller;

import be.kdg.teamf.model.BroadcastMessage;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.service.BroadcastMessageService;
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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 12/03/13
 * Time: 15:09
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class BroadcastMessageController {

    @Autowired
    private BroadcastMessageService broadcastMessageService;
    @Autowired
    private TripService tripService;

    @RequestMapping(value = "/BroadcastMessage/{tripID}", method = RequestMethod.GET)
    public ModelAndView broadcastMessagePage(HttpServletRequest request, HttpServletResponse response, @PathVariable("tripID") int tripID) {

        BroadcastMessage broadcastMessage = new BroadcastMessage();
        Trip t = tripService.findTrip(tripID);

        request.setAttribute("broadcastMessage", broadcastMessage);
        request.setAttribute("trip", t);

        ModelAndView model = new ModelAndView("Broadcast/broadcastMessage");

        return model;
    }

    @RequestMapping(value = "/BroadcastMessage/add/{tripID}", method = RequestMethod.POST)
    public String addBroadcastMessage(@ModelAttribute("broadcastMessage") BroadcastMessage broadcastMessage, BindingResult result, @PathVariable("tripID") int tripID) {

        Date currentDate = new Date();

        Trip t = tripService.findTrip(tripID);
        broadcastMessage.setTrip(t);
        broadcastMessage.setDate(currentDate);
        t.getBroadcastMessages().add(broadcastMessage);
        broadcastMessageService.addBroadcastMessage(broadcastMessage);
        tripService.updateTrip(t);
        return "redirect:/BroadcastMessage/" + t.getTripId() + ".html";
    }
}
