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
import ro.erni.java.training.config.GetPropertyValues;

public class MainApp extends Application {

	private Stage primaryStage;
	private static BorderPane rootLayout;
	private static AnchorPane homePage;
	private static AnchorPane employeePage;
	public static String loggedUsername;
	static FXMLLoader loader;

	@Override
	public void start(Stage primaryStage) throws IOException {
		GetPropertyValues properties = new GetPropertyValues();
		properties.getPropValues();
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle(GetPropertyValues.propertyList.get("MainApp_Title"));

		initRootLayout();
		showLogIn();
	}

	public static void initializationLayout(String path) {
		try {
			loader = new FXMLLoader();
			URL fxmlUrl = new File(path).toURI().toURL();
			loader.setLocation(fxmlUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initRootLayout() throws IOException {
		initializationLayout(GetPropertyValues.propertyList.get("MainApp_rootLayoutPath"));
		rootLayout = loader.load();

		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void showLogIn() throws IOException {

		initializationLayout(GetPropertyValues.propertyList.get("MainApp_logInPath"));
		homePage = loader.load();

		rootLayout.setCenter(homePage);
	}

	public static void showInbox() throws IOException {

		initializationLayout(GetPropertyValues.propertyList.get("MainApp_inboxPath"));
		employeePage = loader.load();

		rootLayout.setCenter(employeePage);
	}
}
