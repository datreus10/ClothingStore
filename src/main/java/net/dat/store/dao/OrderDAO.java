package net.dat.store.dao;

import java.util.List;
import java.util.Optional;

import net.dat.store.model.Order;

public interface OrderDAO {
	int save(Order order);

	List<Order> getByUserId(Integer userId);

	Optional<Order> getById(Integer id);
}
