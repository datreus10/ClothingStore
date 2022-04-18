package net.dat.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
		String sql = "INSERT INTO clothing_store.order(user_id, order_date, total_price, total_quantity, payment, status) VALUES(?,?,?,?,?,?)";

		return jdbcTemplate.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, order.getUserId());
				ps.setTimestamp(2, Timestamp.valueOf(order.getOrderDate()));
				ps.setBigDecimal(3, order.getTotalPrice());
				ps.setInt(4, order.getTotalQuantity());
				ps.setNString(5, order.getPayment());
				ps.setNString(6, order.getStatus());
				
			}
			
		});
		
		
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
			return new Order(rs.getInt("id"),rs.getInt("user_id"), rs.getTimestamp("order_date").toLocalDateTime(),
					rs.getBigDecimal("total_price"), rs.getInt("total_quantity"), rs.getNString("payment"),
					rs.getNString("status"));
		}

	}

	@Override
	public int save(Order order, List<Integer> returnId) {
		String sql = "INSERT INTO order(user_id,order_date,total_price,total_quantity,payment,status) values(?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder(); // return id when insert
		int result = jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, order.getUserId());
				ps.setTimestamp(2, Timestamp.valueOf(order.getOrderDate()));
				ps.setBigDecimal(3, order.getTotalPrice());
				ps.setInt(4, order.getTotalQuantity());
				ps.setNString(5, order.getPayment());
				ps.setNString(5, order.getStatus());
				return ps;
			}
		}, keyHolder);
		if (result > 0) {
			Integer orderId = keyHolder.getKey().intValue();
			returnId.add(orderId);
		}
		return result;
	}

	@Override
	public List<Order> getAll() {
		String sql = "SELECT * FROM clothing_store.order LIMIT 100";
		return jdbcTemplate.query(sql, new OrderRowMapper());
	}
}
