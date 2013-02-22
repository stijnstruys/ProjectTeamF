package be.kdg.teamf.controller;

import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import be.kdg.teamf.service.DeelnameService;
import be.kdg.teamf.service.TripService;
import be.kdg.teamf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
 * User: BART.LEEMANS
 * Date: 6/02/13
 * Time: 13:19
 * To change this template use File | Settings | File Templates.
 */
@Controller
//@RequestMapping("/user/user.html")
public class UserController {

    @Autowired
    private SimpleMailMessage message;

    @Autowired
    private UserService userService;

    @Autowired
    private TripService tripService;

    @Autowired
    private DeelnameService deelnameService;

    /*@RequestMapping("/")
    public String listContacts(Map<String, Object> map) {

        map.put("user", new User());
        map.put("userList", userService.listUsers());

        return "user";
    }  */
    @RequestMapping(value = "/user/user.html", method = RequestMethod.GET)
    public ModelAndView userPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        /*User userlogin  = new User();
        request.setAttribute("loginuser",userlogin); */

        User u = new User();
        request.setAttribute("user", u);
        request.setAttribute("userList", userService.listUsers());
        ModelAndView model = new ModelAndView("User/user");

        return model;
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user")
                          User user, BindingResult result) {

        userService.addUser(user);

        return "redirect:/user/user.html";
    }

    @RequestMapping("/user/deleteUser/{userID}")
    public String deleteUser(@PathVariable("userID") int userID) {

        userService.deleteUser(userService.findUser(userID));
        return "redirect:/user/user.html";

    }

    @RequestMapping("/user/updateUser/{userID}")
    public ModelAndView userPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("userID") int userID) throws Exception {

        User u = userService.findUser(userID);
        request.setAttribute("user", u);
        ModelAndView model = new ModelAndView("User/updateUser");
        return model;

    }

    @RequestMapping(value = "/user/update/updateUser", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user, BindingResult result) {

        userService.updateUser(user);

        return "redirect:/user/user.html";
    }

    @RequestMapping("/user/changepw")
    public ModelAndView changePw() {
        ModelAndView model = new ModelAndView("User/changepw");
        return model;
    }

    @RequestMapping(value = "/user/changepw", method = RequestMethod.POST)
    public String changePw(@RequestParam("currentpw") String currentpw, @RequestParam("newpw") String newpw, @RequestParam("confirmpw") String confirmpw) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User u = userService.findUser(auth.getName());

        if (newpw.equals(confirmpw)) {
            if (u.getPassword().equals(currentpw)) {
                u.setPassword(newpw);
                userService.updateUser(u);
            } else {
                return "redirect:/user/changepw.html";
            }
        } else {
            return "redirect:/user/changepw.html";
        }


        return "redirect:/user/profile.html";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String logIn(@ModelAttribute("loginuser") User user, BindingResult result) {

        User loginUser = userService.findUser(user.getUsername());
        if (loginUser.getPassword().equals(user.getPassword())) {
            return "redirect:/general/index.html";
        } else {
            //wrong pasword page maken
            return "redirect:/general/index.html";
        }

    }

    @RequestMapping(value = "/user/profile")
    public ModelAndView profile(HttpServletRequest request) throws Exception {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User u = userService.findUser(auth.getName());

        request.setAttribute("user", u);

        ModelAndView model = new ModelAndView("User/profile");
        return model;
    }

    @RequestMapping(value = "/user/myTrips.html", method = RequestMethod.GET)
    public ModelAndView tripOverzichtPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Trip t = new Trip();
        request.setAttribute("trip", t);
        request.setAttribute("tripList", tripService.listUserTrips(userService.getCurrentUser().getUserID()));
        ModelAndView model = new ModelAndView("User/myTrips");
        return model;
    }

    @RequestMapping("/user/admincp-{tripID}")
    public ModelAndView viewAdminTripPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("tripID") int tripID) throws Exception {
        Trip t = tripService.findTrip(tripID);
        ModelAndView model;
        if (tripService.checkOwnership(t, userService.getCurrentUser())) {
            request.setAttribute("trip", t);
            model = new ModelAndView("User/adminTrip");
        } else {
            model = new ModelAndView("User/myTrips");
        }
        return model;
    }

    @RequestMapping(value = "user/updateTrip", method = RequestMethod.POST)
    public String updateTrip(@ModelAttribute("trip")
                             Trip trip, BindingResult result) {
        trip.setOrganiser(userService.getCurrentUser());
        tripService.updateTrip(trip);

        return "redirect:/user/myTrips.html";
    }

    @RequestMapping(value = "/user/mail.html", method = RequestMethod.POST)
    @ResponseBody
    public void mailForm(@RequestParam("formulier") String formulier, @RequestParam("orgMessage") String orgMessage, @ModelAttribute(value = "tripID") String trip, BindingResult result) {
        ModelMap mailModel = new ModelMap();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        mailModel.addAttribute("title", "Trip update");
        mailModel.addAttribute("subtitle1", "Message from organiser");
        mailModel.addAttribute("message", orgMessage);
        mailModel.addAttribute("subtitle2", "The following trip changes occured");
        mailModel.addAttribute("text", formulier);
        mailModel.addAttribute("date", format.format(new Date()));

        SimpleMailMessage msg = new SimpleMailMessage(message);
        msg.setTo("kdgteamf@gmail.com");
        tripService.sendMail(mailModel, msg);
    }

    @RequestMapping("user/deleteTrip/{tripId}")
    public String deleteTrip(@PathVariable("tripId") Integer tripId) {

        Trip t = tripService.findTrip(tripId);
        if (tripService.checkOwnership(t, userService.getCurrentUser())) {
            t.getOrganiser().getTrips().remove(t);
            userService.updateUser(t.getOrganiser());
            tripService.deleteTrip(tripId);
        }
        return "redirect:/user/myTrips.html";
    }

    @RequestMapping(value = "/TripParticipants/{tripID}", method = RequestMethod.GET)
    public ModelAndView tripParticipantsPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("tripID") int tripID) throws Exception {

        Deelname deelname = new Deelname();
        deelnameService.getDeelnames(tripService.findTrip(tripID));
        Trip t = tripService.findTrip(tripID);
        request.setAttribute("deelnemers", deelname);

        request.setAttribute("trip", t);
        ModelAndView model = new ModelAndView("User/tripParticipants");

        return model;
    }

    @RequestMapping(value = "/TripParticipants/update/updateTripParticipants/{tripID}", method = RequestMethod.POST)
    public String updateTripParticipants(@ModelAttribute("tripParticipant")
                                      Deelname deelname, BindingResult result, @PathVariable("tripID") int tripID) {
        deelnameService.updateDeelname(deelname);

        return "redirect:/user/admincp-" + deelname.getTrip().getTripId() + ".html";

    }
}
