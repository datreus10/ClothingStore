package net.dat.store.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.dat.store.dto.AuthUserDTO;
import net.dat.store.model.User;
import net.dat.store.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/admin")
	public ModelAndView adminPage(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView("admin/index");
		mv.addObject("activeBar", 0);
		return mv;
	}

	@RequestMapping(value = "/admin/user", method = RequestMethod.GET)
	public ModelAndView getAdminCustomer(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView("admin/user");
		mv.addObject("users", userService.getUsers());
		mv.addObject("activeBar", 1);
		return mv;
	}

	@RequestMapping(value = "/admin/user/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteUser(HttpServletRequest req, HttpServletResponse res) {

		int result = userService.deleteUserById(req.getParameter("userId"));
		return String.format("{\"success\":%d}", result);
	}

	@RequestMapping(value = "/admin/user/edit")
	public ModelAndView editUser(HttpServletRequest req, HttpServletResponse res){
		User user = userService.getById(req.getParameter("userId"));
		ModelAndView mv= new ModelAndView("admin/editUser");
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping(value = "/admin/user/edit",method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute User user){
		userService.updateUser(user);
		ModelAndView mv= new ModelAndView("admin/editUser");
		return mv;
	}
}
