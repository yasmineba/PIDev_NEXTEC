/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Journe;
import services.journeservice;

/**
 * FXML Controller class
 *
 * @author gaming
 */
public class UserJourneController implements Initializable {
    @FXML
    private TableView<Journe> journe;
    @FXML
    private TableColumn<Journe, Integer> numJ;
    @FXML   
    private TableColumn<Journe, String> DateJ;
    ObservableList<Journe> list1;
    @FXML
    private TextField textfield;
    @FXML
    private TextField textfield1;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
list = si.find();

       
         afficher();

    }    
    journeservice si = new journeservice();
        List<Journe> list = new ArrayList<>();
public void afficher(){
    list = si.find();
    System.out.println(list);
    
        list1 =FXCollections.observableArrayList(list);          
    numJ.setCellValueFactory(new PropertyValueFactory<Journe, Integer>("numJourne"));
        DateJ.setCellValueFactory(new PropertyValueFactory<Journe, String>("date_journe"));
        
    journe.setItems(FXCollections.observableArrayList(list1));
        FilteredList<Journe> filteredData = new FilteredList<>(list1, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		textfield.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(competition -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (String.valueOf(competition.getNumJourne()).indexOf(lowerCaseFilter)!=-1) {
					return true; // Filter matches first name.
				} 
			
				     else  
				    	 return false; // Does not match.
			});
		});
                SortedList<Journe> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(journe.comparatorProperty());
                FilteredList<Journe> filteredData1 = new FilteredList<>(sortedData, b -> true);
		textfield1.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData1.setPredicate(competition -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
			if (competition.getDate_journe().toLowerCase().indexOf(lowerCaseFilter) != -1)
				     return true;
			
				     else  
				    	 return false; // Does not match.
			});
		});
                	
		// 3. Wrap the FilteredList in a SortedList. 
	// 3. Wrap the FilteredList in a SortedList. 
		
		   SortedList<Journe> sortedData1 = new SortedList<>(filteredData1);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData1.comparatorProperty().bind(journe.comparatorProperty());
		// 5. Add sorted (and filtered) data to the table.
		journe.setItems(sortedData1);

		//comp.setItems(sortedData);
        
    
}

}
