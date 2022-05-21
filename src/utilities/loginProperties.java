package utilities;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class loginProperties {
	 
	 public void setLanEngc(Label loginTitle,Label logintext, Label loginUsername,Label loginPass, Label lBtnLabel, Label lgbbtncancelLabel ) {
		 		  
	    	System.out.println("hello");
	    	loginTitle.setText("FIEK Library");
	    	logintext.setText("Login");
	    	loginUsername.setText("Username");
	    	loginPass.setText("Password");
	      	lBtnLabel.setText("Login");
	      	lgbbtncancelLabel.setText("Cancel");
	    }
	   
	    public void setLanAlbc(Label loginTitle,Label logintext, Label loginUsername,Label loginPass, Label lBtnLabel, Label lgbbtncancelLabel) {
	    	System.out.println("pershendetje");	    	
	    	loginTitle.setText("Bibloteka FIEK");
	    	logintext.setText("Kyçu");
	    	loginUsername.setText("Perdoruesi");
	    	loginPass.setText("Fjalkalimi");
	     	lBtnLabel.setText("Kyçu");
	      	lgbbtncancelLabel.setText("Anulo");
	    }
}
