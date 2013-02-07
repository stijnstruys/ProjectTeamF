package be.kdg.teamf.controller;

import be.kdg.teamf.model.User;
import be.kdg.teamf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: BART.LEEMANS
 * Date: 6/02/13
 * Time: 13:19
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView userPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView("user");
        return model;
    }
	/*@RequestMapping("/")
	public String listContacts(Map<String, Object> map) {

		map.put("user", new User());
		map.put("userList", userService.listUsers());

		return "user";
	}  */

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("user")
	User user, BindingResult result) {

		userService.addUser(user);

		return "redirect:/";
	}
    public ArrayList<User> getUserList(){

        return (ArrayList<User>) userService.listUsers();
    }
}
