package net.dat.store.dao;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import net.dat.store.dao.impl.OrderDAOImpl;
import net.dat.store.dao.impl.OrderDetailDAOImpl;
import net.dat.store.dao.impl.ProductDAOImpl;
import net.dat.store.dao.impl.ProductOptionDAOImpl;
import net.dat.store.dao.impl.UserDAOImpl;
import net.dat.store.model.Order;
import net.dat.store.model.OrderDetail;
import net.dat.store.model.Product;
import net.dat.store.model.ProductOption;
import net.dat.store.model.User;

class MyTest {

	// DAO
	private UserDAO userDAO;
	private ProductDAO productDAO;
	private ProductOptionDAO optionDAO;
	private OrderDAO orderDAO;
	private OrderDetailDAO orderDetailDAO;

	// Data
	private List<User> users;
	private List<Product> products;
	private List<ProductOption> options;
	private List<Order> orders;
	private List<OrderDetail> orderDetails;
	
	@BeforeEach
	void setup() {
		userDAO = new UserDAOImpl(ConfigDB.getJdbcTemplate());
		productDAO = new ProductDAOImpl(ConfigDB.getJdbcTemplate());
		optionDAO = new ProductOptionDAOImpl(ConfigDB.getJdbcTemplate());
		orderDAO = new OrderDAOImpl(ConfigDB.getJdbcTemplate());
		orderDetailDAO = new OrderDetailDAOImpl(ConfigDB.getJdbcTemplate());
		
//		// Users
//		users = new ArrayList<User>();
//		users.add(new User(100, "dat1", "1234", "dat1@gmail.com", "dat nguyen thanh", "0123456789", "ktx khu A, Thủ Đức, Tp.HCM", "admin"));
//		users.add(new User(101, "dat2", "1234", "dat2@gmail.com", "dat nguyen thanh", "0123456789", "ktx khu B, Thủ Đức, Tp.HCM", "user"));
//		
//		// Products
//		products = new ArrayList<Product>();
//		products.add(new Product(100, "Áo Thun Cổ Tròn Ngắn Tay", new BigDecimal("391000") , "Thiết kế họa tiết Venom. Có khuôn mặt của Venom ở mặt sau.", "img"));
//		products.add(new Product(101, "Quần Short Co Giãn Dáng Slim Fit", new BigDecimal("489000") , "Tận hưởng vẻ ngoài tinh tế với kiểu cắt, thiết kế và chất liệu vải đẹp mắt.", "img"));
//		
//		// Product options
//		options = new ArrayList<ProductOption>();
//		options.add(new ProductOption(50, 100, "M", "Black", 5));
//		options.add(new ProductOption(51, 100, "L", "White", 4));
//		options.add(new ProductOption(52, 101, "L", "Black", 6));
//		options.add(new ProductOption(53, 101, "XL", "Black", 10));
	}
	
	

}
