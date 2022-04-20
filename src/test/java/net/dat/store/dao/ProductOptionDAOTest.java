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
	private List<ProductOption> options;

	@BeforeEach
	void setup() {
		productOptionDAO = new ProductOptionDAOImpl(ConfigDB.getJdbcTemplate());
		options = new ArrayList<ProductOption>();
		options.add(new ProductOption("8c797223-5006-4b01-b8bf-de9f76c93b45", "M", "Black", 10));
		options.add(new ProductOption("8c797223-5006-4b01-b8bf-de9f76c93b45", "L", "Black", 4));
		options.add(new ProductOption("bd61ac3e-4701-4164-b87c-68495923f30c", "L", "White", 15));
		options.add(new ProductOption("bd61ac3e-4701-4164-b87c-68495923f30c", "XL", "Blue", 4));
	}

	@Test
	void testAdd() {
		for (ProductOption option : options) {
			assertTrue(productOptionDAO.save(option)>0);
		}
	}

	@Test
	void testAddList() {
		List<ProductOption> options = new ArrayList<ProductOption>();
//		options.add(new ProductOption(5, "XL", "white", 5));
//		options.add(new ProductOption(5, "L", "red", 5));

		// check all insert success
//		assertTrue(Arrays.stream(productOptionDAO.saveList(options)).allMatch(e -> e > 0));
	}

}
