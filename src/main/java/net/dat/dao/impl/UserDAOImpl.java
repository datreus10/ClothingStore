package net.dat.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import net.dat.dao.UserDAO;
import net.dat.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private final JdbcTemplate jdbcTemplate;

	public UserDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(User user) {
		String sql = "INSERT INTO user(username,password,fullname,phone,address,role) VALUES (?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getFullname(), user.getPhone(),
				user.getAddress(), user.getRole());
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Optional<User> getById(Integer userId) {
		String sql = "SELECT * FROM user where id=" + userId;
		return jdbcTemplate.query(sql, new UserRowMapper()).stream().findFirst();
	}

	@Override
	public List<User> getAll() {
		String sql = "SELECT * FROM user LIMIT 100";
		return jdbcTemplate.query(sql, new UserRowMapper());

	}

	class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
					rs.getString("fullname"), rs.getString("phone"), rs.getString("address"), rs.getString("role"));
		}

	}

	@Override
	public User validateUser(User loginUser) {
		String sql = new StringBuilder()
				.append("select * from user where username='")
				.append(loginUser.getUsername())
				.append("' and password='")
				.append(loginUser.getPassword()+"'").toString();
		List<User> users = jdbcTemplate.query(sql, new UserRowMapper());

	    return users.size() > 0 ? users.get(0) : null;
		
	}

}
