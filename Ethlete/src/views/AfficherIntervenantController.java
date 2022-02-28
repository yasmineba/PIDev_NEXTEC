/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import models.Intervenant;
import services.ServiceIntervenant;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class AfficherIntervenantController implements Initializable {
    
    ObservableList<Intervenant> list = FXCollections.observableArrayList();
    ServiceIntervenant si = new ServiceIntervenant();
    

    @FXML
    private ImageView logo;
    @FXML
    private TableView<Intervenant> tableInter;
    @FXML
    private TableColumn<?, ?> idTBL;
    @FXML
    private TableColumn<?, ?> nomTBL;
    @FXML
    private TableColumn<?, ?> prenomTBL;
    @FXML
    private TableColumn<?, ?> emailTBL;
    private TableColumn<?, ?> tlphTLB;
    @FXML
    private TextField nomTF;
    @FXML
    private Label idLBL;
    @FXML
    private TableColumn<?, ?> tlphTBL;
    @FXML
    private TextField prenomTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField telephoneTF;
    @FXML
    private TextField rechercheTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  try {
            
            
            Image image1 = new Image(new FileInputStream("C:\\Users\\21624\\Documents\\NetBeansProjects\\Ethlete\\src\\views\\elements\\logo.png"));
            logo.setImage(image1);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
  
        updateList(si.afficherIntervenant());

    }

    @FXML
    private void ajouterBTN_clicked(ActionEvent event) {
        si.ajouterIntervenant(new Intervenant(nomTF.getText(),prenomTF.getText(),emailTF.getText(), Integer.parseInt(telephoneTF.getText()),2));
        JOptionPane.showMessageDialog(null, "Type Ajouté");
        
        clearCells();
        updateList(si.afficherIntervenant());
    }

    @FXML
    private void modifierBTN_clicked(ActionEvent event) {
        si.modifierIntervenant(new Intervenant(Integer.parseInt(idLBL.getText()),nomTF.getText(),prenomTF.getText(),emailTF.getText(), Integer.parseInt(telephoneTF.getText()),2));
        clearCells();
        updateList(si.afficherIntervenant());
    }

    @FXML
    private void deleteBTN_clicked(ActionEvent event) {
        si.supprimerIntervenant(new Intervenant(Integer.parseInt(idLBL.getText())));
        clearCells();
        updateList(si.afficherIntervenant());
    }
    
    private void updateList(List<Intervenant> theList){
        list.clear();
        theList.stream().forEach(p -> list.add(p));
        idTBL.setCellValueFactory(new PropertyValueFactory<>("id_inter"));
        nomTBL.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomTBL.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        emailTBL.setCellValueFactory(new PropertyValueFactory<>("email"));
        tlphTBL.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        
        tableInter.setItems(list);
    }
    
    private void clearCells(){
        nomTF.setText("");
        prenomTF.setText("");
        emailTF.setText("");
        telephoneTF.setText("");
    }

    @FXML
    private void rowClicked(MouseEvent event) {
        Intervenant row = tableInter.getSelectionModel().getSelectedItem();
        idLBL.setText(String.valueOf(row.getId_inter()));
        nomTF.setText(row.getNom());
        prenomTF.setText(row.getPrenom());
        emailTF.setText(row.getEmail());
        telephoneTF.setText(String.valueOf(row.getTelephone()));
    }

 

    @FXML
    private void rechercheTextChanged(KeyEvent event) {
        updateList(si.rechercherIntervenant(si.afficherIntervenant(), rechercheTF.getText()));
        
    }
}