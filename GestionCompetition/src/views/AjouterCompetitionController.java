/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import models.Competition;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import services.competitionservice;

/**
 * FXML Controller class
 *
 * @author gaming
 */
public class AjouterCompetitionController implements Initializable {

    @FXML
    private TextField adresse;
    @FXML
    private TextField nom;
    @FXML
    private TextField nb_equipe;
    @FXML
    private DatePicker date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjoutCompetition(ActionEvent event) {
        competitionservice cs=new competitionservice();

       cs.ajouter(new Competition(Integer.parseInt(nb_equipe.getText()),nom.getText(),date.getValue().toString(),adresse.getText()));
       
    }
    
}
