package net.dat.store.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import net.dat.store.dao.ProductOptionDAO;
import net.dat.store.model.ProductOption;

@Repository
public class ProductOptionDAOImpl implements ProductOptionDAO {

	private final JdbcTemplate jdbcTemplate;

	public ProductOptionDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int save(ProductOption pOption) {
		String sql = "INSERT INTO product_option(id,product_id,size,color,quantity) VALUES(?,?,?,?,?)";
		pOption.setId(UUID.randomUUID().toString());
		return jdbcTemplate.update(sql, 
				pOption.getId(),
				pOption.getProductId(), 
				pOption.getSize(), 
				pOption.getColor(),
				pOption.getQuantity());
	}

	@Override
	public int[] saveList(List<ProductOption> options) {
		String sql = "INSERT INTO product_option(id,product_id,size,color,quantity) VALUES(?,?,?,?,?)";
		return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ProductOption opt = options.get(i);
				ps.setString(1, UUID.randomUUID().toString());
				ps.setString(2, opt.getProductId());
				ps.setString(3, opt.getSize());
				ps.setString(4, opt.getColor());
				ps.setInt(5, opt.getQuantity());
			}

			@Override
			public int getBatchSize() {
				return options.size();
			}
		});
	}

	@Override
	public List<ProductOption> getOptions(String productId) {
		StringBuilder sql = new StringBuilder("SELECT * FROM product_option WHERE product_id='").append(productId).append("'");
		return jdbcTemplate.query(sql.toString(), new ProductOptionRowMapper());
	}

	class ProductOptionRowMapper implements RowMapper<ProductOption>{

		@Override
		public ProductOption mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new ProductOption(rs.getString("id"), rs.getString("product_id"), rs.getString("size"), rs.getString("color"), rs.getInt("quantity"));
		}
		
	}
	
	@Override
	public int deleteById(String id) {
		StringBuilder sql = new StringBuilder("DELETE FROM product_option WHERE id='").append(id).append("'");
		return jdbcTemplate.update(sql.toString());
	}

	@Override
	public int update(ProductOption opt) {
		String sql = "UPDATE product_option SET size=?,color=?,quantity=? where id=?";
		return jdbcTemplate.update(sql,opt.getSize(),opt.getColor(), opt.getQuantity(),opt.getId());
	}

	@Override
	public Optional<ProductOption> getById(String id) {
		StringBuilder sql = new StringBuilder("SELECT * FROM product_option WHERE id='").append(id).append("'");
		return jdbcTemplate.query(sql.toString(), new ProductOptionRowMapper()).stream().findFirst();
	}

}
