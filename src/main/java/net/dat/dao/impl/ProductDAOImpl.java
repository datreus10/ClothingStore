package net.dat.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import net.dat.dao.ProductDAO;
import net.dat.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	private final JdbcTemplate jdbcTemplate;
	
	public ProductDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int add(Product newProduct) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Product> getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
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

}
