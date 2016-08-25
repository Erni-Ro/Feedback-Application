package ro.erni.java.training.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ro.erni.java.training.app.MainApp;
import ro.erni.java.training.dataAccessObject.ShowEmpDetailsDataAccessObject;
import ro.erni.java.training.model.Employee;

public class InboxController {

	@FXML
	private TableView<Employee> employeeTable;
	@FXML
	private TableColumn<Employee, String> firstNameColumn;
	@FXML
	private TableColumn<Employee, String> lastNameColumn;
	@FXML
	private TableColumn<Employee, String> feedbackCollum;
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

	public InboxController() {
		super();
	}

	@FXML
	private void initialize() throws IOException {
		/*ShowEmpDetailsDataAccessObject allEmp = new ShowEmpDetailsDataAccessObject();
		ObservableList<Employee> list = allEmp.getAllEmployees();
		for (Employee employee : list) {
			firstNameColumn.setCellValueFactory(firstNameColumn -> employee.firstNameProperty());
			lastNameColumn.setCellValueFactory(lastNameColumn -> employee.lastNameProperty());
			feedbackCollum.setCellValueFactory(feedbackCollum -> employee.emailProperty());
		}*/
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
	private void printInbox(ActionEvent event) {
		System.out.println("Inbox is printing");
	}

	@FXML
	private void deleteRecivedFeedback(ActionEvent event) {
		System.out.println("Feedback deleted");
	}

	public void setEmployeeTable() {
		ShowEmpDetailsDataAccessObject allEmp = new ShowEmpDetailsDataAccessObject();
		employeeTable.setItems(allEmp.getAllEmployees());
	}
}
