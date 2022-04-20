package net.dat.store.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.dat.store.dao.impl.ProductDAOImpl;
import net.dat.store.model.Product;

class ProductDAOTest {
	
	private ProductDAO productDAO;
	private List<Product> products;

	@BeforeEach
	void setup() {
		productDAO = new ProductDAOImpl(ConfigDB.getJdbcTemplate());
		products = new ArrayList<Product>();
		products.add(new Product("Áo Thun Cổ Tròn Ngắn Tay", new BigDecimal("391000") , "Thiết kế họa tiết Venom. Có khuôn mặt của Venom ở mặt sau.", "img"));
		products.add(new Product("Quần Short Co Giãn Dáng Slim Fit", new BigDecimal("489000") , "Tận hưởng vẻ ngoài tinh tế với kiểu cắt, thiết kế và chất liệu vải đẹp mắt.", "img"));
	}

	@Test
	void testSave() {
		for (Product p: products) {
			assertTrue(productDAO.save(p) > 0);		
			System.out.println(p.getId());
		}
		
	}

	@Test
	void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	void testGetById() {
//		Optional<Product> p = productDAO.getById(4);
//		assertNotNull(p.get());
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
