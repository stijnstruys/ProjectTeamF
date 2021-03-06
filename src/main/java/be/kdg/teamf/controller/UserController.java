package be.kdg.teamf.controller;

import be.kdg.teamf.model.Trip;
import be.kdg.teamf.model.User;
import be.kdg.teamf.service.TripService;
import be.kdg.teamf.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class UserController {

    @Autowired
    private SimpleMailMessage message;

    @Autowired
    private UserService userService;

    @Autowired
    private TripService tripService;


    @RequestMapping(value="/service/login", method = RequestMethod.POST)
    @ResponseBody
    public User getUser(@ModelAttribute("user") User user,@RequestParam("username") String uname,@RequestParam("password") String pw ) {

        User newuser = userService.findUser(uname);
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(pw.getBytes());
        byte byteData[] = md.digest();

        //convert the byte to hex format
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        if(newuser != null && newuser.getPassword().equals(sb.toString())){
            if(newuser.getPassword().equals(sb.toString())){
                List<GrantedAuthority> gaList = new ArrayList<>();
                gaList.add(new GrantedAuthorityImpl("ROLE_USER"));
                org.springframework.security.core.userdetails.User usersec = new org.springframework.security.core.userdetails.User(newuser.getUsername(), newuser.getPassword(), true, true, true, true, gaList);
                Authentication auth = new UsernamePasswordAuthenticationToken(usersec, newuser.getPassword(), gaList);
                org.springframework.security.core.context.SecurityContext sc = new SecurityContextImpl();
                sc.setAuthentication(auth);
                org.springframework.security.core.context.SecurityContextHolder.setContext(sc);
                return newuser;
            }
        }
        return null;
    }


    @RequestMapping(value = "/user/user.html", method = RequestMethod.GET)
    public ModelAndView userPage(HttpServletRequest request, HttpServletResponse response) {

        User u = new User();
        request.setAttribute("user", u);
        ModelAndView model = new ModelAndView("User/user");

        return model;
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, @RequestParam("foto") MultipartFile file, HttpServletRequest request) {

        if (file.getSize() != 0) {
            Blob blob = makePhoto(file);
            user.setProfielFoto(blob);
        }
        user.setNotificationEmail(true);
        user.setShowPosition(true);
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(user.getPassword().getBytes());
        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        user.setPassword(sb.toString());
        userService.addUser(user);

        return "redirect:/general/loginAfterRegister.html";
    }

    @RequestMapping(value = "/user/addSocial", method = RequestMethod.POST)
    @ResponseBody
    public String addSocialContact(HttpServletRequest request, HttpSession session) {
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
                e.printStackTrace();
            }
            userService.addUser(user);
        } else {
            user = userService.findUser(request.getParameter("userName"));
        }
        List<GrantedAuthority> gaList = new ArrayList<GrantedAuthority>();
        gaList.add(new GrantedAuthorityImpl("ROLE_USER"));
        org.springframework.security.core.userdetails.User usersec = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, gaList);
        Authentication auth = new UsernamePasswordAuthenticationToken(usersec, user.getPassword(), gaList);
        org.springframework.security.core.context.SecurityContext sc = new SecurityContextImpl();
        sc.setAuthentication(auth);
        org.springframework.security.core.context.SecurityContextHolder.setContext(sc);
        return "/general/index.html";
    }

    @RequestMapping("/user/update/{userID}")
    public ModelAndView userPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("userID") int userID) {

        User u = userService.findUser(userID);
        request.setAttribute("user", u);
        ModelAndView model = new ModelAndView("User/updateUser");
        return model;

    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public String updateUserData(@ModelAttribute("user")
                                 User user, @RequestParam("foto") MultipartFile file) {
        User u = userService.findUser(user.getUserID());
        if (file.getSize() == 0) {
            user.setProfielFoto(u.getProfielFoto());
        } else {
            Blob blob = makePhoto(file);
            user.setProfielFoto(blob);
        }

        user.setPassword(u.getPassword());

        userService.updateUser(user);
        return "redirect:/user/profile.html";
    }

    @RequestMapping("/user/changepw")
    public ModelAndView changePwPage() {
        ModelAndView model = new ModelAndView("User/changepw");
        return model;
    }

    @RequestMapping(value = "/user/changepw", method = RequestMethod.POST)
    public String changePw(@RequestParam("currentpw") String currentpw, @RequestParam("newpw") String newpw, @RequestParam("confirmpw") String confirmpw) {

        User u = userService.getCurrentUser();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(currentpw.getBytes());
        byte byteData[] = md.digest();

        //convert the byte to hex format
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        md.update(newpw.getBytes());
        byte byteData2[] = md.digest();

        //convert the byte to hex format
        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i < byteData2.length; i++) {
            sb2.append(Integer.toString((byteData2[i] & 0xff) + 0x100, 16).substring(1));
        }
        if (newpw.equals(confirmpw)) {
            if (u.getPassword().equals(sb.toString())) {
                u.setPassword(sb2.toString());
                userService.updateUser(u);
            } else {
                return "redirect:/user/changepw.html";
            }
        } else {
            return "redirect:/user/changepw.html";
        }

        return "redirect:/user/profile.html";
    }

    @RequestMapping(value = "/user/profile")
    public ModelAndView profile(HttpServletRequest request) {

        User u = userService.getCurrentUser();

        request.setAttribute("user", u);

        ModelAndView model = new ModelAndView("User/profile");
        return model;
    }

    @RequestMapping(value = "/user/profile-{userid}")
    public ModelAndView viewProfile(HttpServletRequest request, @PathVariable("userid") int userid) {
        User u = userService.findUser(userid);
        request.setAttribute("user", u);
        ModelAndView model = new ModelAndView("User/viewProfile");
        return model;
    }

    @RequestMapping(value = "/user/myTrips.html", method = RequestMethod.GET)
    public ModelAndView tripOverzichtPage(HttpServletRequest request, HttpServletResponse response) {

        Trip t = new Trip();
        request.setAttribute("trip", t);
        request.setAttribute("tripList", tripService.listUserTrips(userService.getCurrentUser().getUserID()));
        request.setAttribute("tripListParticipate", tripService.listUserParticipateTrips(userService.getCurrentUser().getUserID()));
        ModelAndView model = new ModelAndView("User/myTrips");
        return model;
    }

    @RequestMapping("/user/admincp-{tripID}")
    public ModelAndView viewAdminTripPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("tripID") int tripID) {
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


    @RequestMapping(value = "/user/mail", method = RequestMethod.GET)
    @ResponseBody
    public String mailForm(@RequestParam("mesOrg") String mesOrg, @RequestParam("followingChanges") String followingChanges, @RequestParam("formulier") String formulier, @RequestParam("orgMessage") String orgMessage, @RequestParam("tripID") int tripID, @RequestParam("viewTheTrip") String viewTheTrip) {
        ArrayList<String> emails = new ArrayList(tripService.listUserEmailPerTrips(tripID));

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

        msg.setCc(emails.toArray(new String[0]));
        tripService.sendMail(mailModel, msg);

        return "true";

    }

    @RequestMapping(value = "/user/checkusername", method = RequestMethod.GET)
    @ResponseBody
    public String getUserInJson(@RequestParam("name") String name) {

        User u = userService.findUser(name);
        if (u == null) {
            return "false";
        } else {
            return "true";
        }
    }



    @RequestMapping("/image/{id}")
    @ResponseBody
    public byte[] getImage(@PathVariable int id) {
        User u = userService.findUser(id);
        Blob b = u.getProfielFoto();
        try {
            return b.getBytes(1, (int) b.length());

        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }


    private Blob makePhoto(MultipartFile f){
        Blob blob = null;
        try {
            blob = Hibernate.createBlob(f.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return blob;
    }
}