package net.dat.dao.impl;

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

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import net.dat.dao.ProductDAO;
import net.dat.dao.ProductOptionDAO;
import net.dat.model.Product;
import net.dat.model.ProductOption;

@Repository
public class ProductDAOImpl implements ProductDAO {

	private final JdbcTemplate jdbcTemplate;
	private final ProductOptionDAO productOptionDAO;

	public ProductDAOImpl(JdbcTemplate jdbcTemplate, ProductOptionDAO productOptionDAO) {
		this.jdbcTemplate = jdbcTemplate;
		this.productOptionDAO = productOptionDAO;
	}

	@Override
	public int save(Product newProduct) {
		String sql = "INSERT INTO product(name,price,description,images) VALUES (?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder(); // return id when insert
		int result = jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, newProduct.getName());
				ps.setBigDecimal(2, newProduct.getPrice());
				ps.setString(3, newProduct.getDescription());
				ps.setString(4, newProduct.getImages());
				return ps;
			}
		}, keyHolder);
		if (result > 0) {
			Integer productId = keyHolder.getKey().intValue();
			newProduct.setId(productId);
			productOptionDAO.addList(newProduct.getOptions());
		}
		return result;
	}

	@Override
	public List<Product> getAll() {
		String sql = "SELECT * FROM product a,product_option b WHERE a.id=b.product_id LIMIT 100;";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Product>>() {

			@Override
			public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
				Map<Integer, Product> map = new HashMap<Integer, Product>();
				while(rs.next()) {
					Integer productId = rs.getInt("product_id");
					if(!map.containsKey(productId)) {
						map.put(productId, new Product());
						Product p = map.get(productId);
						p.setId(productId);
						p.setName(rs.getString("name"));
						p.setDescription(rs.getString("description"));
						p.setPrice(rs.getBigDecimal("price"));
						p.setImages(rs.getString("images"));
					}
					map.get(productId).addOption(new ProductOption(rs.getString("size"), rs.getString("color"), rs.getInt("quantity")));	
				}
				return new ArrayList<Product>(map.values());
			}
			
		});
	}

	@Override
	public Optional<Product> getById(Integer id) {
		String sql = "SELECT * FROM product a,product_option b WHERE a.id=b.product_id AND a.id=" + id;

		return Optional.ofNullable(jdbcTemplate.query(sql, new ResultSetExtractor<Product>() {
			@Override
			public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
				Product p = null;
				while (rs.next()) {
					if (p == null)
						p = new Product(rs.getInt("id"), rs.getString("name"), rs.getBigDecimal("price"),
								rs.getString("description"), rs.getString("images"));

					p.addOption(new ProductOption(rs.getString("size"), rs.getString("color"), rs.getInt("quantity")));
				}
				return p;
			}
		}));
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
