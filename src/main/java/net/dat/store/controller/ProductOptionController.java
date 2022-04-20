package net.dat.store.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.dat.store.service.ProductOptionService;

@Controller
public class ProductOptionController {
	@Autowired
	private ProductOptionService optionService;
	
	@RequestMapping(value = "/admin/product/opt", method = RequestMethod.DELETE)
	@ResponseBody
	public String postAdd(HttpServletRequest req, HttpServletResponse res) {
		int result = optionService.deleteById(req.getParameter("id"));
		return String.format("{\"msg\":\"success\",\"result\":%d}", result);
	}
}
