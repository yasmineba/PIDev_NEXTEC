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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void part(ActionEvent event) throws IOException {
             FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../views/participationAdmin.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Consultation des partcipations");
            stage.setScene(new Scene(root1));  
            stage.show();
    }

    @FXML
    private void user(ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../views/FXMLadmin.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Gestion des utilisateurs");
            stage.setScene(new Scene(root1));  
            stage.show();
    }

    @FXML
    private void form(ActionEvent event) throws IOException {
             FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../views/GererFormation.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Gestion des formations");
            stage.setScene(new Scene(root1));  
            stage.show();
    }

    @FXML
    private void aff(ActionEvent event) throws IOException {
          FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../views/GererAff.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Gestion des affectations");
            stage.setScene(new Scene(root1));  
            stage.show();
    }
    @FXML
    private void gotoStock(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dashboardStock.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    }

    
  @FXML
    private void goToReclamations(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("reclamation.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    }
  @FXML

    private void gotoStatistics(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("statistiques.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    }
    
}
