package ro.erni.java.training.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import ro.erni.java.training.app.MainApp;
import ro.erni.java.training.dao.EmployeeDao;

public class LogInController {

	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Button signInButton;

	private ApplicationContext ctx; 
	private EmployeeDao dao;

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		this.ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.dao = (EmployeeDao) ctx.getBean("edao");
		signInButton.defaultButtonProperty().bind(signInButton.focusedProperty());//make signIn button work on enter key
	}

	/**
	 * Called when the user clicks signIn.
	 */
	@FXML
	private void handleSignIn(ActionEvent event) {
		String username = usernameField.getText();
		String password = passwordField.getText();
		System.out.println("Button clicked: " + username + " " + password);

		boolean isValidUser = dao.isEmployeeInDb(username, password);
		if (isValidUser) {
			MainApp.loggedUsername = username;
			MainApp.showInbox();
		} else {
			// Show the error message.
			usernameField.setText("");
			passwordField.setText("");
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid SignIn");
			alert.setHeaderText("Incorrect user/password.");
			alert.showAndWait();
		}
	}
}
