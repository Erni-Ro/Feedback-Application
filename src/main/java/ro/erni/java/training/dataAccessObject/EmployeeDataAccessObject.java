//package ro.erni.java.training.dataAccessObject;
//
//import java.util.List;
//
//import java.util.Map;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//
//public class EmployeeDataAccessObject {
//	private JdbcTemplate jdbcTemplate;
//
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
//
//	public boolean isEmployeeInDb(String username, String password) {
//		String query = "select username from employee where username = '" + username + "' and password = '" + password + "'";
//		List<Map<String, Object>> list = jdbcTemplate.queryForList(query);
//		return list.size() > 0;
//	}
//}
package ro.erni.java.training.dataAccessObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.erni.java.training.dataAccessObject.EmployeeDataAccessObject;
import ro.erni.java.training.model.Employee;

public class EmployeeDataAccessObject {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isEmployeeInDb(String username, String password) {
        String query = "select username from employee where username = '" + username + "' and password = '" + password + "'";
        List list = this.jdbcTemplate.queryForList(query);
        if (list.size() > 0) {
            return true;
        }
        return false;
    }

    public List<Employee> getAllEmployees() {
    	
        String query = "select * from employee";
        List list = this.jdbcTemplate.query(query,new  RowMapper<Employee>(){
        	public Employee mapRow(ResultSet rs, int rowNumber) throws SQLException{
        		Employee employee = new Employee();
        		  employee.setId(rs.getInt(1));
        		  employee.setUsername(rs.getString(2));
        		  employee.setPassword(rs.getString(3));
        		  employee.setEmail(rs.getString(4));
        		  employee.setFirstName(rs.getString(5));
        		  employee.setLastName(rs.getString(6));
        		  employee.setIdSubsidiary(rs.getInt(7));
        		  employee.setIdFunction(rs.getInt(8));
        		  return employee;
        	}
        });
        return list;
    }
}