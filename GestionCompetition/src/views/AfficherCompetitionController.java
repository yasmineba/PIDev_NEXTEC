/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import models.Competition;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import services.competitionservice;
import com.sun.prism.impl.Disposer.Record;
import java.util.List;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.collections.transformation.FilteredList;
/**
 * FXML Controller class
 *
 * @author gaming
 */
public class AfficherCompetitionController implements Initializable {

    @FXML private TextField filterfield;
    private TableView<Competition> competitions;
    private TableColumn<Competition, String> nom;
    private TableColumn<Competition, String> adresse;
    private TableColumn<Competition, String> date;
    @FXML
    private TableColumn supprimer;
    competitionservice sc = new competitionservice();
    ObservableList<Competition>  CompetitionList = FXCollections.observableArrayList();
    private TableView<Competition> table = new TableView<Competition>();
    private TableColumn<?, ?> nbr;
    private TableColumn<Competition, Integer> nb_equipe;
    @FXML
    private TableView<?> match;
    @FXML
    private TableColumn<?, ?> equipe1;
    @FXML
    private TableColumn<?, ?> equipe2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       load();
      
    }    
    public void search(){
        FilteredList<Competition> filteredData = new FilteredList<>(CompetitionList, b -> true);
		
		// 2.filter Predicate wa9et filer yetbadel
		filterfield.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(competition -> {
				// If filter fergh affficher all.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name adresse date
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (competition.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter =nom 
				} else if (competition.getDate().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter =date
				}
				     else  
				    	 return false; // Does not match.
			});
		});
        
    }
    private void load(){
        competitionservice cs = new competitionservice();
        cs.find().stream().forEach((p)->{CompetitionList.add(p);});
       // id_competition.setCellValueFactory(new PropertyValueFactory<>("id_competition"));
        nb_equipe.setCellValueFactory(new PropertyValueFactory<>("nb_equipe"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));       
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        
        
        competitions.setItems(CompetitionList);
           TableColumn col_action = new TableColumn<>("supprimer");
        competitions.getColumns().add(supprimer);
        
        
      supprimer.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });
        supprimer.setCellFactory(
                new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
                return new ButtonCell();
            }
            
        

    });
        filterfield.textProperty().addListener((obs, oldText, newText) -> {
                List<Competition> ae = (List<Competition>) cs.findByID_inv(Integer.parseInt(newText));
                table.getItems().setAll(ae);

    });
           
    }
   
    
        private class ButtonCell extends TableCell<Record, Boolean> {
        final Button cellButton = new Button("Delete");

        ButtonCell(){

        	//Action when the button is pressed
            cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    // get Selected Item
                	Competition currentComp = (Competition) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                	//remove selected item from the table list
                	CompetitionList.remove(currentComp);
                        competitionservice cs = new competitionservice();
                        System.out.println(currentComp.getId_competition());
                        cs.supprimer(new Competition(currentComp.getId_competition()));
                        AfficherCompetitionController ac = new AfficherCompetitionController();
                               ac.load();
                }
            });
        }

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(cellButton);
            }
            else
                setGraphic(null);
        }
    }
    
    
}
