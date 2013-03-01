package be.kdg.teamf.controller;

import be.kdg.teamf.model.Deelname;
import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import be.kdg.teamf.service.DeelnameService;
import be.kdg.teamf.service.TripService;
import be.kdg.teamf.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public String addUser(@ModelAttribute("user") User user, @RequestParam("foto") MultipartFile file) {

        try {

            Blob blob = Hibernate.createBlob(file.getInputStream());
            user.setProfielFoto(blob);
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setNotificationEmail(true);
        user.setShowPosition(true);
        userService.addUser(user);

        return "redirect:/general/index.html";
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
            user.setEmail(request.getParameter("email"));
            System.out.println(request.getParameter("birthday"));
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
            try {
                user.setDateOfBirth(df.parse(request.getParameter("birthday")));
                System.out.println(request.getParameter("birthday"));
            } catch (ParseException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            userService.addUser(user);
        } else {
            user = userService.findUser(request.getParameter("userName"));
        }
        List<GrantedAuthority> gaList = new ArrayList<GrantedAuthority>();
        gaList.add(new GrantedAuthorityImpl("ROLE_USER"));
        org.springframework.security.core.userdetails.User usersec = new  org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, gaList);
        Authentication auth = new UsernamePasswordAuthenticationToken(usersec, user.getPassword(), gaList);
        org.springframework.security.core.context.SecurityContext sc = new SecurityContextImpl();
        sc.setAuthentication(auth);
        org.springframework.security.core.context.SecurityContextHolder.setContext(sc);
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
                                 User user, @RequestParam("foto") MultipartFile file) {
        User u = userService.findUser(user.getUserID());
        if (file.getSize() == 0){
            user.setProfielFoto(u.getProfielFoto());
        } else {
            try {
                Blob blob = Hibernate.createBlob(file.getInputStream());
                user.setProfielFoto(blob);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

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
        request.setAttribute("tripListParticipate", tripService.listUserParticipateTrips(userService.getCurrentUser().getUserID()));
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
        System.out.println("hier lukt het");
        return "redirect:/user/admincp-"+trip.getTripId()+".html";
    }

    @RequestMapping(value = "/user/mail", method = RequestMethod.GET)
    public @ResponseBody String mailForm(@RequestParam("mesOrg") String mesOrg, @RequestParam("followingChanges") String followingChanges, @RequestParam("formulier") String formulier, @RequestParam("orgMessage") String orgMessage, @RequestParam("viewTheTrip") String viewTheTrip) {

        ModelMap mailModel = new ModelMap();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        mailModel.addAttribute("title", "Trip update");
        mailModel.addAttribute("subtitle1", mesOrg);
        mailModel.addAttribute("message", orgMessage);
        mailModel.addAttribute("subtitle2", followingChanges);
        mailModel.addAttribute("text", formulier);
        mailModel.addAttribute("date", format.format(new Date()));
        mailModel.addAttribute("viewTheTrip", viewTheTrip);
        SimpleMailMessage msg = new SimpleMailMessage(message);
        msg.setTo("kdgteamf@gmail.com");
        tripService.sendMail(mailModel, msg);

        return "true";

    }
    /*
    @RequestMapping(value = "/user/mail.html", method = RequestMethod.POST)
    @ResponseBody
    public void mailForm(, @ModelAttribute(value = "tripID") String trip, BindingResult result) {
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
    }     */

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
    @RequestMapping("user/deleteTrip/{tripId}")
    public String deleteTrip(@PathVariable("tripId") Integer tripId) {

        Trip t = tripService.findTrip(tripId);
        if (tripService.checkOwnership(t, userService.getCurrentUser())) {
            //t.getOrganiser().getTrips().remove(t);
            //userService.updateUser(t.getOrganiser());
            tripService.deleteTrip(tripId);
        }
        return "redirect:/user/myTrips.html";
    }

    @RequestMapping(value = "/TripParticipants/{tripID}", method = RequestMethod.GET)
    public ModelAndView tripParticipantsPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("tripID") int tripID) throws Exception {

        Deelname deelname = new Deelname();
        Trip t = tripService.findTrip(tripID);
        request.setAttribute("deelnemers", deelnameService.getDeelnames(tripService.findTrip(tripID)));
        request.setAttribute("deelname", deelname);

        request.setAttribute("trip", t);
        ModelAndView model = new ModelAndView("User/tripParticipants");

        return model;
    }
    @RequestMapping(value = "/editUserequipment/{deelnameID}", method = RequestMethod.GET)
    public ModelAndView editUserequipment(HttpServletRequest request, HttpServletResponse response, @PathVariable("deelnameID") int deelnameID) throws Exception {

        Deelname deelname = deelnameService.findDeelname(deelnameID);


        request.setAttribute("deelname", deelname);
        ModelAndView model = new ModelAndView("User/editEquipment");

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

        Deelname d  = deelnameService.findDeelname(deelname.getDeelnameID());
        d.setEquipment(deelname.getEquipment());
        deelnameService.updateDeelname(d);
        return "redirect:/TripParticipants/" + d.getTrip().getTripId() + ".html";

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

    @RequestMapping(value = "/service/getUsernames", method = RequestMethod.GET)
    public
    @ResponseBody
    List<User> getUsernames() {
        List<User> test = new ArrayList<User>(userService.listUsers());

        return test;
    }

    @RequestMapping("/image/{id}")
    @ResponseBody
    public byte[] getImage(@PathVariable int id) {
        User u = userService.findUser(id);
        Blob b = u.getProfielFoto();
        try {
            return  b.getBytes(1, (int) b.length());
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

}
