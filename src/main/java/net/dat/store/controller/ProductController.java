package net.dat.store.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.dat.store.model.User;
import net.dat.store.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/admin/product")
	public ModelAndView getProduct(HttpServletRequest req, HttpServletResponse res){
		
		ModelAndView mv = new ModelAndView("admin/product");
		mv.addObject("products", productService.getProducts());
		mv.addObject("activeBar", 2);
		return mv;
	}
}
