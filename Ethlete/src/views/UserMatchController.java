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
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import models.Competition;
import models.Match;
import services.matchservice;

/**
 * FXML Controller class
 *
 * @author gaming
 */
public class UserMatchController implements Initializable {

    @FXML
    private TableView<Match> match;
    @FXML
    private TableColumn<Match, String> equipe1;
    @FXML
    private TableColumn<Match, String> equipe2;
    @FXML
    private TableColumn<Match, String> etat;
    ObservableList<Match> list1;
    @FXML
    private TextField textfield;
    @FXML
    private TextField textfield1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO  
        list = si.find();

       
         afficher();

    }    
    matchservice si = new matchservice();
        List<Match> list = new ArrayList<>();
public void afficher(){
    list = si.find();
    System.out.println(list);
    
        list1 =FXCollections.observableArrayList(list);          
    equipe1.setCellValueFactory(new PropertyValueFactory<Match, String>("equipe1"));
        equipe2.setCellValueFactory(new PropertyValueFactory<Match, String>("equipe2"));
        etat.setCellValueFactory(new PropertyValueFactory<Match, String>("etat"));
        
    match.setItems(FXCollections.observableArrayList(list1));
        FilteredList<Match> filteredData = new FilteredList<>(list1, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		textfield.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(competition -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (competition.getEquipe1().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (competition.getEquipe2().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
			
				     else  
				    	 return false; // Does not match.
			});
		});
                SortedList<Match> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(match.comparatorProperty());
                FilteredList<Match> filteredData1 = new FilteredList<>(sortedData, b -> true);
		textfield1.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData1.setPredicate(competition -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
			if (competition.getEtat().toLowerCase().indexOf(lowerCaseFilter) != -1)
				     return true;
			
				     else  
				    	 return false; // Does not match.
			});
		});
                	
		// 3. Wrap the FilteredList in a SortedList. 
	// 3. Wrap the FilteredList in a SortedList. 
		
		   SortedList<Match> sortedData1 = new SortedList<>(filteredData1);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData1.comparatorProperty().bind(match.comparatorProperty());
		// 5. Add sorted (and filtered) data to the table.
		match.setItems(sortedData1);

		//comp.setItems(sortedData);
        
    
}

}
