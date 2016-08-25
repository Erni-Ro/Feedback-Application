package ro.erni.java.training.controller;

import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ro.erni.java.training.app.MainApp;
import ro.erni.java.training.dataAccessObject.EmployeeDataAccessObject;
import ro.erni.java.training.model.Employee;

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

		usernameField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (newValue.isEmpty()) {
					return;
				}
				String lastChar = String.valueOf(newValue.charAt(newValue.length() - 1));
				if (!(isDigit(lastChar) || isLetter(lastChar))) {
					showWarningAlert();
					usernameField.setText(oldValue);
				}
			}
		});

		passwordField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (newValue.isEmpty()) {
					return;
				}
				String lastChar = String.valueOf(newValue.charAt(newValue.length() - 1));
				if (!(isDigit(lastChar) || isLetter(lastChar))) {
					showWarningAlert();
					passwordField.setText(oldValue);
				}
			}
		});
	}

	private boolean isLetter(String value) {
		return value.toLowerCase().matches("[a-z]");
	}

	private boolean isDigit(String value) {
		return value.matches("\\d");
	}

	private void showWarningAlert() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Invalid SignIn");
		alert.setHeaderText("Unaccepted character.");
		alert.getDialogPane().setPrefSize(200, 115);
		alert.getDialogPane().setMaxSize(200, 115);
		alert.getDialogPane().setMinSize(200, 115);
		alert.setY(MainApp.primaryStage.getY() + MainApp.primaryStage.getHeight() / 2
				- alert.getDialogPane().getPrefHeight() / 2);
		alert.setX(MainApp.primaryStage.getX() + MainApp.primaryStage.getWidth() / 2
				- alert.getDialogPane().getPrefWidth() / 2);
		alert.showAndWait();
	}

	@FXML
	public void enterButton() {
		// make signIn button work on enter key
		signInButton.defaultButtonProperty().bind(signInButton.focusedProperty());
	}

	public boolean isValidUser(String username, String password) {
		return employeeDataAccessObject.getEmployeeFromDb(username, password) != null;
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
		if (!isValidUser) {
			// Show the error message.
			usernameField.setText("");
			passwordField.setText("");
			Alert alert = new Alert(AlertType.ERROR);
			alert.getDialogPane().setPrefSize(200, 115);
			alert.getDialogPane().setMaxSize(200, 115);
			alert.getDialogPane().setMinSize(200, 115);
			alert.setY(MainApp.primaryStage.getY() + MainApp.primaryStage.getHeight() / 2
					- alert.getDialogPane().getPrefHeight() / 2);
			alert.setX(MainApp.primaryStage.getX() + MainApp.primaryStage.getWidth() / 2
					- alert.getDialogPane().getPrefWidth() / 2);
			alert.setTitle("Invalid SignIn");
			alert.setHeaderText("Incorrect user/password.");
			alert.showAndWait();
		}
		else {
			Employee loggedEmployee = employeeDataAccessObject.getEmployeeFromDb(username, password);
			if (usernameField.getText().equals("admin") && passwordField.getText().equals("admin")) {
				MainApp.loggedUser = loggedEmployee;
				MainApp.showAdminPage();
			} else if (isValidUser) {
				MainApp.loggedUser = loggedEmployee;
				MainApp.showInbox();

			}
		}
		
	}
}