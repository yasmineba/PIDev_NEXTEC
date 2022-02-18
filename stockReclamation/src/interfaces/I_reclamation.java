/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Connection;
import java.util.List;
import models.Reclamation;
import util.Maconnexion;

/**
 *
 * @author ASUS
 */
public interface I_reclamation {
     Connection cnx= Maconnexion.getInstance().getCnx();
    
    public boolean ajouterReclamation(Reclamation r);

    public List<Reclamation> afficherReclamations();

    public boolean modifierReclamation(Reclamation r);

    public boolean supprimerReclamation(Reclamation r);

}
