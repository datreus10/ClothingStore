package net.dat.store.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.dat.store.dao.impl.OrderDAOImpl;
import net.dat.store.dao.impl.ProductDAOImpl;
import net.dat.store.dao.impl.ProductOptionDAOImpl;

class OrderDAOTest {

	private OrderDAO orderDAO;

	@BeforeEach
	void setup() {
		orderDAO = new OrderDAOImpl(ConfigDB.getJdbcTemplate());
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
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
