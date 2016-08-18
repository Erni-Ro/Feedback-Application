package ro.erni.java.training.dao.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.erni.java.training.dao.EmployeeDao;

public class EmployeeDaoTest {
	private ApplicationContext ctx;
	private EmployeeDao dao;

	@Before
	public void inintialize() {
		this.ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.dao = (EmployeeDao) ctx.getBean("edao");
	}

	@Test
	public void testPersistencyUsernameAndPasswordMatchDatabase() {
		assertEquals(true, dao.isEmployeeInDb("admin", "admin"));
	}

	@Test
	public void testFalsePersistencyUsernameAndPasswordMatchDatabase() {
		assertEquals(false, dao.isEmployeeInDb("alca", "admin"));
	}

}
