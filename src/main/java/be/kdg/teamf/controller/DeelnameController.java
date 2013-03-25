package be.kdg.teamf.controller;

import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import be.kdg.teamf.service.DeelnameService;
import be.kdg.teamf.service.TripService;
import be.kdg.teamf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Jorne
 * Date: 5/03/13
 * Time: 12:58
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class DeelnameController {

    @Autowired
    private SimpleMailMessage message;

    @Autowired
    private TripService tripService;

    @Autowired
    private UserService userService;

    @Autowired
    private DeelnameService deelnameService;

    //invite mail sturen
    @RequestMapping(value = "TripParticipants/{tripID}/invite", method = RequestMethod.POST)
    public String sendInvite(@PathVariable(value = "tripID") int trip,@RequestParam(value = "email") String email) {
        Trip t = tripService.findTrip(trip);
        ModelMap mailModel = new ModelMap();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        mailModel.addAttribute("title", "Trip update");
        mailModel.addAttribute("subtitle1", "Message from organiser");
        mailModel.addAttribute("message", "U bent uitgenodigd voor trip " +t.getTripName() );
        mailModel.addAttribute("link", "http://localhost:8080/ProjectTeamF-1.0/trip/" + trip + ".html");

        mailModel.addAttribute("date", format.format(new Date()));

        SimpleMailMessage msg = new SimpleMailMessage(message);
        msg.setTo(email);
        tripService.sendInvite(mailModel, msg);
        return "redirect:/TripParticipants/" + trip + ".html";
    }

    // deelnamepagina
    @RequestMapping(value = "/TripParticipants/{tripID}", method = RequestMethod.GET)
    public ModelAndView tripParticipantsPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("tripID") int tripID) {

        Deelname deelname = new Deelname();
        Trip t = tripService.findTrip(tripID);
        request.setAttribute("deelnemers", deelnameService.getDeelnamesByTrip(tripService.findTrip(tripID)));
        request.setAttribute("deelname", deelname);

        request.setAttribute("trip", t);
        ModelAndView model = new ModelAndView("User/tripParticipants");

        return model;
    }
    //pagina om equipent aan te passen
    @RequestMapping(value = "/editUserequipment/{deelnameID}", method = RequestMethod.GET)
    public ModelAndView editUserequipment(HttpServletRequest request, HttpServletResponse response, @PathVariable("deelnameID") int deelnameID)  {

        Deelname deelname = deelnameService.findDeelname(deelnameID);


        request.setAttribute("deelname", deelname);
        ModelAndView model = new ModelAndView("User/editEquipment");

        return model;
    }
    //opslaan en teruggaan naar adminpagina
    @RequestMapping(value = "/TripParticipants/updateTripParticipants/{tripID}", method = RequestMethod.POST)
    public String updateTripParticipants(@ModelAttribute("tripParticipant")
                                         Deelname deelname, BindingResult result, @PathVariable("tripID") int tripID) {


        deelnameService.updateDeelname(deelname);
        return "redirect:/user/admincp-" + deelname.getTrip().getTripId() + ".html";

    }
    //updaten en teruggaan
    @RequestMapping(value = "/TripParticipants/updateDeelname", method = RequestMethod.POST)
    public String updateDeelnemer(@ModelAttribute("tripParticipant")
                                  Deelname deelname, BindingResult result) {

        Deelname d  = deelnameService.findDeelname(deelname.getDeelnameID());
        d.setEquipment(deelname.getEquipment());
        deelnameService.updateDeelname(d);
        return "redirect:/TripParticipants/" + d.getTrip().getTripId() + ".html";

    }

    @RequestMapping(value="/service/updatePosition", method = RequestMethod.POST,headers = "Accept=application/json")
    public void updatePosition(@RequestParam(value = "lng")Double lng,@RequestParam(value = "lat") Double lat,@RequestParam(value = "userid") int userid,@RequestParam(value = "tripid") int tripid) {
        Trip t = tripService.findTrip(tripid);
        User u = userService.findUser(userid);
        Deelname d = deelnameService.findDeelname(t,u);
        d.setLat(lat);
        d.setLng(lng);
        deelnameService.updateDeelname(d);
    }

    @RequestMapping(value="/service/getPositions", method = RequestMethod.GET)
    public String getPositions() {
        return null;
    }
}
