package net.dat.store.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.dat.store.dao.impl.OrderDAOImpl;
import net.dat.store.model.Order;

class OrderDAOTest {

	private OrderDAO orderDAO;
	private List<Order> orders;

	@BeforeEach
	void setup() {
		orderDAO = new OrderDAOImpl(ConfigDB.getJdbcTemplate());
		
		orders = new ArrayList<Order>();
		orders.add(new Order("b2e2e7a4-d821-449a-b3e7-027acc67d9fa", LocalDateTime.now(), new BigDecimal("200000"),2 ,"ktx khu A, Thủ Đức, Tp.HCM","0123456789" , "Thanh toán khi nhận hàng", "Đang xử lý"));
		orders.add(new Order("b2e2e7a4-d821-449a-b3e7-027acc67d9fa", LocalDateTime.now(), new BigDecimal("400000"),3 ,"ktx khu A, Thủ Đức, Tp.HCM","0123456789" , "Thanh toán khi nhận hàng", "Đang xử lý"));
	}

	@Test
	void testSave() {
		for (Order order: orders) {
			assertTrue(orderDAO.save(order) > 0);		
			System.out.println(order.getId());
		}
	}

	@Test
	void testGetByUserId() {
		fail("Not yet implemented");
	}

	@Test
	void testGetById() {
		fail("Not yet implemented");
	}

}
