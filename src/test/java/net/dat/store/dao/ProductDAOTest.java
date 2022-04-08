package net.dat.store.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.dat.store.dao.impl.ProductDAOImpl;
import net.dat.store.dao.impl.ProductOptionDAOImpl;
import net.dat.store.model.Product;
import net.dat.store.model.ProductOption;

class ProductDAOTest {
	
	private ProductDAO productDAO;

	@BeforeEach
	void setup() {
		productDAO = new ProductDAOImpl(ConfigDB.getJdbcTemplate());
	}

	@Test
	void testSave() {
		Product p = new Product("Quần kaki", new BigDecimal("200000"), "Quần đẹp, năng động, trẻ trung", "kk1.jpg,kk2.jpg");
		List<Integer> returnId = new ArrayList<Integer>();
		assertTrue(productDAO.save(p, returnId) > 0);
		System.out.println(returnId.get(0));
	}

	@Test
	void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	void testGetById() {
		Optional<Product> p = productDAO.getById(4);
		assertNotNull(p.get());
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
