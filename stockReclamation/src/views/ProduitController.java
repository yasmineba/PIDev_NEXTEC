/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javax.xml.bind.DatatypeConverter;
import models.Produit;
import services.ServicesCategorie;
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ProduitController implements Initializable {

    @FXML
    private Label nomproduit;
    @FXML
    private Label prixproduit;
    private Produit prod;
    @FXML
    private Label idproduit;
    @FXML
    private Label categorieproduit;
    ServicesCategorie sc = new ServicesCategorie();
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      public void setData(Produit p){
        this.prod= p;
        this.idproduit.setText(String.valueOf(p.getIdp()));
        this.nomproduit.setText(p.getNomp());
        this.prixproduit.setText(String.valueOf(p.getPrix()));
        this.categorieproduit.setText(String.valueOf(p.getIdcateg()));
        
    }
    
    
}
