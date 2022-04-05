package net.dat.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.dat.dao.UserDAO;
import net.dat.model.User;
import net.dat.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		for (User user : userService.getUsers()) {
			System.out.println(user);
		}
		return new ModelAndView("home");
	}
}
