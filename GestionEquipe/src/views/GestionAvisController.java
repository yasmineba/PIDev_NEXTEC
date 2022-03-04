/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.jfoenix.controls.JFXButton;
import models.Avis;
import models.Invitation;
import models.User;
import services.ServiceAvis;
import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author anasl
 */
public class GestionAvisController implements Initializable {

    private TableView<Avis> avis;
    private TableColumn<Avis,Integer> note_id;
    @FXML
    private ComboBox<Integer> list;
    @FXML
    private TableView<Avis> avis1;
    @FXML
    private TableColumn<Avis, Integer> note1;
    @FXML
    private JFXButton cb;
      void lister()
    {List<Integer> list1=new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
     ObservableList<Integer> eq;

    
    
      eq=FXCollections.observableArrayList(list1);
     list.setItems(eq);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficher();
        lister();
        	ObservableList<Avis> list4 =FXCollections.observableArrayList( sa.afficher());
System.out.println(list4);
    }    
    User u = new User (5);

    @FXML
    private void ajouter_avis(ActionEvent event) {
        
        sa.ajouter(new Avis(u.getId(),list.getValue()));
        
        
    }

    @FXML
    private void supprimer(ActionEvent event) {
           Avis e=avis.getSelectionModel().getSelectedItem();
          sa.supprimer(e.getId_avis());
            afficher();
    }
    ServiceAvis sa=new ServiceAvis();
     void afficher()
    {

	ObservableList<Avis> list4 =FXCollections.observableArrayList( sa.afficher());
                //id_formation.setCellValueFactory(new PropertyValueFactory<Formation, Integer>("id_formation"));

note1.setCellValueFactory(new PropertyValueFactory<Avis,Integer>("note"));
		
    avis1.setItems(list4);

    
    }

    @FXML
    private void retour_menu(ActionEvent event) {
        Stage stage = (Stage)cb.getScene().getWindow();
       stage.close(); 
              
    }
    
}
