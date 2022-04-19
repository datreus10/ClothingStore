package net.dat.store.dao;

import java.util.List;
import java.util.Optional;

import net.dat.store.model.User;

public interface UserDAO {
	public int save(User user);

	public int update(User user);

	public int delete(String id);

	public Optional<User> getById(String id);

	public List<User> get(int limit);
	
	Optional<User> validateUser(User loginUser);
}
