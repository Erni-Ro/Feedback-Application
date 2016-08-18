package ro.erni.java.training.controller.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import ro.erni.java.training.controller.LogInController;

public class LogInControllerTest {
	LogInController log;

	@Before
	public void initialize() {
		this.log = new LogInController();
		log.initialize();
	}

	@Test
	public void testLogInControllerUsernameAndPasswordMatch() {
		assertEquals(true, log.isValidUser("admin", "admin"));
	}

}
