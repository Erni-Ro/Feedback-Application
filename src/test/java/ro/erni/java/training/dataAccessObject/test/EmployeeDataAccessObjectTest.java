package ro.erni.java.training.dataAccessObject.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ro.erni.java.training.dataAccessObject.EmployeeDataAccessObject;

public class EmployeeDataAccessObjectTest {
	private ApplicationContext context;
	private EmployeeDataAccessObject empDataAccessObject;

	@Before
	public void inintialize() {
		this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.empDataAccessObject = (EmployeeDataAccessObject) context.getBean("employeeDataAccessObject");
	}

	@Test
	public void testPersistencyUsernameAndPasswordMatchdataAccessObjectbase() throws SQLException {
		assertEquals(true, empDataAccessObject.isEmployeeInDb("admin", "admin"));
	}

	@Test
	public void testFalsePersistencyUsernameAndPasswordMatchdataAccessObjectbase() throws SQLException {
		assertEquals(false, empDataAccessObject.isEmployeeInDb("alca", "admin"));
	}

}
