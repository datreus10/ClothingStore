package net.dat.store.service;

import org.springframework.stereotype.Service;

import net.dat.store.dao.OrderDetailDAO;
import net.dat.store.exception.NotFoundException;
import net.dat.store.model.OrderDetail;

@Service
public class OrderDetailService {
	private final OrderDetailDAO orderDetailDAO;

	public OrderDetailService(OrderDetailDAO orderDetailDAO) {
		this.orderDetailDAO = orderDetailDAO;
	}
	
	public OrderDetail getByOrderId(String id) {
		return orderDetailDAO.getByOrderId(id).orElseThrow(()->new NotFoundException(String.format("Order with id %s not found", id)));
	}
	
}
