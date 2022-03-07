package com.custom.mylog.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Component;

@Component
public class MyLogService {
	
	private final String INSERT_SQL = "INSERT INTO APP_LOG(APP_NAME) values(?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
    public void logError(String s ) {
		 
		 jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, s);
					return ps;
				}
			});
		 
		 
	 }

}
