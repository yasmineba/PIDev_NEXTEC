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
<<<<<<< HEAD
=======
import models.CommandeProduit;
>>>>>>> moatez
import util.DataSource;

/**
 *
 * @author ASUS
 */
public interface I_commande {
<<<<<<< HEAD
        Connection cnx= DataSource.getInstance().getCnx();

    
    public boolean ajouterCommande(Commande c);

    public List<Commande> afficherCommandes();

    public boolean modifierCommande(Commande c);

    public boolean supprimerCommande(Commande c);
    
    public List<Commande> trierCommande();
    
    public List<Commande> chercherCommande(List<Commande> initialList, String input);
=======
    
    public boolean ajouterCommande(Commande c);
    public List<Commande> afficherCommandes();
    public boolean modifierCommande(Commande c);
    public boolean supprimerCommande(Commande c);
    public List<CommandeProduit> afficherCommandeProduit(); 
    
    public List<Commande> trierCommande();
    public List<CommandeProduit> trierCommandeProduit();
    public List<Commande> chercherCommande(List<Commande> initialList, String input);
    public List<CommandeProduit> chercherCommandePorduit(List<CommandeProduit> initialList, String input);
    
    
 
>>>>>>> moatez

}
