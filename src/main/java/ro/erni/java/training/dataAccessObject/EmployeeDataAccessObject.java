package ro.erni.java.training.dataAccessObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import ro.erni.java.training.model.Employee;

public class EmployeeDataAccessObject {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean isEmployeeInDb(String username, String password) throws SQLException {
		String query = "select username from employee where username=? and password=?";
		PreparedStatementSetter setter = new PreparedStatementSetter() {
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, password);
				preparedStatement.executeQuery();
			}
		};

		List<Employee> listContact = this.jdbcTemplate.query(query, setter, new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
				List<Employee> list = new ArrayList<Employee>();
				Employee e = new Employee();
				while (rs.next()) {
					e.setUsername(rs.getString(1));
					e.setPassword(rs.getString(2));
					list.add(e);
				}
				return e;
			}

		});
		
		return listContact.size() > 0;
	}

}
