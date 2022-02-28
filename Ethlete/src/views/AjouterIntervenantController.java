/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import models.Intervenant;
import services.ServiceIntervenant;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class AjouterIntervenantController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField tel;
    @FXML 
    private TextField id_type;
    @FXML
    private ImageView imgIV;
    @FXML
    private ImageView logo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
try {
            
            Image image = new Image(new FileInputStream("C:\\Users\\21624\\Documents\\NetBeansProjects\\Ethlete\\src\\views\\elements\\IMG_7061.jpeg"));
            imgIV.setImage(image);
            Image image1 = new Image(new FileInputStream("C:\\Users\\21624\\Documents\\NetBeansProjects\\Ethlete\\src\\views\\elements\\logo.png"));
            logo.setImage(image1);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }    

    @FXML
    private void ajouterIntervenant(ActionEvent event) {
        ServiceIntervenant si= new ServiceIntervenant();
        si.ajouterIntervenant(new Intervenant(nom.getText(),prenom.getText(),email.getText(), Integer.parseInt(tel.getText()),2));
        JOptionPane.showMessageDialog(null, "Type Ajouté");
        
    }
    
    /* public void setData(PointDeVente pt){
        this.ptdevente = pt;
        this.idLBL.setText(String.valueOf(pt.getReference()));
        this.nameLBL.setText(pt.getName());
        this.proprietaireLBL.setText(pt.getProprietaire());
        this.date_ouvLBL.setText(pt.getDate_ouverture().toString());
        
    }*/
    }

