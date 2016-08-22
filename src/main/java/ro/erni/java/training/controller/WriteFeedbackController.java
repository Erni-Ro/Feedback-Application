package ro.erni.java.training.controller;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import ro.erni.java.training.app.MainApp;
public class WriteFeedbackController {
	

	@FXML
	private Button sendButton;
	@FXML
	private Button backButton;
	@FXML
	private CheckBox checkBox;

	@FXML
	private void initialize() {
	}
	
	@FXML
	private void handleCheckBoxAction() {
		  System.out.println(("CheckBox Action (selected: " + checkBox.isSelected() + ")\n"));
		}
	
	@FXML
	private void goToSearchEmployee(ActionEvent event) throws IOException{
		MainApp.showSearchEmployee();
	}
	
	@FXML
	private void sendFeedback(ActionEvent event){
		System.out.println("send");
	}
}
