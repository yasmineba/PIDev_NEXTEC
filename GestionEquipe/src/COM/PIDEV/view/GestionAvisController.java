/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM.PIDEV.view;

import COM.PIDEV.models.Avis;
import COM.PIDEV.models.User;
import COM.PIDEV.service.ServiceAvis;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
public class GestionAvisController implements Initializable {

  User u = new User (5);
ServiceAvis sa=new ServiceAvis();
   
    List<String> list1=new ArrayList();
    
 ObservableList<String> eq;
    private TableView<Avis> aviss;
    private TableColumn<Avis, String> note;
    @FXML
    private ComboBox<String> list;
    @FXML
    private TableColumn<?, ?> name;
    @FXML
    private TableView<?> invitations;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
     lister();
     eq=FXCollections.observableArrayList(list1);
     list.setItems(eq);
     
   afficher();
   
   
   
    }    
    //tzid 2 update lil etat
    // wahda tbadel etat lil
    // update invitation set etat ="" wher id_invitation =id
    

    private void ajouter_avis(ActionEvent event) {
        sa.ajouter(new Avis("non consulté",u.getId()));
        
    }

    @FXML
    private void supprimer(ActionEvent event) {
           Avis e=aviss.getSelectionModel().getSelectedItem();
          sa.supprimer(e.getId_avis());
    }
    
    void lister()
    {for(int i=0;i<sa.afficher().size();i++)
        list1.add(sa.afficher().get(i).toString());
    
    
    
    
    }
    void afficher()
    {ObservableList<Avis> list3 =FXCollections.observableArrayList(sa.afficher());
                //id_formation.setCellValueFactory(new PropertyValueFactory<Formation, Integer>("id_formation"));

note.setCellValueFactory(new PropertyValueFactory<Avis, String>("note"));
    
}

    @FXML
    private void ajouter_note(ActionEvent event) {
    }
}
