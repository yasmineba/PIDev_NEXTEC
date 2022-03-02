/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.I_produit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import models.Categorie;
import models.Fournisseur;
import models.Produit;
import util.Maconnexion;

/**
 *
 * @author ASUS
 */
public class ServicesProduit implements I_produit{
      Connection cnx= Maconnexion.getInstance().getCnx();
     
    @Override
    public boolean ajouterProduit(Produit p) {
        String request = "INSERT INTO `produit`(`nomp`, `prix`, `idcateg`) VALUES ('"+p.getNomp()+"',"+p.getPrix()+","+p.getIdcateg()+")";
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
    public List<Produit> afficherProduits() {
       List<Produit> produits = new ArrayList<Produit>();

        String req="SELECT * FROM produit";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                produits.add(new Produit(rs.getInt("idp"),rs.getString("nomp"),rs.getFloat("prix"),rs.getInt("idcateg")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    return produits;
    }

    @Override
    public boolean modifierProduit(Produit p) {
         String req = "UPDATE `produit` SET `nomp`='"+p.getNomp()+"',`prix`="+p.getPrix()+",`idcateg`="+p.getIdcateg()+" WHERE idp = "+p.getIdp()+" ";
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
    public boolean supprimerProduit(Produit p) {
        
        String req = "DELETE FROM `produit` WHERE idp = "+p.getIdp()+" ";

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
    public List<Produit> trierProduit() {
         
         List<Produit> produits =afficherProduits();
         List<Produit> sortedProduit =produits.stream().sorted(Comparator.comparing(Produit::getPrix)).collect(Collectors.toList());
         return sortedProduit;
     }

    @Override
    public List<Produit> chercherProduit(List<Produit> initialList, String input) {
        
         List<Produit> prodList;
          prodList = initialList.stream()
                  .map( Produit::concat )
                  .filter(pt -> pt.toLowerCase().contains(input.toLowerCase()))
                  .map(pt -> new Produit(Integer.parseInt(pt.split(".@.")[0]),pt.split(".@.")[1],Float.parseFloat(pt.split(".@.")[2]),Integer.parseInt(pt.split(".@.")[3])))
                  .collect( Collectors.toList() );
        
        return prodList;
    }
    
    
    
    
    
    }




    
    
      
   
    

