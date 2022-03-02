/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM.PIDEV.view;

import COM.PIDEV.models.Equipe;
import COM.PIDEV.models.User;
import COM.PIDEV.service.ServiceEquipe;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author anasl
 */
public class GestionEquipeController implements Initializable {

   User u = new User (5);
 ServiceEquipe t = new ServiceEquipe ();
    /**
     * Initializes the controller class.
     */
 @FXML
    private javafx.scene.control.TextField nom;
    @FXML
    private TableView<Equipe> equipes;
    @FXML
    private TableColumn<Equipe, String> name;
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficher_equipes();
    }    

    @FXML
    private void ajouter_equipe(ActionEvent event) {
        t.ajouter(new Equipe (nom.getText(),u.getId()));
    }

    @FXML
    private void afficher_equipe(ActionEvent event) {
    
    Equipe e=equipes.getSelectionModel().getSelectedItem();
        nom.setText(e.getNom_equipe());

    
    }
   public void afficher_equipes() {
		ObservableList<Equipe> list =FXCollections.observableArrayList( t.afficher());
                //id_formation.setCellValueFactory(new PropertyValueFactory<Formation, Integer>("id_formation"));

name.setCellValueFactory(new PropertyValueFactory<Equipe, String>("nom_equipe"));
		
		equipes.setItems(list);
	}

    @FXML
    private void supprimer(ActionEvent event) {
          Equipe e=equipes.getSelectionModel().getSelectedItem();
          t.supprimer(e.getId_equipe());
          afficher_equipes();
    }

    @FXML
    private void modifier(ActionEvent event) {
          Equipe e=equipes.getSelectionModel().getSelectedItem();
          e.setNom_equipe(nom.getText());
          t.modifier(e.getId_equipe(), e);
          afficher_equipes();
    }
   
}