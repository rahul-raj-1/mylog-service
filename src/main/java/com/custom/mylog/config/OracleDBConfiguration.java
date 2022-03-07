package com.custom.mylog.config;

	

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sun.istack.NotNull;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class OracleDBConfiguration {
	
	
	@Value("${mylib.db.username}")
	@NotNull
    private String userName;
	

	@Bean
	public DataSource dataSource() throws SQLException {
		HikariConfig dbConfig = new HikariConfig();
		dbConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		dbConfig.setUsername(userName);
		dbConfig.setPassword("password");
		dbConfig.setDriverClassName("oracle.jdbc.OracleDriver");
		dbConfig.setMaximumPoolSize(2);
		dbConfig.setMinimumIdle(0);
		dbConfig.setAutoCommit(true);

		dbConfig.setIdleTimeout(30000);

		HikariDataSource ds = new HikariDataSource(dbConfig);
		
		System.out.println(" Data base connection ds " + ds);
		return ds;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() throws SQLException {
		return new JdbcTemplate(dataSource());

	}

}


