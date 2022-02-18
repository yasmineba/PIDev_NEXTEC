/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.I_commande;
import static interfaces.I_commande.cnx;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Commande;
import models.Fournisseur;

/**
 *
 * @author ASUS
 */
public class ServicesCommande implements I_commande {

    @Override
    public boolean ajouterCommande(Commande c) {
        
        
         String request = "INSERT INTO `commande`(`idp`, `quantite`, `datecom`) VALUES ("+c.getIdp()+","+c.getQuantite()+",NOW())";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(request) == 1)
                    return true;
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
        
    }

    @Override
    public List<Commande> afficherCommandes() {
         List<Commande> commandes = new ArrayList<Commande>();
       String req="SELECT * FROM commande";
       
         try {
             Statement st = cnx.createStatement();
             
             ResultSet rs = st.executeQuery(req);
             while (rs.next())
             {
                Commande c = new Commande (rs.getInt("idcom"),rs.getInt("idp"),rs.getInt("quantite"),rs.getString("datecom"));
                commandes.add(c);
                
                
             }
             
             
         } catch (SQLException ex) {
             ex.printStackTrace();// twarik mochkla win//
         }
         return commandes;
        
       
    }

    @Override
    public boolean modifierCommande(Commande c) {
       String req = "UPDATE `commande` SET `idp`="+c.getIdp()+",`quantite`="+c.getQuantite()+",`datecom`='"+c.getDatecom()+"' WHERE idcom = "+c.getIdcom()+" ";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1)
                return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerCommande(Commande c) {
        String req = "DELETE FROM `commande` WHERE idcom = "+c.getIdcom()+" ";

        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1)
                return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
}
