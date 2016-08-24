package ro.erni.java.training.controller;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ro.erni.java.training.app.MainApp;
public class FeedbackPageController {
	


	@FXML
	private Button backButton;

	@FXML
	private void initialize() {
	}

	@FXML
	private void goToInbox(ActionEvent event) throws IOException{
		MainApp.showInbox();
	}
	
}
