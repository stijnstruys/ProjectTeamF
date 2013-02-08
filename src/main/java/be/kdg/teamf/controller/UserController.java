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

    @RequestMapping(value = "/user/user.html",method = RequestMethod.GET)
    public ModelAndView userPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        User u  = new User();
        request.setAttribute("user",u);
        request.setAttribute("userList",userService.listUsers());
        ModelAndView model = new ModelAndView("user");

        return model;
    }
	/*@RequestMapping("/")
	public String listContacts(Map<String, Object> map) {

		map.put("user", new User());
		map.put("userList", userService.listUsers());

		return "user";
    }  */



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

}
