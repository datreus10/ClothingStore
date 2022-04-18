package net.dat.store.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
		String sql = "INSERT INTO product_option(product_id,size,color,quantity) VALUES(?,?,?,?)";
		return jdbcTemplate.update(sql, pOption.getProductId(), pOption.getSize(), pOption.getColor(),
				pOption.getQuantity());
	}

	@Override
	public int[] saveList(List<ProductOption> options) {
		String sql = "INSERT INTO product_option(product_id,size,color,quantity) VALUES(?,?,?,?)";
		return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ProductOption opt = options.get(i);
				ps.setInt(1, opt.getProductId());
				ps.setString(2, opt.getSize());
				ps.setString(3, opt.getColor());
				ps.setInt(4, opt.getQuantity());
			}

			@Override
			public int getBatchSize() {
				return options.size();
			}
		});
	}

	@Override
	public List<ProductOption> getOptions(Integer productId) {
		String sql = "SELECT * FROM product_option WHERE product_id=" + productId;
		return jdbcTemplate.query(sql, new RowMapper<ProductOption>() {

			@Override
			public ProductOption mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new ProductOption(rs.getInt("id"), productId, rs.getString("size"), rs.getString("color"), rs.getInt("quantity"));
			}

		});
	}

	@Override
	public int deleteById(Integer id) {
		String sql = "DELETE FROM product_option WHERE id=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public int update(ProductOption opt) {
		String sql = "UPDATE product_option SET size=?,color=?,quantity=? where id=?";
		return jdbcTemplate.update(sql,opt.getSize(),opt.getColor(), opt.getQuantity(),opt.getId());
	}

}
