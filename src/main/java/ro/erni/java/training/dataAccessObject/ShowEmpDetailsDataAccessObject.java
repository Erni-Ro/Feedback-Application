package ro.erni.java.training.dataAccessObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javafx.collections.ObservableList;
import ro.erni.java.training.model.Employee;

public class ShowEmpDetailsDataAccessObject {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public ObservableList<Employee> getAllEmployees() {
		String query = "select firstname, lastname from employee";
		ObservableList<Employee> list = (ObservableList<Employee>) jdbcTemplate.query(query, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet st, int rowNum) throws SQLException {

				return new Employee(st.getString(5), st.getString(6), st.getString(4));
			}

		});
		return list;
	}
}
