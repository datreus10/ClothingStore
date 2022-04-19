package net.dat.store.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.dat.store.model.Product;
import net.dat.store.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/admin/product")
	public ModelAndView getProduct() {
		ModelAndView mv = new ModelAndView("admin/product");
		mv.addObject("products", productService.getProducts());
		mv.addObject("activeBar", 2);
		return mv;
	}

	@RequestMapping(value = "/admin/product/new", method = RequestMethod.GET)
	public ModelAndView getAdd() {
		ModelAndView mv = new ModelAndView("admin/addProduct");
		mv.addObject("activeBar", 2);
		return mv;
	}

	@RequestMapping(value = "/admin/product/new", method = RequestMethod.POST)
	@ResponseBody
	public String postAdd(@ModelAttribute("product") Product product) {
		int result = productService.addProductAndOpt(product);
		return String.format("{\"msg\":\"success\",\"result\":%d}", result);
	}
	
	@RequestMapping(value = "/admin/product/edit")
	public ModelAndView deleteProduct(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView("admin/editProduct");
		mv.addObject("product", productService.getById(req.getParameter("productId")));
		mv.addObject("activeBar", 2);
		return mv;
	}
	
	@RequestMapping(value = "/admin/product/edit", method = RequestMethod.POST)
	@ResponseBody
	public String updateProduct(@ModelAttribute("product") Product product) {
		productService.update(product);
		return String.format("{\"msg\":\"success\",\"result\":%d}", 1);
	}
}
