/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Connection;
import java.util.List;
import models.Commande;
import models.Commande;
import util.DataSource;

/**
 *
 * @author ASUS
 */
public interface I_commande {
        Connection cnx= DataSource.getInstance().getCnx();

    
    public boolean ajouterCommande(Commande c);

    public List<Commande> afficherCommandes();

    public boolean modifierCommande(Commande c);

    public boolean supprimerCommande(Commande c);
    
    public List<Commande> trierCommande();
    
    public List<Commande> chercherCommande(List<Commande> initialList, String input);

}