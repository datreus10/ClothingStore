package net.dat.store.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
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
	private DriverManagerDataSource dataSource;
	private ProductDAO productDAO;

	@BeforeEach
	void setup() {
		dataSource = ConfigDB.config();

		JdbcTemplate tmp = ConfigDB.getJdbcTemplate();
		productDAO = new ProductDAOImpl(tmp, new ProductOptionDAOImpl(tmp));
	}

	@Test
	void testSave() {
		Product p = new Product("Áo thun", new BigDecimal("100000"), "Áo siêu đẹp, thoáng mát", "at1.jpg,at2.jpg");
		p.addOption(new ProductOption("XL", "white", 10));
		p.addOption(new ProductOption("L", "red", 5));
		productDAO.save(p);
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
