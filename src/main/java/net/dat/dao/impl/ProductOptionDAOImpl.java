package net.dat.dao.impl;

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

}
