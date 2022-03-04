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
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 * FXML Controller class
 *
 * @author anasl
 */
public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void InvitationUI(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../views/InvitationUI.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Suivi Invitation");
            stage.setScene(new Scene(root1));
            stage.show();
    }

    @FXML
    private void GestionAvis(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../views/GestionAvis.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Suivi Avis");
            stage.setScene(new Scene(root1));
            stage.show();
    }

    @FXML
    private void GestionEquipe(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../views/GestionEquipe.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Suivi Equipe");
            stage.setScene(new Scene(root1));
            stage.show();
    }

    @FXML
    private void ReponseInvitation(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../views/ReponseInvitation.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Reponse Invitation");
            stage.setScene(new Scene(root1));
            stage.show();
    }
    
}
