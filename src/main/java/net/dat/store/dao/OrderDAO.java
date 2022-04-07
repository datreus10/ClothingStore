package net.dat.store.dao;

import net.dat.store.model.Order;

public interface OrderDAO {
	int save(Order order);

	Order getByUserId(Integer id);
}
