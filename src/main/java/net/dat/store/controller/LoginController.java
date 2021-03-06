package net.dat.store.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.dat.store.dto.AuthUserDTO;
import net.dat.store.model.User;
import net.dat.store.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/index" })
	public ModelAndView index(HttpServletRequest req, HttpServletResponse res) {
		AuthUserDTO user = (AuthUserDTO) req.getSession().getAttribute("user");
		if (user == null)
			return new ModelAndView("redirect:/login");
		else if (user.getRole().equals("admin"))
			return new ModelAndView("redirect:/admin");
		else
			return new ModelAndView("client/index");

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLogin(HttpServletRequest req, HttpServletResponse res) {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView postLogin(HttpServletRequest req, HttpServletResponse res) {
		User loginUser = new User();
		loginUser.setUsername(req.getParameter("username"));
		loginUser.setPassword(req.getParameter("password"));
		AuthUserDTO authUser = userService.validateUser(loginUser);
		req.getSession().setAttribute("user", authUser);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView getRegister(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("user", new User());
		return mv;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user, HttpServletRequest req, HttpServletResponse res) {
		user.setRole("user");
		userService.addNewUser(user);
		return new ModelAndView("redirect:/login");
	}
}
