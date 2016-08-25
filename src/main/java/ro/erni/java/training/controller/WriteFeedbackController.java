package ro.erni.java.training.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import ro.erni.java.training.app.MainApp;
import ro.erni.java.training.dataAccessObject.EmployeeDataAccessObject;

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

	private ApplicationContext context;
	private EmployeeDataAccessObject wrFeedbDataAcessObject;
	
	@FXML
	public void initialize() {
		this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.wrFeedbDataAcessObject = (EmployeeDataAccessObject) context.getBean("employeeDataAccessObject");
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
	private void sendFeedback(ActionEvent event) throws SerialException, IOException, SQLException {
		System.out.println("send");
		wrFeedbDataAcessObject.saveFeedback(question1.getText(), answer1.getText(), checkBox.isSelected());
		wrFeedbDataAcessObject.saveFeedback(question2.getText(), answer2.getText(), checkBox.isSelected());
		wrFeedbDataAcessObject.saveFeedback(question3.getText(), answer3.getText(), checkBox.isSelected());
	}

}
