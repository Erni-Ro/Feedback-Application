package ro.erni.java.training.dataAccessObject.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.erni.java.training.dataAccessObject.DataAccessObject;

public class EmployeeDataAccessObjectTest {
	private ApplicationContext context;
	private DataAccessObject employeeDataAccessObject;

	@Before
	public void inintialize() {
		this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.employeeDataAccessObject = (DataAccessObject) context.getBean("employeeDataAccessObject");
	}

	@Test
	public void testPersistencyUsernameAndPasswordMatchdataAccessObjectbase() {
		assertEquals(true, employeeDataAccessObject.isEmployeeInDb("admin", "admin"));
	}

	@Test
	public void testFalsePersistencyUsernameAndPasswordMatchdataAccessObjectbase() {
		assertEquals(false, employeeDataAccessObject.isEmployeeInDb("alca", "admin"));
	}
}
