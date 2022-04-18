package net.dat.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.dat.store.dao.OrderDAO;
import net.dat.store.model.Order;

@Service
public class OrderService {
	private final OrderDAO orderDAO;

	public OrderService(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	public List<Order> getAll(){
		return orderDAO.getAll();
	}
}
