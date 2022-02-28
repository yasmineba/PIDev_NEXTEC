/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import models.Typee;
import services.ServiceTypee;

/**
 * FXML Controller class
 *
 * @author 21624
 */
public class AjouterTypeController implements Initializable {

    @FXML
    private TextField type;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterType(ActionEvent event) throws IOException {
        ServiceTypee st= new ServiceTypee();
        st.ajouterTypee(new Typee(type.getText()));
        JOptionPane.showMessageDialog(null, "Type Ajouté");
        
        
        
        
      
        
    }
    
}