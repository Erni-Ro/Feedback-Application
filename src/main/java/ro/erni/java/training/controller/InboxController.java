package ro.erni.java.training.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ro.erni.java.training.app.MainApp;

public class InboxController {

	@FXML
	private Label loggedAs;
	@FXML
	private Button searchEmployeeButton;
	@FXML
	private Button sentFeedbackButton;
	@FXML
	private Button signOutButton;
	@FXML
	private Button printButton;
	@FXML
	private Button deleteButton;

	@FXML
	private void initialize() {
		loggedAs.setText(MainApp.loggedUsername);
	}

	@FXML
	private void goToSentFeedback(ActionEvent event) {
		System.out.println("go to SentFeedback");
	}

	@FXML
	private void goToSearchEmployee(ActionEvent event) {
		System.out.println("go to SearchEmployee");
	}

	@FXML
	private void goToLogIn(ActionEvent event) {
		MainApp.showLogIn();
	}
}
