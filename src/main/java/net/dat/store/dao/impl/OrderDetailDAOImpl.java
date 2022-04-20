package net.dat.store.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import net.dat.store.dao.OrderDetailDAO;
import net.dat.store.dao.impl.OrderDAOImpl.OrderRowMapper;
import net.dat.store.model.Order;
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
	public List<OrderDetail> getByOrderId(String orderId) {
		StringBuilder sql = new StringBuilder("SELECT * FROM clothing_store.order_detail where order_id='").append(orderId).append("'");
		return jdbcTemplate.query(sql.toString(), new OrderDetailRowMapper());
	}

	class OrderDetailRowMapper implements RowMapper<OrderDetail> {

		@Override
		public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new OrderDetail(rs.getString("id"),rs.getString("order_id"), rs.getString("product_option_id"), rs.getInt("quantity"), rs.getBigDecimal("total_price"));
		}

	}

//	@Override
//	public List<OrderDetail> getFullByOrderId(String orderId) {
//		StringBuilder sql = new StringBuilder("SELECT * ")
//							.append("FROM clothing_store.order_detail a,clothing_store.product_option b, clothing_store.product c")
//							.append("where a.product_option_id=b.id AND b.product_id=c.id AND a.order_id='")
//							.append(orderId).append("'");
//		return jdbcTemplate.query(sql.toString(), new RowMapper<OrderDetail>() {
//
//			@Override
//			public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//		});
//	}

}
