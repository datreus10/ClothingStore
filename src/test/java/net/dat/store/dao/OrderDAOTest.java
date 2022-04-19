package net.dat.store.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.dat.store.dao.impl.OrderDAOImpl;
import net.dat.store.dao.impl.ProductDAOImpl;
import net.dat.store.dao.impl.ProductOptionDAOImpl;
import net.dat.store.model.Order;

class OrderDAOTest {

	private OrderDAO orderDAO;

	@BeforeEach
	void setup() {
		orderDAO = new OrderDAOImpl(ConfigDB.getJdbcTemplate());
	}

	@Test
	void testSave() {
		//Order order = new Order(1,LocalDateTime.now(),new BigDecimal("100000"),1,"Thanh toán khi nhận hàng","Đang xử lý");
//		Order order = new Order();
//		order.setUser_id(11);
//		order.setOrderDate(LocalDateTime.now());
//		order.setPayment("Thanh toán khi nhận hàng");
//		order.setAddress("ktx khu B, đhqg, TP.HCM");
//		order.setPhone("0123456789");
//		order.setStatus("Đang xử lý");
//		order.setTotalPrice(new BigDecimal("2000000"));
//		order.setTotalQuantity(2);
//		
//		assertTrue(orderDAO.save(order)>0);
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
