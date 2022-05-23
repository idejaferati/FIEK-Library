package controllers;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import repositories.DatabaseConnection;
import repositories.DatabaseHandler;

import utilities.loginProperties;
public class loginController {
	Locale locale = new Locale("en_US");
    @FXML
    private Button cancelButton;

    @FXML
    private Button loginButton;

    @FXML
    private Label loginMessageLabel;
    @FXML
    private Label loginPass;
    @FXML
    private Label loginTitle;

    @FXML
    private Label loginUsername;

    @FXML
    private Label logintext;
    @FXML
    private Label lBtnLabel;
    @FXML
    private Label lgbbtncancelLabel;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private TextField usernameTextField;
    

    @FXML
    void cancelButtonOnAction(ActionEvent event) {
    	   Stage stage = (Stage) cancelButton.getScene().getWindow();
           stage.close();
       }

    @FXML
    void loginButtonOnAction(ActionEvent event) {
    	   if(!usernameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()) {
               // loginMessageLabel.setText("You try to login!");
               DatabaseHandler connectNow = new DatabaseHandler();
               String verifyLogin = "select count(1) from userAccount where username = '" + usernameTextField.getText() + "' and pass = '" + passwordPasswordField.getText() + "'";
               try {
                   
                   ResultSet queryResult = connectNow.execQuery(verifyLogin);

                   while(queryResult.next()) {
                       if(queryResult.getInt(1) == 1) {
                           //loginMessageLabel.setText("Welcome!");
                    	   
                    	   
                    	   
                    	   
                    	   
                    	   
                    	   ResourceBundle bundle = ResourceBundle.getBundle("resources.labelText",locale);
                    	   
                           Parent parent = FXMLLoader.load(getClass().getResource("/views/main-screen.fxml"),bundle);
                           Scene scene = new Scene(parent);
                           Stage primaryStage=new Stage();
                           primaryStage.initStyle(StageStyle.DECORATED);
                           primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                           primaryStage.setScene(scene);
                           primaryStage.setTitle("Library Management System");
                           primaryStage.getIcons().add(new Image("https://static.thenounproject.com/png/3314579-200.png"));
                           primaryStage.show();
                       } else {
                           loginMessageLabel.setText("Invalid Login. Please try again.");
                       }
                   }
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
           } else {
               loginMessageLabel.setText("Please enter username and password.");
           }
       }
    

    loginProperties LangProperties = new loginProperties();
    
    @FXML
    void setLanEng(ActionEvent event) {
    	LangProperties.setLanEngc(loginTitle,logintext, loginUsername, loginPass, lBtnLabel, lgbbtncancelLabel); 
    	locale = new Locale("en_US");
    	try {
			Main.lang = "en_US";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("English set as Main language");
    }

    @FXML
    void setLandAlb(ActionEvent event) {
    	LangProperties.setLanAlbc(loginTitle,logintext, loginUsername, loginPass, lBtnLabel, lgbbtncancelLabel);
    	locale = new Locale("Al_AL");
    	System.out.println("Shqipja si gjuhe kryesore");
    	try {
			Main.lang = "Al_AL";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
  

}
