/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Typee;

/**
 *
 * @author 21624
 */
public interface I_typee {
    
      //ajouter
    public boolean ajouterTypee(Typee T);

    //lister
    public List<Typee> afficherTypee();

    //update
    public boolean modifierTypee(Typee T);

    //delete
    public boolean supprimerTypee(Typee T);
}
