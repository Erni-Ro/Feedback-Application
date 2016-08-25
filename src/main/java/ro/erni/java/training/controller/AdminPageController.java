package ro.erni.java.training.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ro.erni.java.training.app.MainApp;
import ro.erni.java.training.dataAccessObject.FeedbackDataAccessObject;
import ro.erni.java.training.model.Feedback;

public class AdminPageController {
	@FXML
	private Label loggedAs;
	@FXML
	private Button signOutButton;
	@FXML
	private TableView<Feedback> tableView;
    @FXML
    private TableColumn<Feedback, String> receiverCol;
    @FXML
    private TableColumn<Feedback, String> senderCol;
    @FXML 
    private TableColumn<Feedback, String> rockAtCol;
    @FXML 
    private TableColumn<Feedback, String> goodAtCol;
    @FXML 
    private TableColumn<Feedback, String> improveOnCol;

	
	private ApplicationContext ctx;
	private FeedbackDataAccessObject feedbackDao;

	@FXML
	private void initialize() {
		this.ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.feedbackDao = (FeedbackDataAccessObject) ctx.getBean("feedbackDataAccessObject");
		loggedAs.setText(MainApp.loggedUser.getFirstName());
		
		List<Feedback> feedbacksList = feedbackDao.getAllFeedbacks();
	        System.out.println(feedbacksList);
	        this.senderCol.setCellValueFactory(new PropertyValueFactory<Feedback,String>("senderName"));
	        this.receiverCol.setCellValueFactory( new PropertyValueFactory<Feedback, String>("receiverName"));
	        this.rockAtCol.setCellValueFactory(new PropertyValueFactory<Feedback, String>("rocks"));
	        this.goodAtCol.setCellValueFactory(new PropertyValueFactory<Feedback, String>("good"));
	        this.improveOnCol.setCellValueFactory(new PropertyValueFactory<Feedback, String>("improve"));
	        ObservableList<Feedback> items = FXCollections.observableArrayList();
	        for (Feedback e : feedbacksList) {
	            items.add(e); new Feedback(e.getSenderId(),e.getReceiverId(),e.isAnonymous(),e.getRocks(),e.getGood(),e.getImprove());
	        }
	        this.tableView.setItems(items);	    }
	

	@FXML
	private void goToLogIn(ActionEvent event) throws IOException {
		MainApp.showLogIn();
	}

}
