package GUI;

import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SidebarControler {

	   public void switchByGetFxml(String path, ActionEvent event) throws IOException {
	            String passedInPath = "src" + path;
	            URL url = FileSystems.getDefault().getPath(passedInPath)
	                    .toUri().toURL();
	          

	        Parent root = FXMLLoader.load(url);

	      Stage  stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	      Scene  scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	    }

	    @FXML
	    void switchToMain(ActionEvent event) throws IOException {
	        switchByGetFxml("/main/java/GUI/Home.fxml", event);
	    }

	    @FXML
	    void switchToCharacters(ActionEvent event) throws IOException {
	        switchByGetFxml("/main/java/GUI/Kesu.fxml",
	                event);
	    }

	    @FXML
	    void switchToRelics(ActionEvent event) throws IOException {
	        switchByGetFxml("/main/java/GUI/Relics.fxml",
	                event);
	    }

	    @FXML
	    void switchToEras(ActionEvent event) throws IOException {
	        switchByGetFxml("/main/java/GUI/Eras.fxml", event);
	    }

	    @FXML
	    void switchToEvents(ActionEvent event) throws IOException {
	        switchByGetFxml("/main/java/application/view/EventScreen.fxml", event);
	    }

	    @FXML
	    void switchToFestivals(ActionEvent event) throws IOException {
	        switchByGetFxml("/main/java/GUI/Festivals.fxml", event);
	    }

	    @FXML
	    void switchToKings(ActionEvent event) throws IOException {
	        switchByGetFxml("/main/java/GUI/Kings.fxml", event);
	    }
	}

