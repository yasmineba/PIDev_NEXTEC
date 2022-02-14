/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Evenement;

/**
 *
 * @author 21624
 */
public interface I_evenement {
     //ajouter
    public boolean ajouterEvenement(Evenement E);

    //lister
    public List<Evenement> afficherEvenement();

    //update
    public boolean modifierEvenement(Evenement E);

    //delete
    public boolean supprimerEvenement(Evenement E);

}
