package be.kdg.teamf.controller;

import be.kdg.teamf.model.User;
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
 * User: BART.LEEMANS
 * Date: 6/02/13
 * Time: 13:19
 * To change this template use File | Settings | File Templates.
 */
@Controller
//@RequestMapping("/user/user.html")
public class UserController {

    @Autowired
    private UserService userService;

	/*@RequestMapping("/")
	public String listContacts(Map<String, Object> map) {

		map.put("user", new User());
		map.put("userList", userService.listUsers());

		return "user";
    }  */
    @RequestMapping(value = "/user/user.html",method = RequestMethod.GET)
    public ModelAndView userPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        /*User userlogin  = new User();
        request.setAttribute("loginuser",userlogin); */

        User u  = new User();
        request.setAttribute("user",u);
        request.setAttribute("userList",userService.listUsers());
        ModelAndView model = new ModelAndView("User/user");

        return model;
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user")
                          User user, BindingResult result) {

        userService.addUser(user);

        return "redirect:/user/user.html";
    }

    @RequestMapping("/user/delete/{userID}")
    public String deleteUser(@PathVariable("userID") int userID) {

        userService.deleteUser(userService.findUser(userID));
        return "redirect:/user/user.html";

    }
    @RequestMapping("/user/update/{userID}")
    public ModelAndView userPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("userID") int userID) throws Exception {

       /* User userlogin  = new User();
        request.setAttribute("loginuser",userlogin); */

        User u  = userService.findUser(userID);
        request.setAttribute("user",u);
        ModelAndView model = new ModelAndView("User/updateUser");
        return model;

    }
    @RequestMapping(value = "/user/update/updateUser", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user")
                                 User user, BindingResult result) {

        userService.updateUser(user);

        return "redirect:/user/user.html";
    }

    @RequestMapping(value = "/user/login",method = RequestMethod.GET)
    public String logIn(@ModelAttribute("loginuser") User user, BindingResult result) {

       User loginUser = userService.findUser(user.getUsername()) ;
         if (loginUser.getPassword().equals( user.getPassword())) {
                 return "redirect:/general/index.html";
         }   else {
             //wrong pasword page maken
             return "redirect:/general/index.html";
         }

    }
}
