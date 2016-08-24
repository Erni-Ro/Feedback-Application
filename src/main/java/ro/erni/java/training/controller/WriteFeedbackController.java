package ro.erni.java.training.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import ro.erni.java.training.app.MainApp;
import ro.erni.java.training.dataAccessObject.WriteFeedbackDataAccessObject;

public class WriteFeedbackController {

	@FXML
	private TextArea answer1;
	@FXML
	private TextArea answer2;
	@FXML
	private TextArea answer3;
	@FXML
	private Text question1;
	@FXML
	private Text question2;
	@FXML
	private Text question3;
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
	private void goToSearchEmployee(ActionEvent event) throws IOException {
		MainApp.showSearchEmployee();
	}

	@FXML
	private void sendFeedback(ActionEvent event) throws FileNotFoundException {
		System.out.println("send");
		WriteFeedbackDataAccessObject fe = new WriteFeedbackDataAccessObject();
		fe.saveFeedback();
	}
}
