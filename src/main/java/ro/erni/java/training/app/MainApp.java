package ro.erni.java.training.app;


import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private static BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("FeedbackApp");

		initRootLayout();
		showEmployeeHomePage();
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		
	}

	/**
	 * Shows the person overview inside the root layout.
	 */
	public void showEmployeeHomePage() {
		
	}

	public static void showInbox() {
		
	}

	// Returns the main stage.
	public Stage getPrimaryStage() {
		return primaryStage;
	}

}
