package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import repositories.DatabaseHandler;
import controllers.addBookController;
import models.IssuedBook;

public class issuedBooksController implements Initializable{
	  DatabaseHandler databaseHandler;

	@FXML
    private TableColumn<IssuedBook, String> BookIDCol;

    @FXML
    private TableColumn<IssuedBook, String> MemberCol;

    @FXML
    private TableColumn<IssuedBook, Integer> RenewCol;

    @FXML
    private  TableColumn<IssuedBook, String> TimeCol;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TableView<IssuedBook> tableView;

    
    ObservableList<IssuedBook> list = FXCollections.observableArrayList();

   
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initCol();
        loadData();
    }
    
    private void loadData() {
        databaseHandler=DatabaseHandler.getInstance();
        String qu = "SELECT * FROM issuedBooks";
        ResultSet rs = databaseHandler.execQuery(qu);
        try {
            while (rs.next()) {
                String bookId = rs.getString("bookID");
                String memberId = rs.getString("memberID");
                Timestamp issuedTime=rs.getTimestamp("issueTime");
                String issueTime = issuedTime.toString();
                Integer  renew = rs.getInt("renew_count");


                list.add(new IssuedBook(bookId, memberId, issueTime, renew));

            }
        } catch (SQLException ex) {
            Logger.getLogger(addBookController.class.getName()).log(Level.SEVERE, null, ex);
        }

        tableView.setItems(list);
    }
    private void initCol() {
        BookIDCol.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        MemberCol.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        TimeCol.setCellValueFactory(new PropertyValueFactory<>("issueTime"));
        RenewCol.setCellValueFactory(new PropertyValueFactory<>("renew"));

    }
    
    
  /*  void loadWindow(String loc, String title) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));
        } catch (IOException e) {
            e.printStackTrace();
        }
   */ 
}
