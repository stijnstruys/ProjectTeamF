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
import javax.servlet.http.HttpSession;
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
    public String addUser(@ModelAttribute("user") User user, BindingResult result) {
        user.setNotificationEmail(true);
        user.setShowPosition(true);
        userService.addUser(user);

        return "redirect:/user/user.html";
    }

    @RequestMapping(value = "/user/addSocial", method = RequestMethod.POST)
    public
    @ResponseBody
    String addSocialContact(HttpServletRequest request, HttpSession session) {
        User user = new User();

        if (userService.findUser(request.getParameter("userName")) == null) {
            user.setUsername(request.getParameter("userName"));
            user.setPassword(request.getParameter("id"));
            user.setFirstName((request.getParameter("firstName")));
            user.setLastName(request.getParameter("lastName"));

            userService.addUser(user);

            /*Social social = new Social();

            social.setSocialType(request.getParameter("type"));
            social.setAccountId(request.getParameter("id"));
            social.setUserName(request.getParameter("typeUserName"));
            social.setUser(user);*/

          /*  try {
                socialService.add(social);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }*/
        } else {
            user = userService.findUser(request.getParameter("userName"));
        }
         logIn(user,null);
        /*
        user.setPassword(request.getParameter("id"));
        int userID = userService.login(user);
        if (userID > -1) {
            session.setAttribute("userID", userID);
            return "user/dashboard";
        } else {
            return "login";
        }*/
        return "/general/index.html";
    }

    @RequestMapping("/user/deleteUser/{userID}")
    public String deleteUser(@PathVariable("userID") int userID) {

        userService.deleteUser(userService.findUser(userID));
        return "redirect:/user/user.html";

    }

    @RequestMapping("/user/update/{userID}")
    public ModelAndView userPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("userID") int userID) throws Exception {

        User u = userService.findUser(userID);
        request.setAttribute("user", u);
        ModelAndView model = new ModelAndView("User/updateUser");
        return model;

    }
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public String updateUserData(@ModelAttribute("user")
                                 User user, BindingResult result) {

        User u = userService.findUser(user.getUserID());
        user.setPassword(u.getPassword());

        userService.updateUser(user);
        return "redirect:/user/profile.html";
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

        return "redirect:/user/admincp-"+trip.getTripId()+".html";
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
        tripService.sendInvite(mailModel, msg);
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
        Trip t = tripService.findTrip(tripID);
        request.setAttribute("deelnemers", deelnameService.getDeelnames(tripService.findTrip(tripID)));
        request.setAttribute("tripID", t.getTripId());

        request.setAttribute("trip", t);
        ModelAndView model = new ModelAndView("User/tripParticipants");

        return model;
    }

    @RequestMapping(value = "/TripParticipants/updateTripParticipants/{tripID}", method = RequestMethod.POST)
    public String updateTripParticipants(@ModelAttribute("tripParticipant")
                                         Deelname deelname, BindingResult result, @PathVariable("tripID") int tripID) {


        deelnameService.updateDeelname(deelname);
        return "redirect:/user/admincp-" + deelname.getTrip().getTripId() + ".html";

    }

    @RequestMapping(value = "/TripParticipants/updateDeelname", method = RequestMethod.POST)
    public String updateDeelnemer(@ModelAttribute("tripParticipant")
                                  Deelname deelname, BindingResult result) {

        Deelname d = deelnameService.findDeelname(deelname.getDeelnameID());
        d.setEquipment(deelname.getEquipment());
        deelnameService.updateDeelname(d);
        return "redirect:/TripParticipants/" + d.getTrip().getTripId() + ".html";

    }
    @RequestMapping(value = "/editUserequipment/{deelnameID}", method = RequestMethod.GET)
    public ModelAndView editEquipment(HttpServletRequest request, HttpServletResponse response, @PathVariable("deelnameID") int deelnameID) throws Exception {

        request.setAttribute("deelname",deelnameService.findDeelname(deelnameID));
        ModelAndView model = new ModelAndView("User/editEquipment");


        return model;
    }
    @RequestMapping(value = "/user/checkusername", method = RequestMethod.GET)
    public @ResponseBody String getUserInJson(@RequestParam("name") String name) {

        User u = userService.findUser(name);
        if(u == null) {
            return "false";
        } else {
            return "true";
        }
    }
    @RequestMapping(value = "/user/loginfailed", method = RequestMethod.GET)
    public ModelAndView loginFailed(HttpServletRequest request, HttpServletResponse response) throws Exception {


        ModelAndView model = new ModelAndView("General/loginFailed");


        return model;
    }
    @RequestMapping(value = "/TripParticipants/{tripID}/invite", method = RequestMethod.POST)
    public String inviteDeelnemer(@RequestParam("email") String email, @PathVariable("tripID") int tripID) {


        Trip t = tripService.findTrip(tripID);


        ModelMap mailModel = new ModelMap();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        mailModel.addAttribute("title", "Trip Invite");
        mailModel.addAttribute("subtitle1", "Message from organiser");
        mailModel.addAttribute("message", "U bent uitgenodigd voor trip: " + t.getTripName());
        mailModel.addAttribute("link", "http://localhost:8080/ProjectTeamF-1.0/trip/"+ t.getTripId() +".html");

        mailModel.addAttribute("date", format.format(new Date()));

        SimpleMailMessage msg = new SimpleMailMessage(message);
        msg.setTo(email);
        tripService.sendInvite(mailModel, msg);
        return "redirect:/TripParticipants/" + tripID + ".html";

    }
}
