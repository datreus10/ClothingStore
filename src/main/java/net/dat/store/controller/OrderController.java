package net.dat.store.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.dat.store.model.Order;
import net.dat.store.model.OrderDetail;
import net.dat.store.model.User;
import net.dat.store.service.OrderDetailService;
import net.dat.store.service.OrderService;
import net.dat.store.service.UserService;


@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderDetailService detailService;
	
	@RequestMapping(value = "/admin/order")
	public ModelAndView getOrder() {
		ModelAndView mv = new ModelAndView("admin/order");
		List<Order> orders = orderService.get(100);
		mv.addObject("orders", orders);
		mv.addObject("activeBar", 3);
		return mv;
	}
	
	@RequestMapping(value = "/admin/order/detail")
	public ModelAndView geOrderDetail(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView("admin/editOrder");
		Order order = orderService.getById(req.getParameter("orderId"));
		List<OrderDetail> orderDetails = detailService.getByOrderId(order.getId());
		User user = userService.getById(order.getUserId());
		mv.addObject("order", order);
		mv.addObject("orderDetails", orderDetails);
		mv.addObject("user", user);
		mv.addObject("listStatus", Arrays.asList("Đang xử lý","Đang giao hàng","Đã thanh toán","Đã hủy"));
		mv.addObject("activeBar", 3);
		return mv;
	}
}
