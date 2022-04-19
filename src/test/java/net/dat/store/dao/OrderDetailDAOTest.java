package net.dat.store.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.dat.store.dao.impl.OrderDetailDAOImpl;
import net.dat.store.model.OrderDetail;

class OrderDetailDAOTest {

	private OrderDetailDAO orderDetailDAO;

	@BeforeEach
	void setup() {
		orderDetailDAO = new OrderDetailDAOImpl(ConfigDB.getJdbcTemplate());
	}

	@Test
	void testSave() {
//		OrderDetail orderDetail = new OrderDetail();
//		orderDetail.setOrderId(3);
//		orderDetail.setProductOptionId(5);
//		orderDetail.setQuantity(null);
	}
}
