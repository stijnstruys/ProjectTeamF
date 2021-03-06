package be.kdg.teamf.controller;

import be.kdg.teamf.model.BroadcastMessage;
import be.kdg.teamf.model.Chat;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import be.kdg.teamf.service.BroadcastMessageService;
import be.kdg.teamf.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @RequestMapping(value="/broadcast/getMessages", method = RequestMethod.GET)
    @ResponseBody
    public List<BroadcastMessage> getChats(@RequestParam("trip") int tripid) {
        List<BroadcastMessage> cl = new ArrayList<BroadcastMessage>();

        Trip t = tripService.findTrip(tripid);
        List<BroadcastMessage> temp =  broadcastMessageService.getBroadcastMessages(tripid);
        return temp;

    }
}
