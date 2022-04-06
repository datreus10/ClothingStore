package net.dat.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.dat.dao.ProductOptionDAO;
import net.dat.model.ProductOption;

@Repository
public class ProductOptionDAOImpl implements ProductOptionDAO {

	private final JdbcTemplate jdbcTemplate;
	
	public ProductOptionDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public int add(ProductOption pOption) {
		String sql = "INSERT INTO product_option(product_id,size,color,quantity) VALUES(?,?,?,?)";
		return jdbcTemplate.update(sql, 
				pOption.getProduct().getId(),
				pOption.getSize(),
				pOption.getColor(),
				pOption.getQuantity());
	}


	@Override
	public int[] addList(List<ProductOption> options) {
		String sql = "INSERT INTO product_option(product_id,size,color,quantity) VALUES(?,?,?,?)";
		return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ProductOption opt = options.get(i);
				ps.setInt(1, opt.getId()); 
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

}
