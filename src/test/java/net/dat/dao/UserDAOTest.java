package net.dat.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.dat.dao.impl.UserDAOImpl;
import net.dat.model.User;

class UserDAOTest {
	private DriverManagerDataSource dataSource;
	private UserDAO userDAO;
	private User normalUser;
	private User adminUser;

	@BeforeEach
	void setup() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/clothing_store");
		dataSource.setUsername("d");
		dataSource.setPassword("28220000");

		userDAO = new UserDAOImpl(dataSource);
		normalUser = new User("bgate", "1234", "Bill Gates", "0123456789", "Microsoft - USA", "user");
		adminUser = new User("sjob", "1234", "Steve Jobs", "0123456789", "Apple - USA", "admin");
	}

	@Test
	void testSave() {
		assertTrue(userDAO.save(normalUser) > 0);
		assertTrue(userDAO.save(adminUser) > 0);
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
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
