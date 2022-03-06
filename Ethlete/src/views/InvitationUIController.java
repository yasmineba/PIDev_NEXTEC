/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import models.Invitation;
import models.User;
import models.Equipe;
import services.ServiceEquipe;
import services.ServiceInvitation;
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

/**
 * FXML Controller class
 *
 * @author anasl
 */
public class InvitationUIController implements Initializable {

              User u=new User(AuthentificationController.idglobal);
ServiceInvitation si=new ServiceInvitation();
    ServiceEquipe se=new ServiceEquipe();
    List<String> list1=new ArrayList();
    
 ObservableList<String> eq;
    @FXML
    private TableView<Invitation> invitations;
        @FXML

    private TableColumn<Invitation, String> etat;
    @FXML
    private ComboBox<String> list;
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
     lister();
    
    	
  afficher();
   
   
   
    }    
    //tzid 2 update lil etat
    // wahda tbadel etat lil
    // update invitation set etat ="" wher id_invitation =id
    

    @FXML
    private void ajouter_inv(ActionEvent event) {
        Equipe e=se.findBynom_equipe(list.getValue());
        si.ajouter(new Invitation("non_consulté",e.getId_equipe(),u.getId()));
          afficher();

        
    }

    @FXML
    private void supprimer(ActionEvent event) {
           Invitation e=invitations.getSelectionModel().getSelectedItem();
          se.supprimer(e.getId_invitation());
            afficher();

    }
    
    void lister()
    {for(int i=0;i<se.afficher().size();i++)
        list1.add(se.afficher().get(i).getNom_equipe());
    
    
    
      eq=FXCollections.observableArrayList(list1);
     list.setItems(eq);
    }
    void afficher()
    {

	ObservableList<Invitation> list4 =FXCollections.observableArrayList( si.afficher());
                //id_formation.setCellValueFactory(new PropertyValueFactory<Formation, Integer>("id_formation"));

etat.setCellValueFactory(new PropertyValueFactory<Invitation, String>("etat"));
		
    invitations.setItems(list4);

    
    }
    
}
