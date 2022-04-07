package net.dat.dao;

import net.dat.model.OrderDetail;

public interface OrderDetailDAO {
	int save(OrderDetail orderDetail);

	OrderDetail getByOrderId(Integer orderId);
}
