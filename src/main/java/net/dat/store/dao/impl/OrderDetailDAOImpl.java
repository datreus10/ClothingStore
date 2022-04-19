package net.dat.store.dao.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.dat.store.dao.OrderDetailDAO;
import net.dat.store.model.OrderDetail;

@Repository
public class OrderDetailDAOImpl implements OrderDetailDAO {

	private final JdbcTemplate jdbcTemplate;

	public OrderDetailDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int save(OrderDetail orderDetail) {
		String sql = "INSERT INTO order_detail(id,order_id,product_option_id,quantity,total_price) values(?,?,?,?,?)";
		orderDetail.setId(UUID.randomUUID().toString());
		return jdbcTemplate.update(sql, 
				orderDetail.getId(),
				orderDetail.getOrderId(), 
				orderDetail.getproductOptionId(),
				orderDetail.getQuantity(), 
				orderDetail.getTotalPrice());
	}

	@Override
	public Optional<OrderDetail> getByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
