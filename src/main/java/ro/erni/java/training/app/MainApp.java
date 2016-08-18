package ro.erni.java.training.app;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private static BorderPane rootLayout;
	public static String loggedUsername;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("FeedbackApp");

		initRootLayout();
		showLogIn();
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			String pathToFxml = "src/main/java/ro/erni/java/training/view/RootLayout.fxml";
			URL fxmlUrl = new File(pathToFxml).toURI().toURL();
			loader.setLocation(fxmlUrl);
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shows the person overview inside the root layout.
	 */
	public static void showLogIn() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			String pathToFxml = "src/main/java/ro/erni/java/training/view/LogIn.fxml";
			URL fxmlUrl = new File(pathToFxml).toURI().toURL();
			loader.setLocation(fxmlUrl);
			AnchorPane homePage = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(homePage);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void showInbox() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			String pathToFxml = "src/main/java/ro/erni/java/training/view/Inbox.fxml";
			URL fxmlUrl = new File(pathToFxml).toURI().toURL();
			loader.setLocation(fxmlUrl);
			AnchorPane employeePage = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(employeePage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
