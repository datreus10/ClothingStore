package net.dat.store.dao;

import java.util.List;

import net.dat.store.model.OrderDetail;

public interface OrderDetailDAO {
	int save(OrderDetail orderDetail);

	List<OrderDetail> getByOrderId(String orderId);
	
//	List<OrderDetail> getFullByOrderId(String orderId);
}
