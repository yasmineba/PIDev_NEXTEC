/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import models.Match;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import services.matchservice;

/**
 * FXML Controller class
 *
 * @author gaming
 */
public class AjouterMatchController implements Initializable {

    @FXML
    private TextField equipe1;
    @FXML
    private TextField equipe2;
    

    /**
     * Initializes the controller class.
     */
    
    private void AjoutMatch(ActionEvent event) {
        matchservice ms=new matchservice();

       ms.ajouter(new Match(Integer.parseInt(this.equipe1.getText()),Integer.parseInt(this.equipe2.getText())));
    } 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
}
