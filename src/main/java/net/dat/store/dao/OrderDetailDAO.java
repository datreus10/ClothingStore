package net.dat.store.dao;

import java.util.Optional;

import net.dat.store.model.OrderDetail;

public interface OrderDetailDAO {
	int save(OrderDetail orderDetail);

	Optional<OrderDetail> getByOrderId(String orderId);
}
