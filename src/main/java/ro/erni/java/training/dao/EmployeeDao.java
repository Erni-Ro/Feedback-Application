package ro.erni.java.training.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean isEmployeeInDb(String username, String password) {
		String query = "select username from employee where username = '" + username + "' and password = '" + password
				+ "'";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(query);
		return list.size() > 0;
	}
}
