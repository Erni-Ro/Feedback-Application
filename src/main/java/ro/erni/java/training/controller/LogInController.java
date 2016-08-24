package ro.erni.java.training.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

	public boolean isValidUser(String username, String password) throws SQLException {
		return employeeDataAccessObject.isEmployeeInDb(username, password);
	}

	@FXML
	private void handleSignIn(ActionEvent event) throws IOException, SQLException {
		String username = usernameField.getText();
		String password = passwordField.getText();
		System.out.println("Button clicked: " + username + " " + password);

		if (usernameField.getText().equals("admin") && passwordField.getText().equals("admin")) {
			MainApp.loggedUsername = username;
			MainApp.showAdminPage();
		} else if (isValidUser(username, password)) {
			MainApp.loggedUsername = username;
			MainApp.showInbox();
		} else {
			// Show the error message.
			usernameField.setText("");
			passwordField.setText("");
			Alert alert = new Alert(AlertType.ERROR);
			alert.getDialogPane().setPrefSize(200, 115);
			alert.getDialogPane().setMaxSize(200, 115);
			alert.getDialogPane().setMinSize(200, 115);
			alert.setY(450);
			alert.setX(850);
			alert.setTitle("Invalid SignIn");
			alert.setHeaderText("Incorrect user/password.");
			alert.showAndWait();
		}
	}
}