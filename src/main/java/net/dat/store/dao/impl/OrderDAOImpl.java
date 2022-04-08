package net.dat.store.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import net.dat.store.dao.OrderDAO;
import net.dat.store.model.Order;

public class OrderDAOImpl implements OrderDAO {

	private final JdbcTemplate jdbcTemplate;

	public OrderDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int save(Order order) {
		String sql = "INSERT INTO order(user_id,order_date,total_price,total_quantity,payment,status) values(?,?,?,?,?,?)";

		return jdbcTemplate.update(sql, order.getUserId(), Timestamp.valueOf(order.getOrderDate()),
				order.getTotalPrice(), order.getTotalQuantity(), order.getPayment(), order.getStatus());
	}

	@Override
	public Optional<Order> getById(Integer id) {
		String sql = "SELECT * FROM order where id=" + id;
		return jdbcTemplate.query(sql, new OrderRowMapper()).stream().findFirst();
	}

	@Override
	public List<Order> getByUserId(Integer userId) {
		String sql = "SELECT * FROM order where user_id=" + userId;
		return jdbcTemplate.query(sql, new OrderRowMapper());
	}

	class OrderRowMapper implements RowMapper<Order> {

		@Override
		public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Order(rs.getInt("user_id"), rs.getTimestamp("order_date").toLocalDateTime(),
					rs.getBigDecimal("total_price"), rs.getInt("total_quantity"), rs.getString("payment"),
					rs.getString("status"));
		}

	}
}
