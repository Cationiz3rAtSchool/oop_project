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


import java.net.URL;

import java.util.ResourceBundle;
import entity.Event;
import com.google.gson.Gson;


public class EventsController implements Initializable {
	   @FXML
	    public TableView<Event> table;

	    @FXML
	    public TableColumn<Event, String> EventName;
	    @FXML
	    public TableColumn<Event, Integer> EventYear;
	    @FXML
	    public TableColumn<Event, String> EventSource;
	   
	//    public TableColumn<Event, String> EventInfo;

	    @FXML
	    public TextField keywordTextField;
	    
	    static ObservableList<Event> EventList = FXCollections.observableArrayList();

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {

			// TODO Auto-generated method stub
			EventName.setCellValueFactory(new PropertyValueFactory<Event, String>("Name"));
	        EventSource.setCellValueFactory(new PropertyValueFactory<Event, String>("Source"));
	        EventYear.setCellValueFactory(new PropertyValueFactory<Event, Integer>("Year"));
	       // EventInfo.setCellValueFactory(new PropertyValueFactory<Event, String>("Info"));
        
	        table.setItems(EventList);
	        
	        //seach machine
			FilteredList<Event> filteredData = new FilteredList<>(EventList, b -> true);
			keywordTextField.textProperty().addListener((observable, newValue,oldValue) ->{
				filteredData.setPredicate(Characters ->{
					// no search
					if (newValue.isEmpty() || newValue.isBlank() || newValue== null) {
						return true;
					} String searchKeyword =newValue.toLowerCase();
					if(((entity.Event) EventList).getName().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					} else if(((entity.Event) EventList).getYear().toString().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					}else if(( (entity.Event) EventList).getSource().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					} else {
						return false;
					}
				});
			});
		}
}

