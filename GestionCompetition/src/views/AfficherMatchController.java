package views;


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
import com.sun.prism.impl.Disposer.Record;
import models.Match;
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
import services.matchservice;
/**
 * FXML Controller class
 *
 * @author gaming
 */
public class AfficherMatchController implements Initializable {

    @FXML private TextField filterfield;
    @FXML
    private TableView<Match> match;
    @FXML
    private TableColumn<Match, Integer> equipe1;
    @FXML
    private TableColumn<Match, Integer> equipe2;
    @FXML
    private TableColumn supprimer;
    matchservice sc = new matchservice();
    ObservableList<Match>  MatchList = FXCollections.observableArrayList();
    private TableView<Match> table = new TableView<Match>();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       go();
      
    }    
    /*public void search(){
        FilteredList<match> filteredData = new FilteredList<>(MatchList, b -> true);
		
		// 2.filter Predicate wa9et filer yetbadel
		filterfield.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Match -> {
				// If filter fergh affficher all.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name adresse date
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Match.getEquipe1().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter =nom 
				} else if (Match.getEquipe2().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter =date
				}
				     else  
				    	 return false; // Does not Match.
			});
		});
        
    }*/
    private void go(){
        matchservice ms = new matchservice();
        ms.find().stream().forEach((p)->{MatchList.add(p);});
       // id_competition.setCellValueFactory(new PropertyValueFactory<>("id_competition"));
        equipe1.setCellValueFactory(new PropertyValueFactory<>("equipe1"));
        equipe2.setCellValueFactory(new PropertyValueFactory<>("equipe"));

        
        
        match.setItems(MatchList);
           TableColumn col_action = new TableColumn<>("supprimer");
        match.getColumns().add(supprimer);
        
        
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
                List<Match> ae = (List<Match>) ms.findByID_inv(Integer.parseInt(newText));
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
                	Match currentComp = (Match) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                	//remove selected item from the table list
                	MatchList.remove(currentComp);
                        matchservice ms = new matchservice();
                        System.out.println(currentComp.getId_match());
                        ms.supprimer(new Match(currentComp.getId_match()));
                        AfficherMatchController am = new AfficherMatchController();
                               am.go();
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