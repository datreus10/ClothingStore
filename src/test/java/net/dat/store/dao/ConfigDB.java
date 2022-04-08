package net.dat.store.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ConfigDB {
	public static DriverManagerDataSource config() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/clothing_store");
		dataSource.setUsername("d");
		dataSource.setPassword("28220000");
		return dataSource;
	}

	public static JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(config());
	}
}
