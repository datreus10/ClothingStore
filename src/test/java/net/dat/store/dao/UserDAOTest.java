package net.dat.store.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.dat.store.dao.impl.UserDAOImpl;
import net.dat.store.model.User;

class UserDAOTest {

	private UserDAO userDAO;
	private User normalUser;
	private User adminUser;

	@BeforeEach
	void setup() {
		userDAO = new UserDAOImpl(ConfigDB.getJdbcTemplate());
		normalUser = new User("bgate3", "1234","bgate@gmail.com", "Bill Gates", "0123456789", "Microsoft - USA", "user");
		adminUser = new User("sjob", "1234","sjob@gmail.com", "Steve Jobs", "0123456789", "Apple - USA", "admin");
	}

	@Test
	void testSave() {
		assertTrue(userDAO.save(normalUser) > 0);
		//assertTrue(userDAO.save(adminUser) > 0);
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		System.out.println(userDAO.delete(2));
	}

	@Test
	void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAll() {
		List<User> users = userDAO.getAll();
		assertTrue(!users.isEmpty());
		for (User user : users) {
			System.out.println(user);
		}
	}

}
