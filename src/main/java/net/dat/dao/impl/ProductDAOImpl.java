package net.dat.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
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
	public int add(Product newProduct) {
		String sql = "INSERT INTO product(name,price,description,images) VALUES (?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
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
			for (ProductOption pOpt : newProduct.getOptions()) {
				productOptionDAO.add(pOpt);
			}
		}
		return result;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
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
						p = new Product(rs.getString("name"), rs.getBigDecimal("price"), rs.getString("description"),
								rs.getString("images"));

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
