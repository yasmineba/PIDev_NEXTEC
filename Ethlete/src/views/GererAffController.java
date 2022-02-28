/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import models.AffectationFormateur;
import models.Formation;
import models.Reponse_Form;
import models.Utilisateur;
import services.ServiceAffectationFormateur;
import services.ServiceFormateur;
import services.ServiceFormation;
import services.ServiceReponseImp;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class GererAffController implements Initializable {

     @FXML
    private TableView<Utilisateur> formateurs;
    @FXML
    private TableColumn<Utilisateur, String> nom_f;
    @FXML
    private TableColumn<Utilisateur, String> prenom;
    @FXML
    private TableColumn<Utilisateur, String> Email;
    @FXML
    private TableView<Formation> formations;
    @FXML
    private TableColumn<Formation, String> nom;
    @FXML
    private TableColumn<Formation, Date> debut;
    @FXML
    private TableColumn<Formation, Date> fin;
        @FXML
    private TableView<Reponse_Form> affectations;

    @FXML
    private TableColumn<Reponse_Form,String> rep;

    @FXML
    private Button btnInsert;

    /**
     * Initializes the controller class.
     */
    ServiceAffectationFormateur af=new ServiceAffectationFormateur();
            ServiceFormation sf=new ServiceFormation();
            ServiceFormateur sf1=new ServiceFormateur();
    @FXML
    private Button aff;
    @FXML
    private Button suppAff;
    @FXML
    private Button afficherform;
    @FXML
    private Button AfficherFormateur;
    @FXML
    private Button afficheForm;
    @FXML
    private JFXButton closeButton;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showFormation();
        showFormateur();
        //showAffectation();
    }    
          public void showFormation() {
		ObservableList<Formation> list =FXCollections.observableArrayList( sf.afficher());
                //id_formation.setCellValueFactory(new PropertyValueFactory<Formation, Integer>("id_formation"));

nom.setCellValueFactory(new PropertyValueFactory<Formation, String>("nom_formation"));
		debut.setCellValueFactory(new PropertyValueFactory<Formation, Date>("date_debut"));
		fin.setCellValueFactory(new PropertyValueFactory<Formation, Date>("date_fin"));
		//prog.setCellValueFactory(new PropertyValueFactory<Formation, String>("programme"));
		//dis.setCellValueFactory(new PropertyValueFactory<Formation, String>("dispositif"));
		formations.setItems(list);
	}
     public void showFormateur() {
	ObservableList<Utilisateur> list =FXCollections.observableArrayList( sf1.afficher());
                //id_formation.setCellValueFactory(new PropertyValueFactory<Formation, Integer>("id_formation"));

nom_f.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("nom"));
		prenom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("prenom"));
                Email.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("email"));
		//prog.setCellValueFactory(new PropertyValueFactory<Formation, String>("programme"));
		//dis.setCellValueFactory(new PropertyValueFactory<Formation, String>("dispositif"));
		formateurs.setItems(list);
	}
      @FXML
    void AjouterAffectation(ActionEvent event) {
      Formation f=formations.getSelectionModel().getSelectedItem();
      Utilisateur form=formateurs.getSelectionModel().getSelectedItem();
System.out.println(f.toString());
System.out.println(form.toString());

 af.affectation_formateur(f, form);
               JOptionPane.showMessageDialog(null,"C BN" );


    }
    
    @FXML
    void afficherAff(ActionEvent event) {
              Utilisateur u=formateurs.getSelectionModel().getSelectedItem();

        ObservableList<Formation> list =FXCollections.observableArrayList(af.consulter_toutes_affectation1(u.getId()));
                //id_formation.setCellValueFactory(new PropertyValueFactory<Formation, Integer>("id_formation"));

nom.setCellValueFactory(new PropertyValueFactory<Formation, String>("nom_formation"));
		debut.setCellValueFactory(new PropertyValueFactory<Formation, Date>("date_debut"));
		fin.setCellValueFactory(new PropertyValueFactory<Formation, Date>("date_fin"));
		//prog.setCellValueFactory(new PropertyValueFactory<Formation, String>("programme"));
		//dis.setCellValueFactory(new PropertyValueFactory<Formation, String>("dispositif"));
		formations.setItems(list);
                ServiceReponseImp sr=new ServiceReponseImp();
ServiceAffectationFormateur af=new ServiceAffectationFormateur();

 ServiceReponseImp srr=new ServiceReponseImp();
  Reponse_Form rs = new Reponse_Form();
 
                List<Reponse_Form> rplist=new ArrayList();
               
                for (int i=0;i<list.size();i++)
                { 
                     AffectationFormateur rf = af.ConsulterAffectation_precise1(u,list.get(i));
                    
                   
                           rs= sr.consulter_rep(rf.getReponse());
                rplist.add(rs);
                
                } 
                
                ObservableList<Reponse_Form> list1 = FXCollections.observableArrayList(rplist);  
                
                
                                                rep.setCellValueFactory(new PropertyValueFactory<Reponse_Form, String>("reponse"));
                                                affectations.setItems(list1);

                
                

                


    }

    
    @FXML
    void suppAff(ActionEvent event) {
              Utilisateur u=formateurs.getSelectionModel().getSelectedItem();
af.annuler_toute_affectation(u);
         JOptionPane.showMessageDialog(null,"succés" );

    }
      @FXML
    void AfficherFormation(ActionEvent event) {
showFormation() ;
                List<Reponse_Form> rplist=new ArrayList();

 ObservableList<Reponse_Form> list1 = FXCollections.observableArrayList(rplist);  
                
                
                                                rep.setCellValueFactory(new PropertyValueFactory<Reponse_Form, String>("reponse"));
                                                affectations.setItems(list1);

    }
    
    @FXML
    void AfficherFormateur(ActionEvent event) {
         Map<Formation,List<Utilisateur>> map1=af.consulter_formateurs_par_formation();

      Formation f=formations.getSelectionModel().getSelectedItem();
      for(Formation c:map1.keySet())
      {     if(c.getId_formation()==f.getId_formation())
 System.out.println(map1.get(c));
      ObservableList<Utilisateur> list =FXCollections.observableArrayList( map1.get(c));
                //id_formation.setCellValueFactory(new PropertyValueFactory<Formation, Integer>("id_formation"));

nom_f.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("nom"));
		prenom.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("prenom"));
                Email.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("email"));
		//prog.setCellValueFactory(new PropertyValueFactory<Formation, String>("programme"));
		//dis.setCellValueFactory(new PropertyValueFactory<Formation, String>("dispositif"));
		formateurs.setItems(list);
      
      
      }
       
      /**/

    }
        @FXML
    void afficheForm(ActionEvent event) {
showFormateur() ;
    }

   void consulterAff(ActionEvent event) {

    }

     /*  public void showAffectation() {
	ObservableMap<Formation,List<Utilisateur>>list;
               list =FXCollections.observableMap(af.consulter_formateurs_par_formation());
                //id_formation.setCellValueFactory(new PropertyValueFactory<Formation, Integer>("id_formation"));
for(Formation f:list.keySet())
{

for(int j=0;j<list.get(f).size();j++)
{

}
}

		
	}*/

    @FXML
    private void retour(ActionEvent event) {
           Stage stage = (Stage) closeButton.getScene().getWindow();
    stage.close();
    }
}
