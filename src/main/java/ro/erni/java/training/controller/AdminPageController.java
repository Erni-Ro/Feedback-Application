package ro.erni.java.training.controller;

import java.io.IOException;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ro.erni.java.training.app.MainApp;
import ro.erni.java.training.dataAccessObject.EmployeeDataAccessObject;

public class AdminPageController {
	@FXML
	private Label loggedAs;
	@FXML
	private Button signOutButton;
	private ApplicationContext ctx;
	private EmployeeDataAccessObject adminDataAccessObject;

	@FXML
	private void initialize() {
		this.ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.adminDataAccessObject = (EmployeeDataAccessObject) ctx.getBean("employeeDataAccessObject");
		loggedAs.setText(MainApp.loggedUsername);
	}

	@FXML
	private void goToLogIn(ActionEvent event) throws IOException {
		MainApp.showLogIn();
	}

}
