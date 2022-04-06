package net.dat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.dat.dao.UserDAO;
import net.dat.exception.NotFoundException;
import net.dat.model.User;

@Service
public class UserService {
	private final UserDAO userDAO;

	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void addNewUser(User user) {
		int result = userDAO.save(user);
		if (result != 1)
			throw new IllegalStateException("Oop!! Some thing went wrong");
	}

	public User getUser(Integer id) {
		return userDAO.getById(id)
				.orElseThrow(() -> new NotFoundException(String.format("User with id % not found", id)));
	}

	public List<User> getUsers() {
		return userDAO.getAll();
	}
	
	public User validateUser(User loginUser) {
		return userDAO.validateUser(loginUser);
	}
}
