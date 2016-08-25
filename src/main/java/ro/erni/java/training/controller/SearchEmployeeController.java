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

public class SearchEmployeeController {

	@FXML
	private Label loggedAs;
	@FXML
	private Button sentFeedbackButton;
	@FXML
	private Button inboxButton;
	@FXML
	private Button signOutButton;
	@FXML
	private Button writeFeedbackButton;
	@FXML
	private Button searchButton;

	private ApplicationContext context;
	@SuppressWarnings("unused")
	private EmployeeDataAccessObject employeeDataAccessObject;

	@FXML
	private void initialize() {
		this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.employeeDataAccessObject = (EmployeeDataAccessObject) context.getBean("employeeDataAccessObject");
		loggedAs.setText(MainApp.loggedUsername);
	}

	@FXML
	private void goToInbox(ActionEvent event) throws IOException {
		MainApp.showInbox();
	}

	@FXML
	private void goToSentFeedback(ActionEvent event) throws IOException {
		MainApp.showSentFeedback();
	}

	@FXML
	private void goToLogIn(ActionEvent event) throws IOException {
		MainApp.showLogIn();
	}

	@FXML
	private void goToWriteFeedback(ActionEvent event) throws IOException {
		MainApp.showWriteFeedback();
		System.out.println("write feedback");
	}

	@FXML
	private void searchForEmployee(ActionEvent event) {
		System.out.println("Search Employee");
	}
}