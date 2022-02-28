/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Typee;
import models.Typeinter;

/**
 *
 * @author 21624
 */
public interface I_typeinter {
    //ajouter
    public boolean ajouterTypeinter(Typeinter Ti);

    //lister
    public List<Typeinter> afficherTypeinter();

    //update
    public boolean modifierTypeinter(Typeinter Ti);

    //delete
    public boolean supprimerTypeinter(Typeinter Ti);
}
