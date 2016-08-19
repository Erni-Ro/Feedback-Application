package ro.erni.java.training.dataAccessObject.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.erni.java.training.dataAccessObject.EmployeeDataAccessObject;

public class EmployeeDataAccessObjectTest {
	private ApplicationContext context;
	private EmployeeDataAccessObject dataAccessObject;

	@Before
	public void inintialize() {
		this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.dataAccessObject = (EmployeeDataAccessObject) context.getBean("employeeDataAccessObject");
	}

	@Test
	public void testPersistencyUsernameAndPasswordMatchdataAccessObjectbase() {
		assertEquals(true, dataAccessObject.isEmployeeInDb("admin", "admin"));
	}

	@Test
	public void testFalsePersistencyUsernameAndPasswordMatchdataAccessObjectbase() {
		assertEquals(false, dataAccessObject.isEmployeeInDb("alca", "admin"));
	}

}
