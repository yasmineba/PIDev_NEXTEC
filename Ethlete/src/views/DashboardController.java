/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

<<<<<<< HEAD
import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import ethlete.PIDEVBIS;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
=======
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
>>>>>>> moatez
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
<<<<<<< HEAD
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import t2s.son.LecteurTexte;
=======
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
>>>>>>> moatez

/**
 * FXML Controller class
 *
<<<<<<< HEAD
 * @author pc
 */
public class DashboardController implements Initializable {

    @FXML
    private ImageView logo;

=======
 * @author ASUS
 */
public class DashboardController implements Initializable {

>>>>>>> moatez
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
<<<<<<< HEAD
 
            
=======
>>>>>>> moatez
        // TODO
    }    

    @FXML
<<<<<<< HEAD
    private void GestionParticipation1(ActionEvent event) throws IOException {
                FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../views/participation.fxml"));
=======
    private void part(ActionEvent event) throws IOException {
             FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../views/participationAdmin.fxml"));
>>>>>>> moatez

            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
<<<<<<< HEAD
            stage.setTitle("Suivi Participation");
=======
            stage.setTitle("Consultation des partcipations");
>>>>>>> moatez
            stage.setScene(new Scene(root1));  
            stage.show();
    }

    @FXML
<<<<<<< HEAD
    private void GestionAffectation1(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../views/GererFormateur.fxml"));
=======
    private void user(ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../views/FXMLadmin.fxml"));
>>>>>>> moatez

            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
<<<<<<< HEAD
            stage.setTitle("Suivi Participation");
=======
            stage.setTitle("Gestion des utilisateurs");
>>>>>>> moatez
            stage.setScene(new Scene(root1));  
            stage.show();
    }

    @FXML
<<<<<<< HEAD
    private void GestionFormation(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../views/GererFormation.fxml"));
=======
    private void form(ActionEvent event) throws IOException {
             FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../views/GererFormation.fxml"));
>>>>>>> moatez

            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
<<<<<<< HEAD
            stage.setTitle("Suivi Participation");
=======
            stage.setTitle("Gestion des formations");
>>>>>>> moatez
            stage.setScene(new Scene(root1));  
            stage.show();
    }

    @FXML
<<<<<<< HEAD
    private void Gestioncommentaire1(ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../views/ParticipationAdmin.fxml"));
=======
    private void aff(ActionEvent event) throws IOException {
          FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../views/GererAff.fxml"));
>>>>>>> moatez

            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
<<<<<<< HEAD
            stage.setTitle("Suivi Participation");
            stage.setScene(new Scene(root1));  
            stage.show();
    }

    @FXML
    private void GestionAffectation2(ActionEvent event) throws IOException {
             FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../views/GererAff.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Suivi Participation");
            stage.setScene(new Scene(root1));  
            stage.show();
    }

    @FXML
    private void Gestioncommentaire2(ActionEvent event) throws IOException {
                FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../views/participation.fxml"));

            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Suivi Participation");
            stage.setScene(new Scene(root1));  
            stage.show();
    }

    @FXML
    private void suivi(ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("../views/ParticipationAdmin.fxml"));

     
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Suivi Participation");
            stage.setScene(new Scene(root1));  
            stage.show();
    }
=======
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
    
>>>>>>> moatez
}
