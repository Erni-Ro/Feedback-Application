package ro.erni.java.training.controller;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import ro.erni.java.training.app.MainApp;
import ro.erni.java.training.dataAccessObject.FeedbackDataAccessObject;
import ro.erni.java.training.model.Employee;
import ro.erni.java.training.model.Feedback;
public class WriteFeedbackController {
	
	private Employee selectedEmployee;
	private ApplicationContext ctx;
	private FeedbackDataAccessObject feedbackDao;
	
	@FXML
	private Button sendButton;
	@FXML
	private Button backButton;
	@FXML
	private CheckBox checkBox;
	@FXML
	private TextArea rocksAtTextArea;
	@FXML
	private TextArea goodAtTextArea;
	@FXML
	private TextArea improveOnTextArea;

	
	@FXML
	private void initialize() {
		this.ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.feedbackDao = (FeedbackDataAccessObject) ctx.getBean("feedbackDataAccessObject");
	}
	
	public void initData(Employee selectedEmployee) {
		this.selectedEmployee=selectedEmployee;
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
		String rocksAt = rocksAtTextArea.getText();
		String goodAt = goodAtTextArea.getText();
		String improveOn = improveOnTextArea.getText();
		
		Feedback feedback = new Feedback(MainApp.loggedUser.getId(), selectedEmployee.getId(), false, rocksAt, goodAt, improveOn);
		int result = feedbackDao.saveFeedback(feedback);
		if (result>0)
		{
			createAlert(AlertType.INFORMATION, "Feedback successfully saved.");
			rocksAtTextArea.setText("");
			goodAtTextArea.setText("");
			improveOnTextArea.setText("");
		}
		else
		{
			createAlert(AlertType.ERROR, "Feedback was not saved.");
		}
	}

	private void createAlert(AlertType type, String message ) {
		Alert alert = new Alert(type );
		alert.getDialogPane().setPrefSize(200, 115);
		alert.getDialogPane().setMaxSize(200, 115);
		alert.getDialogPane().setMinSize(200, 115);
		alert.setY(MainApp.primaryStage.getY() + MainApp.primaryStage.getHeight() / 2 - alert.getDialogPane().getPrefHeight() / 2);
		alert.setX(MainApp.primaryStage.getX() + MainApp.primaryStage.getWidth() / 2 - alert.getDialogPane().getPrefWidth() / 2);
		alert.setTitle("Feedback");
		alert.setHeaderText(message);
		alert.showAndWait();
	}
}
