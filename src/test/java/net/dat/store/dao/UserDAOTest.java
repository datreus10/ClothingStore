package net.dat.store.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.dat.store.dao.impl.UserDAOImpl;
import net.dat.store.model.User;

class UserDAOTest {

	private UserDAO userDAO;
	private List<User> users;

	@BeforeEach
	void setup() {
		userDAO = new UserDAOImpl(ConfigDB.getJdbcTemplate());
		
		// Users
		users = new ArrayList<User>();
		// id: b2e2e7a4-d821-449a-b3e7-027acc67d9fa
		users.add(new User("dat1", "1234", "dat1@gmail.com", "Nguyễn Thành Đạt", "0123456789", "ktx khu A, Thủ Đức, Tp.HCM", "admin"));
		// id: c18e03ab-8a2d-470d-936b-fb4825c48205
		users.add(new User("dat2", "1234", "dat2@gmail.com", "dat nguyen thanh", "0123456789", "ktx khu B, Thủ Đức, Tp.HCM", "user"));
	}

	@Test
	void testSave() {
		for (User user : users) {
			assertTrue(userDAO.save(user) > 0);		
			System.out.println(user.getId());
		}
		
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		//System.out.println(userDAO.delete(2));
	}

	@Test
	void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAll() {
		List<User> users = userDAO.get(100);
		assertTrue(!users.isEmpty());
		for (User user : users) {
			System.out.println(user);
		}
	}

}
