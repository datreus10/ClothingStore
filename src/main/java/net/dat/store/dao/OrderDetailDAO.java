package net.dat.store.dao;

import net.dat.store.model.OrderDetail;

public interface OrderDetailDAO {
	int save(OrderDetail orderDetail);

	OrderDetail getByOrderId(Integer orderId);
}
