package ro.erni.java.training.controller;

import java.io.IOException;
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
	private void goToSentFeedback(ActionEvent event) throws IOException {
		MainApp.showSentFeedback();
	}

	@FXML
	private void goToSearchEmployee(ActionEvent event) throws IOException {
		MainApp.showSearchEmployee();
	}

	@FXML
	private void goToLogIn(ActionEvent event) throws IOException {
		MainApp.showLogIn();
	}
	
	@FXML
	private void printInbox(ActionEvent event){
		System.out.println("Inbox is printing");
	}
	
	@FXML 
	private void deleteRecivedFeedback(ActionEvent event){
		System.out.println("Feedback deleted");
	}
}
