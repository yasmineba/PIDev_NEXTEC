/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Connection;
import java.util.List;
import javafx.scene.chart.BarChart;
<<<<<<< HEAD
import models.Reclamation;
=======
import models.FournisseurProduit;
import models.Reclamation;
import models.ReclamationUtilisateur;
>>>>>>> moatez
import util.DataSource;

/**
 *
 * @author ASUS
 */
public interface I_reclamation {
<<<<<<< HEAD
    Connection cnx= DataSource.getInstance().getCnx();
=======
>>>>>>> moatez
    
    public boolean ajouterReclamation(Reclamation r);

    public List<Reclamation> afficherReclamations();

    public boolean modifierReclamation(Reclamation r);

    public boolean supprimerReclamation(Reclamation r);
    
    public int nombreReclamation();
<<<<<<< HEAD
=======
    public List<ReclamationUtilisateur> afficherReclamationUser(); 
    public boolean ajouterReclamationUser(Reclamation r);
     public int getiduser(String s);
     
     public List<ReclamationUtilisateur> trierReclamationUtilisateur();
     public List<ReclamationUtilisateur> chercherReclamationUse(String s);
     
     
    
>>>>>>> moatez
  
}
