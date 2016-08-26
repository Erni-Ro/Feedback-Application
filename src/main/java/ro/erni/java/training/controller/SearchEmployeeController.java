package ro.erni.java.training.controller;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ro.erni.java.training.app.MainApp;
import ro.erni.java.training.dataAccessObject.EmployeeDataAccessObject;
import ro.erni.java.training.model.Employee;

public class SearchEmployeeController {
    @FXML
    private Label loggedAs;
    @FXML
    private Button sentFeedbackButton;
    @FXML
    private Button inboxButton;
    @FXML
    private Button signOutButton;
    @FXML
    private Button writeFeedbackButton;
    @FXML
    private Button searchButton;
    @FXML
    private TableView<Employee> tableView;
    @FXML
    private TableColumn<Employee, String> firstNameCol;
    @FXML
    private TableColumn<Employee, String> lastNameCol;
    @FXML 
    private TableColumn<Employee, String> usernameCol;
    @FXML 
    private TableColumn<Employee, String> emailCol;
    @FXML 
    private TableColumn<Employee, String> roleCol;
    @FXML 
    private TableColumn<Employee, String> cityCol;
    
    
    private ApplicationContext context;
    private EmployeeDataAccessObject employeeDao;

    @FXML
    private void initialize() {
        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.employeeDao = (EmployeeDataAccessObject)this.context.getBean("employeeDataAccessObject");
        loggedAs.setText(MainApp.loggedUser.getFirstName()+ " " + MainApp.loggedUser.getLastName());
        List<Employee> employeeList = this.employeeDao.getAllEmployees();
        System.out.println(employeeList);
        this.firstNameCol.setCellValueFactory( new PropertyValueFactory<Employee, String>("firstName"));
        this.lastNameCol.setCellValueFactory( new PropertyValueFactory<Employee, String>("lastName"));
        this.usernameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("username"));
        this.emailCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
        this.roleCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("city"));
        this.cityCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("function"));
        ObservableList<Employee> items = FXCollections.observableArrayList();
        for (Employee e : employeeList) {
            items.add(e); 
        }
        this.tableView.setItems(items);
    }

    @FXML
    private void goToInbox(ActionEvent event) throws IOException {
        MainApp.showInbox();
    }

    @FXML
    private void goToSentFeedback(ActionEvent event) throws IOException {
    	
        MainApp.showSentFeedback();
    }

    @FXML
    private void goToLogIn(ActionEvent event) throws IOException {
        MainApp.showLogIn();
    }

    @FXML
    private void goToWriteFeedback(ActionEvent event) throws IOException {
    	Employee selectedEmployee = tableView.getSelectionModel().getSelectedItem();
        MainApp.showWriteFeedback(selectedEmployee);
    }
    
    @FXML
    private void searchForEmployee(ActionEvent event) {
        System.out.println("Search Employee");
    }
}