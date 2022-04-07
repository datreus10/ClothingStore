package net.dat.dao;

import net.dat.model.Order;

public interface OrderDAO {
	int save(Order order);

	Order getByUserId(Integer id);
}
