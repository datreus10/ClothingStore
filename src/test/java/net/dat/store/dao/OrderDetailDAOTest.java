package net.dat.store.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.dat.store.dao.impl.OrderDetailDAOImpl;
import net.dat.store.model.OrderDetail;

class OrderDetailDAOTest {

	private OrderDetailDAO orderDetailDAO;
	private List<OrderDetail> orderDetails;

	@BeforeEach
	void setup() {
		orderDetailDAO = new OrderDetailDAOImpl(ConfigDB.getJdbcTemplate());
		orderDetails = new ArrayList<OrderDetail>();
		orderDetails.add(new OrderDetail("5531df51-8a31-49b5-bcaa-e268e7b11fef","116a6a30-f870-4593-96a6-4d962ceb7844",2,new BigDecimal("600000")));
		orderDetails.add(new OrderDetail("5531df51-8a31-49b5-bcaa-e268e7b11fef","534dceaa-d594-4689-9a22-9d63156ccf48",1,new BigDecimal("300000")));
		orderDetails.add(new OrderDetail("ef7019f4-6922-4e36-998a-7741c879e311","feb82c2a-7a5a-440f-8b19-90af90e9ef72",2,new BigDecimal("800000")));
		
	}

	@Test
	void testSave() {
		for (OrderDetail detail: orderDetails) {
			assertTrue(orderDetailDAO.save(detail) > 0);
		}
	}
}
