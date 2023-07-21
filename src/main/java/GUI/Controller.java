package Tableview;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;

public class Controller implements Initializable {
	@FXML private Button Kesu;
	@FXML private Button Wiki;
	@FXML private TextField Welcome;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	   public void changeSceneKesu(ActionEvent e) throws IOException {
	       // loader.setLocation(getClass().getResource("Characters.fxml"));
	        Parent CViewParent = FXMLLoader.load(getClass().getResource("Kesu.fxml"));
	        Scene scene = new Scene(CViewParent);
	        Stage window =(Stage)((Node)e.getSource()).getScene().getWindow();
	        window.setScene(scene);
	        window.show();

	    }
	   public void changeSceneWiki(ActionEvent e) throws IOException {
	       // loader.setLocation(getClass().getResource("Characters.fxml"));
	        Parent CViewParent = FXMLLoader.load(getClass().getResource("Wiki.fxml"));
	        Scene scene = new Scene(CViewParent);
	        Stage window =(Stage)((Node)e.getSource()).getScene().getWindow();
	        window.setScene(scene);
	        window.show();

	    }

}
