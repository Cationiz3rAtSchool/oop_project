package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.transformation.FilteredList;

import java.net.URL;

import java.util.ResourceBundle;
import entity.Relic;


public class RelicsController implements Initializable {
	   @FXML
	    public TableView<Relic> table;

	    @FXML
	    public TableColumn<Relic, String> RelicName;
	    @FXML
	    public TableColumn<Relic, String> RelicSource;
	    @FXML
	    public TableColumn<Relic, Integer> RelicFound;
	    @FXML
	    public TableColumn<Relic, String> RelicLocation;

	    @FXML
	    public TextField keywordTextField;
	    
	    static ObservableList<Relic> RelicList = FXCollections.observableArrayList();

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {

			// TODO Auto-generated method stub
			RelicName.setCellValueFactory(new PropertyValueFactory<Relic, String>("Name"));
			RelicLocation.setCellValueFactory(new PropertyValueFactory<Relic, String>("Location"));
			RelicFound.setCellValueFactory(new PropertyValueFactory<Relic, Integer>("Found"));
			RelicSource.setCellValueFactory(new PropertyValueFactory<Relic, String>("Source"));

	        
	        table.setItems(RelicList);
	        
	        //seach machine
			FilteredList<Relic> filteredData = new FilteredList<>(RelicList, b -> true);
			keywordTextField.textProperty().addListener((observable, newValue,oldValue) ->{
				filteredData.setPredicate(Relic ->{
					// no search
					if (newValue.isEmpty() || newValue.isBlank() || newValue== null) {
						return true;
					} String searchKeyword =newValue.toLowerCase();
					if(((entity.Relic) RelicList).getName().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					} else if(((entity.Relic) RelicList).getLocation().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					} else if(((entity.Relic) RelicList).getFound().toString().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					}else if(((entity.Relic) RelicList).getSource().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					} else {
						return false;
					}
				});
			});
		}
}

