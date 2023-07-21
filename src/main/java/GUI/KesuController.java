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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class KesuController implements Initializable {
	   @FXML
	    public TableView<Kesu> table;

	    @FXML
	    public TableColumn<Kesu, Integer> CharId;
	    @FXML
	    public TableColumn<Kesu, String> Charname;
	    @FXML
	    public TableColumn<Kesu, String> CharURL;
	    @FXML
	    public TableColumn<Kesu, String> CharInfo;

	    static ObservableList<Kesu> KesuList = FXCollections.observableArrayList();

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
	        CharId.setCellValueFactory(new PropertyValueFactory<Kesu, Integer>("Id"));
	        Charname.setCellValueFactory(new PropertyValueFactory<Kesu, String>("Name"));
	        CharInfo.setCellValueFactory(new PropertyValueFactory<Kesu, String>("Info"));
	        CharURL.setCellValueFactory(new PropertyValueFactory<Kesu, String>("Link"));
	        table.setItems(KesuList);
			
		}
		   public void GoBack(ActionEvent e) throws IOException {
		       // loader.setLocation(getClass().getResource("Characters.fxml"));
		        Parent CViewParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
		        Scene scene = new Scene(CViewParent);
		        Stage window =(Stage)((Node)e.getSource()).getScene().getWindow();
		        window.setScene(scene);
		        window.show();

		    }
		   public static void readCSV() {
		    	 
		        String CsvFile = "C:\\oop/ADV.csv";
		 
		        BufferedReader br;
		        try {
		            br = new BufferedReader(new FileReader(CsvFile));
	            	int    count =0;
		            String line;
		            while ((line = br.readLine()) != null) {
		            	count=count+1;
		                String[] fields = line.split("\"", -1);
		                Kesu KS = new Kesu( count, fields[1], fields[3], fields[5]);
		                KesuList.add(KS);
		 
		            }
		 
		        } catch (FileNotFoundException ex) {

		        } catch (IOException ex) {

		        }

}
}
