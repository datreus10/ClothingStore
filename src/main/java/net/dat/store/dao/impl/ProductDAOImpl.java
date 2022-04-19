package net.dat.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import net.dat.store.dao.ProductDAO;
import net.dat.store.dao.ProductOptionDAO;
import net.dat.store.model.Product;
import net.dat.store.model.ProductOption;

@Repository
public class ProductDAOImpl implements ProductDAO {

	private final JdbcTemplate jdbcTemplate;
	

	public ProductDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int save(Product newProduct) {
		String sql = "INSERT INTO product(id,name,price,description,images) VALUES (?,?,?,?,?)";
		newProduct.setId(UUID.randomUUID().toString());
		return jdbcTemplate.update(sql, 
				newProduct.getId(),
				newProduct.getName(),
				newProduct.getPrice(),
				newProduct.getDescription(),
				newProduct.getImages());
	}

	@Override
	public List<Product> get(int limit) {
		String sql = "SELECT * FROM product LIMIT "+limit;
		return jdbcTemplate.query(sql, new ProductRowMapper());
	}

	@Override
	public Optional<Product> getById(String id) {
		StringBuilder sql = new StringBuilder("SELECT * FROM product WHERE id='").append(id).append("'");
		return jdbcTemplate.query(sql.toString(), new ProductRowMapper()).stream().findFirst();
	}

	class ProductRowMapper implements RowMapper<Product> {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Product(rs.getString("id"), 
					rs.getNString("name"), 
					rs.getBigDecimal("price"),
					rs.getNString("description"), 
					rs.getString("images"));
		}

	}

	@Override
	public int update(Product product) {
		String sql = "UPDATE product SET name=?,price=?,description=?,images=? where id=?";
		return jdbcTemplate.update(sql, 
				product.getName(),
				product.getPrice(),
				product.getDescription(),
				product.getImages(),
				product.getId());
	}

	@Override
	public int delete(String id) {
		String sql = "DELETE FROM product WHERE id=" + id;
		return jdbcTemplate.update(sql);
	}

//	@Override
//	public int save(Product newProduct, List<Integer> returnId) {
//		String sql = "INSERT INTO product(name,price,description,images) VALUES (?,?,?,?)";
//		KeyHolder keyHolder = new GeneratedKeyHolder(); // return id when insert
//		int result = jdbcTemplate.update(new PreparedStatementCreator() {
//
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//				ps.setNString(1, newProduct.getName());
//				ps.setBigDecimal(2, newProduct.getPrice());
//				ps.setNString(3, newProduct.getDescription());
//				ps.setString(4, newProduct.getImages());
//				return ps;
//			}
//		}, keyHolder);
//		if (result > 0) {
//			Integer productId = keyHolder.getKey().intValue();
//			returnId.add(productId);
//		}
//		return result;
//	}

//	@Override
//	public int[] save(List<Product> products, List<Integer> returnId) {
//		String sql = "INSERT INTO product(name,price,description,images) VALUES (?,?,?,?)";
//		return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
//			
//			@Override
//			public void setValues(PreparedStatement ps, int i) throws SQLException {
//				Product product = products.get(i);
//				ps.setString(1, product.getName());
//				ps.setBigDecimal(2,	product.getPrice());
//				ps.setString(3, product.getDescription());
//				ps.setString(4, product.getImages());
//				
//			}
//			
//			@Override
//			public int getBatchSize() {
//				return products.size();
//			}
//		});
		
//	}
}