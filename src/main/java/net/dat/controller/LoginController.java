package net.dat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.dat.model.User;
import net.dat.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLogin(ModelAndView model) {
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView postlogin(HttpServletRequest request, HttpServletResponse response) {
		User loginUser = new User();
		loginUser.setUsername(request.getParameter("username"));
		loginUser.setPassword(request.getParameter("password"));
		User authUser = userService.validateUser(loginUser);
		if (authUser != null)
			return new ModelAndView("redirect:/");
		else
			return new ModelAndView("unauthorize");
	}
}
