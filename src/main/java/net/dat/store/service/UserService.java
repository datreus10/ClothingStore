package net.dat.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.dat.store.dao.UserDAO;
import net.dat.store.dto.AuthUserDTO;
import net.dat.store.exception.NotFoundException;
import net.dat.store.exception.UnauthorizedException;
import net.dat.store.model.User;

@Service
public class UserService {
	private final UserDAO userDAO;

	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void addNewUser(User user) {
		// check exists user
		
		int result = userDAO.save(user);
		if (result != 1)
			throw new IllegalStateException("Oop!! Some thing went wrong");
	}

	public void updateUser(User u) {
		int result = userDAO.update(u);
		if (result != 1)
			throw new IllegalStateException("Oop!! Some thing went wrong");
	}
	
	public User getById(String id) {
		return userDAO.getById(id)
				.orElseThrow(() -> new NotFoundException(String.format("User with id % not found", id)));
	}

	public List<User> getUsers() {
		return userDAO.get(100);
	}

	public AuthUserDTO validateUser(User loginUser) {
		User user = userDAO.validateUser(loginUser)
				.orElseThrow(() -> new UnauthorizedException("Incorrect username/password"));
		return new AuthUserDTO(user.getId(), user.getUsername(), user.getFullname(), user.getRole());
	}

	public int deleteUserById(String userId) {
		int rowAffect = userDAO.delete(userId);
		if (rowAffect < 1)
			throw new IllegalStateException("Can not delete user with id=" + userId);
		return rowAffect;
	}
}
