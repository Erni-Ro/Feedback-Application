package ro.erni.java.training.controller.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import ro.erni.java.training.app.MainApp;
import ro.erni.java.training.controller.LogInController;

public class LogInControllerTest {
	LogInController log;

	@Before
	public void initialize() {
		this.log = new LogInController();
		log.initialize();
	}

	@Test
	public void testLogInControllerUsernameAndPasswordMatch() {
		assertEquals(true, log.isValidUser("admin", "admin"));
	}

  @Test
  public void appInitializeTest() throws InterruptedException {
      Thread thread = new Thread(new Runnable() {

          @Override
          public void run() {
              new JFXPanel(); // Initializes the JavaFx Platform
              Platform.runLater(new Runnable() {

                  @Override
                  public void run() {
                      new MainApp().start(new Stage()); // Create and initialize app
                  }
              });
          }
      });
      thread.start();// Initialize the thread
      Thread.sleep(5000); // Time to use the app, with out this, the thread
                              // will be killed before you can tell.
  }
}
