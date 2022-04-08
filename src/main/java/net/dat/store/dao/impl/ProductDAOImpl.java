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
		String sql = "INSERT INTO product(name,price,description,images) VALUES (?,?,?,?)";
		return jdbcTemplate.update(sql, new ProductRowMapper());
	}

	@Override
	public List<Product> getAll() {
		String sql = "SELECT * FROM product LIMIT 100";
		return jdbcTemplate.query(sql, new ProductRowMapper());
	}

	@Override
	public Optional<Product> getById(Integer id) {
		String sql = "SELECT * FROM product WHERE id=" + id;
		return jdbcTemplate.query(sql, new ProductRowMapper()).stream().findFirst();
	}

	class ProductRowMapper implements RowMapper<Product> {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Product(rs.getInt("id"), 
					rs.getNString("name"), 
					rs.getBigDecimal("price"),
					rs.getNString("description"), 
					rs.getString("images"));

		}

	}

	@Override
	public int update(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Product newProduct, List<Integer> returnId) {
		String sql = "INSERT INTO product(name,price,description,images) VALUES (?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder(); // return id when insert
		int result = jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setNString(1, newProduct.getName());
				ps.setBigDecimal(2, newProduct.getPrice());
				ps.setNString(3, newProduct.getDescription());
				ps.setString(4, newProduct.getImages());
				return ps;
			}
		}, keyHolder);
		if (result > 0) {
			Integer productId = keyHolder.getKey().intValue();
			returnId.add(productId);
		}
		return result;
	}

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