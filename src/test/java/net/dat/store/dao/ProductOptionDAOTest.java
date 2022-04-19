package net.dat.store.dao;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.dat.store.dao.impl.ProductDAOImpl;
import net.dat.store.dao.impl.ProductOptionDAOImpl;
import net.dat.store.model.ProductOption;

class ProductOptionDAOTest {

	private ProductOptionDAO productOptionDAO;

	@BeforeEach
	void setup() {
		productOptionDAO = new ProductOptionDAOImpl(ConfigDB.getJdbcTemplate());
	}

	@Test
	void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	void testAddList() {
		List<ProductOption> options = new ArrayList<ProductOption>();
//		options.add(new ProductOption(5, "XL", "white", 5));
//		options.add(new ProductOption(5, "L", "red", 5));

		// check all insert success
		assertTrue(Arrays.stream(productOptionDAO.saveList(options)).allMatch(e -> e > 0));
	}

}
