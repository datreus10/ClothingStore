package net.dat.store.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import net.dat.store.dao.UserDAO;
import net.dat.store.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private final JdbcTemplate jdbcTemplate;

	public UserDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int save(User user) {
		String sql = "INSERT INTO user(username,password,email,fullname,phone,address,role) VALUES (?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getFullname(),
				user.getPhone(), user.getAddress(), user.getRole());
	}

	@Override
	public int update(User user) {
		
		String sql = "UPDATE user SET username=?,password=?,email=?,fullname=?,phone=?,address=?,role=? where id=?";
		return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getFullname(),
				user.getPhone(), user.getAddress(),user.getRole(), user.getId());
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM user WHERE id=" + id;
		return jdbcTemplate.update(sql);
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
			return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("email"),
					rs.getString("fullname"), rs.getString("phone"), rs.getString("address"), rs.getString("role"));
		}

	}

	@Override
	public Optional<User> validateUser(User loginUser) {
		String sql = new StringBuilder().append("select * from user where username='").append(loginUser.getUsername())
				.append("' and password='").append(loginUser.getPassword() + "'").toString();
		List<User> users = jdbcTemplate.query(sql, new UserRowMapper());

		return Optional.ofNullable(users.size() > 0 ? users.get(0) : null);

	}

}
