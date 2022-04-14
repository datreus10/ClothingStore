package net.dat.store.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.dat.store.model.Product;
import net.dat.store.model.ProductOption;
import net.dat.store.model.User;
import net.dat.store.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/admin/product")
	public ModelAndView getProduct(){
		
		ModelAndView mv = new ModelAndView("admin/product");
		mv.addObject("products", productService.getProducts());
		mv.addObject("activeBar", 2);
		return mv;
	}
	
	@RequestMapping(value = "/admin/product/new",method = RequestMethod.GET)
	public ModelAndView getAdd(){
		
		ModelAndView mv = new ModelAndView("admin/addProduct");
		Product p = new Product();
		List<ProductOption> options = new ArrayList<ProductOption>();
		options.add(new ProductOption(23, "XL", "white", 123));
		p.setOptions(options);
		mv.addObject("product",p);
		mv.addObject("activeBar", 2);
		return mv;
	}
	
	@RequestMapping(value = "/admin/product/new",method = RequestMethod.POST)
	@ResponseBody
	public String postAdd(@RequestParam Map<String, Object> body ){	 
//		List<Integer> lstId = new ArrayList<Integer>();
//		productService.addProduct(product,lstId);
		return String.format("{\"msg\":\"success\",\"product_id\":%d}",1);
	}
}
