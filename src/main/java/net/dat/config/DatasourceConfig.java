package net.dat.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatasourceConfig {
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/clothing_store");
		dataSource.setUsername("d");
		dataSource.setPassword("28220000");
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}

}
