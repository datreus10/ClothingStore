package net.dat.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import net.dat.store.dao.OrderDAO;
import net.dat.store.model.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {

	private final JdbcTemplate jdbcTemplate;

	public OrderDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int save(Order order) {
		String sql = "INSERT INTO clothing_store.order(id,user_id, order_date, total_price, total_quantity, payment, status,address,phone) VALUES(?,?,?,?,?,?,?,?,?)";
		order.setId(UUID.randomUUID().toString());
		return jdbcTemplate.update(sql, 
				order.getId(),
				order.getUserId(),
				Timestamp.valueOf(order.getOrderDate()),
				order.getTotalPrice(),
				order.getTotalQuantity(),
				order.getPayment(),
				order.getStatus(),
				order.getAddress(),
				order.getPhone());

	}

	@Override
	public Optional<Order> getById(String id) {
		StringBuilder sql = new StringBuilder("SELECT * FROM clothing_store.order where id='").append(id).append("'");
		return jdbcTemplate.query(sql.toString(), new OrderRowMapper()).stream().findFirst();
	}

	@Override
	public List<Order> getByUserId(String userId) {
		String sql = "SELECT * FROM clothing_store.order where user_id=" + userId;
		return jdbcTemplate.query(sql, new OrderRowMapper());
	}

	class OrderRowMapper implements RowMapper<Order> {

		@Override
		public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Order(rs.getString("id"), rs.getString("user_id"), rs.getTimestamp("order_date").toLocalDateTime(),
					rs.getBigDecimal("total_price"), rs.getInt("total_quantity"), rs.getNString("address"),
					rs.getNString("phone"), rs.getNString("payment"), rs.getNString("status"));
		}

	}

//	@Override
//	public int save(Order order, List<Integer> returnId) {
//		String sql = "INSERT INTO clothing_store.order(user_id,order_date,total_price,total_quantity,payment,status) values(?,?,?,?,?,?)";
//		KeyHolder keyHolder = new GeneratedKeyHolder(); // return id when insert
//		int result = jdbcTemplate.update(new PreparedStatementCreator() {
//
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//				ps.setInt(1, order.getUserId());
//				ps.setTimestamp(2, Timestamp.valueOf(order.getOrderDate()));
//				ps.setBigDecimal(3, order.getTotalPrice());
//				ps.setInt(4, order.getTotalQuantity());
//				ps.setNString(5, order.getPayment());
//				ps.setNString(5, order.getStatus());
//				return ps;
//			}
//		}, keyHolder);
//		if (result > 0) {
//			Integer orderId = keyHolder.getKey().intValue();
//			returnId.add(orderId);
//		}
//		return result;
//	}

	@Override
	public List<Order> get(int limit) {
		String sql = "SELECT * FROM clothing_store.order LIMIT "+limit;
		return jdbcTemplate.query(sql, new OrderRowMapper());
	}
}
