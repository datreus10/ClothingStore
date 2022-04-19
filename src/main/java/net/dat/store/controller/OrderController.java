package net.dat.store.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.dat.store.model.Order;
import net.dat.store.service.OrderService;


@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/admin/order")
	public ModelAndView getOrder() {
		ModelAndView mv = new ModelAndView("admin/order");
		List<Order> orders = orderService.getAll();
		mv.addObject("orders", orders);
		mv.addObject("activeBar", 3);
		return mv;
	}
	
	@RequestMapping(value = "/admin/order/detail")
	public ModelAndView geOrderDetail(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView("admin/editOrder");
		
		mv.addObject("activeBar", 3);
		return mv;
	}
}
