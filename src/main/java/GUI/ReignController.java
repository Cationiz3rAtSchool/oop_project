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
import GUI.Characters;
import com.google.gson.Gson;
import entity.Reign;
import entity.type.YearRange;

public class ReignController implements Initializable {
	   @FXML
	    public TableView<Reign> table;

	    @FXML
	    public TableColumn<Reign, String> ReignName;
	    @FXML
	    public TableColumn<Reign, YearRange> ReignExist;
	    @FXML
	    public TableColumn<Reign, String> ReignSource;

	    public TextField keywordTextField;
	    
	    static ObservableList<Reign> ReignList = FXCollections.observableArrayList();

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {

			// TODO Auto-generated method stub
	        ReignName.setCellValueFactory(new PropertyValueFactory<Reign, String>("Name"));
	        ReignExist.setCellValueFactory(new PropertyValueFactory<Reign, YearRange>("Exists"));
	        ReignSource.setCellValueFactory(new PropertyValueFactory<Reign, String>("Source"));

	        
	        table.setItems(ReignList);
	        
	        //seach machine
			FilteredList<Reign> filteredData = new FilteredList<>(ReignList, b -> true);
			keywordTextField.textProperty().addListener((observable, newValue,oldValue) ->{
				filteredData.setPredicate(Characters ->{
					// no search
					if (newValue.isEmpty() || newValue.isBlank() || newValue== null) {
						return true;
					} String searchKeyword =newValue.toLowerCase();
					if(((entity.Reign) ReignList).getName().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					} else if(((entity.Reign) ReignList).getExist().toString().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					} else if(((entity.Reign) ReignList).getSource().toLowerCase().indexOf(searchKeyword)> -1) {
						return true;
					} else {
						return false;
					}
				});
			});
		}
}

