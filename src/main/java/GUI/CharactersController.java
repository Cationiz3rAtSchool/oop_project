package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.transformation.FilteredList;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.EventObject;
import java.util.List;
import java.util.ResourceBundle;
import GUI.Characters;
import com.google.gson.Gson;


public class CharactersController implements Initializable {
	   @FXML
	    public TableView<Characters> table;

	    @FXML
	    public TableColumn<Characters, String> CharName;
	    @FXML
	    public TableColumn<Characters, String> CharSource;
	    @FXML
	    public TableColumn<Characters, String> CharChildren;
	    @FXML
	    public TableColumn<Characters, String> CharLife;
	    @FXML
	    public TableColumn<Characters, String> CharFather;
	    @FXML
	    public TableColumn<Characters, String> CharCrowned;
	    @FXML
	    public TableColumn<Characters, String> CharAlias;
	    @FXML
	    public TextField keywordTextField;
	    
	    static ObservableList<Characters> CharList = FXCollections.observableArrayList();

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			CharList = FXCollections.observableArrayList(
	                new Characters("Chau", "ChauN", "Cha","con","86","1945","wwww")
	        );
			// TODO Auto-generated method stub
	        CharName.setCellValueFactory(new PropertyValueFactory<Characters, String>("Name"));
	        CharChildren.setCellValueFactory(new PropertyValueFactory<Characters, String>("Children"));
	        CharFather.setCellValueFactory(new PropertyValueFactory<Characters, String>("Father"));
	        CharAlias.setCellValueFactory(new PropertyValueFactory<Characters, String>("Alias"));
	        CharLife.setCellValueFactory(new PropertyValueFactory<Characters, String>("Lived"));
	        CharCrowned.setCellValueFactory(new PropertyValueFactory<Characters, String>("Crowned"));
	        CharSource.setCellValueFactory(new PropertyValueFactory<Characters, String>("Source"));
	        
	        table.setItems(CharList);
	        
	        //seach machine
			FilteredList<Characters> filteredData = new FilteredList<>(CharList, b -> true);
			keywordTextField.textProperty().addListener((observable, newValue,oldValue) ->{
				filteredData.setPredicate(Characters ->{
					// no search
					if (newValue.isEmpty() || newValue.isBlank() || newValue== null) {
						return true;
					} String searchKeyword =newValue.toLowerCase();
					if(((GUI.Characters) CharList).getName().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					} else if(((GUI.Characters) CharList).getChildren().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					} else if(((GUI.Characters) CharList).getAlias().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					}else if(((GUI.Characters) CharList).getLife().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					}else if(((GUI.Characters) CharList).getCrown().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					}else if(((GUI.Characters) CharList).getSource().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					}else if(((GUI.Characters) CharList).getFather().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					} else {
						return false;
					}
				});
			});
		}
}

