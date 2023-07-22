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
import java.util.Set;
import entity.type.Date;
import entity.Festival;
import com.google.gson.Gson;


public class FestivalsController implements Initializable {
	   @FXML
	    public TableView<Festival> table;

	    @FXML
	    public TableColumn<Festival, String> FestivalName;
	    @FXML
	    public TableColumn<Festival, Date> FestivalDate;
	    @FXML
	    public TableColumn<Festival, Set<String>> FestivalEvent;
	    @FXML
	    public TableColumn<Festival, Set<String>> FestivalRelic;
	    @FXML
	    public TableColumn<Festival, Set<String>> FestivalCharacter;
	    @FXML
	    public TableColumn<Festival, String> FestivalSource;
	    public TextField keywordTextField;
	    
	    static ObservableList<Festival> FestivalList = FXCollections.observableArrayList();

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {

			// TODO Auto-generated method stub
			FestivalName.setCellValueFactory(new PropertyValueFactory<Festival, String>("Name"));
			FestivalDate.setCellValueFactory(new PropertyValueFactory<Festival, Date>("Date"));
	        FestivalEvent.setCellValueFactory(new PropertyValueFactory<Festival,  Set<String>>("Event"));
	        FestivalRelic.setCellValueFactory(new PropertyValueFactory<Festival,  Set<String>>("Relic"));
	        FestivalCharacter.setCellValueFactory(new PropertyValueFactory<Festival,  Set<String>>("Character"));
	        FestivalSource.setCellValueFactory(new PropertyValueFactory<Festival, String>("Source"));
	        
	        table.setItems(FestivalList);
	        
	        //seach machine
			FilteredList<Festival> filteredData = new FilteredList<>(FestivalList, b -> true);
			keywordTextField.textProperty().addListener((observable, newValue,oldValue) ->{
				filteredData.setPredicate(Characters ->{
					// no search
					if (newValue.isEmpty() || newValue.isBlank() || newValue== null) {
						return true;
					} String searchKeyword =newValue.toLowerCase();
					if((( entity.Festival) FestivalList).getName().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					} else if((( entity.Festival) FestivalList).getDate().toString().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					} else if((( entity.Festival) FestivalList).getCharacters().toString().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					}else if((( entity.Festival) FestivalList).getEvents().toString().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					}else if((( entity.Festival) FestivalList).getRelics().toString().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					}else if((( entity.Festival) FestivalList).getSource().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					} else {
						return false;
					}
				});
			});
		}
}

