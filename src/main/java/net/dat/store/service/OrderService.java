package net.dat.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.dat.store.dao.OrderDAO;
import net.dat.store.exception.NotFoundException;
import net.dat.store.model.Order;

@Service
public class OrderService {
	private final OrderDAO orderDAO;

	public OrderService(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	public List<Order> get(int limit){
		return orderDAO.get(limit);
	}
	
	public Order getById(String id){
		return orderDAO.getById(id).orElseThrow(()->new NotFoundException(String.format("Order with id %s not found", id)));
	}
}
