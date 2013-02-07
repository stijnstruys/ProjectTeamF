package be.kdg.teamf.controller;

import be.kdg.teamf.model.User;
import be.kdg.teamf.service.UserService;
import be.kdg.teamf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import be.kdg.teamf.service.UserService;

import java.util.Map;

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
	private UserService userService;

	@RequestMapping("/")
	public String listContacts(Map<String, Object> map) {

		map.put("user", new User());
		map.put("userList", userService.listUsers());

		return "user";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("user")
	User user, BindingResult result) {

		userService.addUser(user);

		return "redirect:/";
	}
}
