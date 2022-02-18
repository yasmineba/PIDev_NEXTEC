/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Connection;
import java.util.List;
import models.Produit;
import util.Maconnexion;

/**
 *
 * @author ASUS
 */
public interface I_produit {
      Connection cnx= Maconnexion.getInstance().getCnx();
    
    public boolean ajouterProduit(Produit p);

    public List<Produit> afficherProduits();

    public boolean modifierProduit(Produit p);

    public boolean supprimerProduit(Produit p);

    
}
