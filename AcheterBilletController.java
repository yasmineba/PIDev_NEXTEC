/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import models.Billet;
import models.Evenement;
import services.ServiceBillet;
import services.ServiceEvenement;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class AcheterBilletController implements Initializable {
    
    Billet billet = new Billet();
    Evenement event = new Evenement();
    ServiceEvenement se = new ServiceEvenement();
    ServiceBillet sb = new ServiceBillet();
    @FXML
    private ImageView logo;
    @FXML
    private Label prixLBL;
    @FXML
    private Label nomeventLBL;
    @FXML
    private Label prixtotLBL;
    @FXML
    private TextField qtLBL;

  
 
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Image image1 = null;
        try {
            image1 = new Image(new FileInputStream("C:\\Users\\21624\\Documents\\NetBeansProjects\\Ethlete\\src\\views\\elements\\logo.png"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AcheterBilletController.class.getName()).log(Level.SEVERE, null, ex);
        }
            logo.setImage(image1);
           
        
        // TODO
    }
    
    public void setData(Evenement e){
        
        this.event = se.retrieveEvent(e.getId_event());
        nomeventLBL.setText(this.event.getNom_event());
        prixLBL.setText(String.valueOf(this.event.getPrixU()));
        prixtotLBL.setText("0");
    }

   
    @FXML
    private void onKeyReleased_Nbr(KeyEvent event) {
        
            prixtotLBL.setText(String.valueOf(this.event.getPrixU() * Integer.parseInt(qtLBL.getText())));
   
    }

    
    
    
}
