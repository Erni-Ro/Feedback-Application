package ro.erni.java.training.controller;

import java.io.IOException;
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
import ro.erni.java.training.dataAccessObject.EmployeeDataAccessObject;

public class LogInController {

	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Button signInButton;

	private ApplicationContext context;
	private EmployeeDataAccessObject employeeDataAccessObject;

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	public void initialize() {
		this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.employeeDataAccessObject = (EmployeeDataAccessObject) context.getBean("employeeDataAccessObject");
	}

	@FXML
	public void enterButton() {
		// make signIn button work on enter key
		signInButton.defaultButtonProperty().bind(signInButton.focusedProperty());
	}

	public boolean isValidUser(String username, String password) {
		return employeeDataAccessObject.isEmployeeInDb(username, password);
	}

	/**
	 * Called when the user clicks signIn.
	 * 
	 * @throws IOException
	 */
	@FXML
	private void handleSignIn(ActionEvent event) throws IOException {
		String username = usernameField.getText();
		String password = passwordField.getText();
		System.out.println("Button clicked: " + username + " " + password);
		boolean isValidUser = employeeDataAccessObject.isEmployeeInDb(username, password);
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