package controllers;

package sample.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginController {
    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    public void loginButtonOnAction(ActionEvent e) {
        if(usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false) {
            // loginMessageLabel.setText("You try to login!");
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();

            String verifyLogin = "select count(1) from userAccount where username = '" + usernameTextField.getText() + "' and password = '" + passwordPasswordField.getText() + "'";
            try {
                Statement statement = connectDB.createStatement();
                ResultSet queryResult = statement.executeQuery(verifyLogin);

                while(queryResult.next()) {
                    if(queryResult.getInt(1) == 1) {
                        //loginMessageLabel.setText("Welcome!");
                        Parent parent = FXMLLoader.load(getClass().getResource("../views/main-screen.fxml"));
                        Scene scene = new Scene(parent);
                        Stage primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                        primaryStage.setScene(scene);
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

    public void cancelButtonOnAction(ActionEvent e){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }


}