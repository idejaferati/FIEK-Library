package application;
	
import java.util.Locale;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	public Locale locale = new Locale("en_US");
	public static String lang = "en_US";
	
	@Override
	public void start(Stage primaryStage) {
		 try {
	            Parent root = FXMLLoader.load(getClass().getResource("/views/login.fxml"));
	            Scene scene = new Scene(root);
	            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
