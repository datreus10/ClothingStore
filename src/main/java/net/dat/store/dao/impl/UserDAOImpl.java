package net.dat.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
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
		String sql = "INSERT INTO user(id,username,password,email,fullname,phone,address,role) VALUES (?,?,?,?,?,?,?,?)";
		user.setId(UUID.randomUUID().toString());
		return jdbcTemplate.update(sql, 
				user.getId(), 
				user.getUsername(), 
				user.getPassword(), 
				user.getEmail(), 
				user.getFullname(),
				user.getPhone(), 
				user.getAddress(), 
				user.getRole());
	}

	@Override
	public int update(User user) {
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement("UPDATE user SET username=?,password=?,email=?,fullname=?,phone=?,address=?,role=? where id=?");
				int counter = 1;
				ps.setString(counter++, user.getUsername());
				ps.setString(counter++, user.getPassword());
				ps.setString(counter++, user.getEmail());
				ps.setNString(counter++, user.getFullname());
				ps.setString(counter++, user.getPhone());
				ps.setNString(counter++, user.getAddress());
				ps.setString(counter++,user.getRole());
				ps.setString(counter++,user.getId());
				return ps;
			}
		});
	}

	@Override
	public int delete(String id) {
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement("DELETE FROM user WHERE id=?");
				ps.setString(1, id);
				return ps;
			}
		});
	}

	@Override
	public Optional<User> getById(String userId) {
		return jdbcTemplate.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement("SELECT * FROM user where id=?");
				ps.setString(1, userId);
				return ps;
			}
		}, new UserRowMapper()).stream().findFirst();
		
	}

	@Override
	public List<User> get(int limit) {
		return jdbcTemplate.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement("SELECT * FROM user LIMIT ?");
				ps.setInt(1, limit);
				return ps;
			}
		}, new UserRowMapper());

	}

	class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new User(rs.getString("id"), 
					rs.getString("username"), 
					rs.getString("password"), 
					rs.getString("email"),
					rs.getNString("fullname"), 
					rs.getString("phone"), 
					rs.getNString("address"), 
					rs.getString("role"));
		}

	}

	@Override
	public Optional<User> validateUser(User loginUser) {
		List<User> users = jdbcTemplate.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement("select * from user where username=? and password=?");
				ps.setString(1, loginUser.getUsername());
				ps.setString(2, loginUser.getPassword());
				return ps;
			}
		}, new UserRowMapper());

		return Optional.ofNullable(users.size() > 0 ? users.get(0) : null);

	}

}
