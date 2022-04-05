package net.dat.dao;

import java.util.List;
import java.util.Optional;

import net.dat.model.User;

public interface UserDAO {
	public int add(User user);

	public int update(User user);

	public int delete(Integer id);

	public Optional<User> getById(Integer id);

	public List<User> getAll();
}
