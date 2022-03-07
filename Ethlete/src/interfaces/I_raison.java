/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Connection;
import java.util.List;
<<<<<<< HEAD
=======
import models.Categorie;
>>>>>>> moatez
import models.Raison;
import util.DataSource;

/**
 *
 * @author ASUS
 */
public interface I_raison {
<<<<<<< HEAD
    Connection cnx= DataSource.getInstance().getCnx();
=======
>>>>>>> moatez
    
    public boolean ajouterRaison(Raison rz);

    public List<Raison> afficherRaisons();

    public boolean modifierRaison(Raison rz);

    public boolean supprimerRaison(Raison rz);
    
     public List<Raison> trierRaison();
    
    public List<Raison> chercherRaison(List<Raison> initialList, String input);
<<<<<<< HEAD
    
=======
    public int getidraison(String s);
     public List<Raison> afficherNomRaison();
>>>>>>> moatez
}
