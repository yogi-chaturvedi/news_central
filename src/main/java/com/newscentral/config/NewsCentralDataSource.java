package com.newscentral.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class NewsCentralDataSource {

	protected HikariConfig hikariConfig() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("com.mysql.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://localhost:3306/news-central");
		config.setUsername("root");
		config.setPassword("");
		config.setMaximumPoolSize(10);
		return config;
	}

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		HikariConfig config = hikariConfig();
		HikariDataSource dataSource = new HikariDataSource(config);
		return dataSource;
	}

}
