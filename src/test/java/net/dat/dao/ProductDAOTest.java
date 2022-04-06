package net.dat.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.dat.dao.impl.ProductDAOImpl;
import net.dat.dao.impl.ProductOptionDAOImpl;
import net.dat.dao.impl.UserDAOImpl;
import net.dat.model.Product;
import net.dat.model.ProductOption;
import net.dat.model.User;

class ProductDAOTest {
	private DriverManagerDataSource dataSource;
	ProductDAO productDAO;
	@BeforeEach
	void setup(){
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/clothing_store?useSSL=false");
		dataSource.setUsername("d");
		dataSource.setPassword("28220000");
		
		productDAO = new ProductDAOImpl(new JdbcTemplate(dataSource), new ProductOptionDAOImpl(new JdbcTemplate(dataSource)));
	}
	
	@Test
	void testAdd() {
		Product p = new Product("Áo thun", new BigDecimal("100000"), "Áo siêu đẹp, thoáng mát", "at1.jpg,at2.jpg");
		p.addOption(new ProductOption("XL", "white", 10));
		p.addOption(new ProductOption("L", "red", 5));
		productDAO.save(p);
	}

	@Test
	void testGetById() {
		Optional<Product> p = productDAO.getById(4);
		assertNotNull(p.get());
	}
}
