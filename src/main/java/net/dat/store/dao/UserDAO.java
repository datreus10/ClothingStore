package net.dat.store.dao;

import java.util.List;
import java.util.Optional;

import net.dat.store.model.User;

public interface UserDAO {
	public int save(User user);

	public int update(User user);

	public int delete(Integer id);

	public Optional<User> getById(Integer id);

	public List<User> getAll();
	
	Optional<User> validateUser(User loginUser);
}