/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ethlete;

import java.sql.Connection;
import models.Categorie;
import models.Commande;
import models.Fournisseur;
import models.Produit;
import models.Reclamation;
import services.ServicesCategorie;
import services.ServicesCommande;
import services.ServicesFournisseur;
import services.ServicesProduit;
import services.ServicesReclamation;
import util.Maconnexion;

/**
 *
 * @author ASUS
 */
public class Ethlete {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CRUD FOURNISSEUR
     // Fournisseur f1 = new Fournisseur("Ben abda","Yasmine","benabda.yasmine@gmail.com",54749899,"AArgoub ezaater",5);
      ServicesFournisseur s = new ServicesFournisseur();
      //s.ajouterfournisseur(f1);  // ajouter
        
      
      //System.out.println(s.afficherFournisseurs()); // afficher
        
        
       Fournisseur f2 = new Fournisseur(1,"MEch matoussi","mech rihem","rihem.matoussi@esprit.tn",657687921,"mech aargoub",5);
        //System.out.println("Update\n");
        //System.out.println(s.modifierFournisseur(f2)); // modifier 
          
        
       // System.out.println("Delete");
        //System.out.println(s.supprimerFournisseur(f2));//
        
        
        //CRUD CATEGORIE//
        Categorie cg1 = new Categorie("accessoires");
       ServicesCategorie scg  = new ServicesCategorie();
      //scg.ajouterCategorie(cg1);  // ajouter
      
      
      //System.out.println(scg.afficherCategorie());
      
      Categorie cg2 = new Categorie(3,"Bureatique");
        //System.out.println("Updated succesfully \n");
       //System.out.println(scg.modifierCategorie(cg2)); // modifier 
       
       
       //System.out.println("Deleted successfully!");
       // System.out.println(scg.supprimerCategorie(cg2));
       
       
       //CRUD Produit
       ServicesProduit sp = new ServicesProduit();
       //Produit p1 = new Produit("bracelet",15,8);
      
       //sp.ajouterProduit(p1);  // ajouter
       
       
       //System.out.println(sp.afficherProduits());
       
         Produit p2 = new Produit(4,"necklace",78,7);
       //System.out.println("Updated succesfully \n");
      // System.out.println(sp.modifierProduit(p2)); // modifier 
      
      
      
        //System.out.println("Deleted successfully!");
      // System.out.println(sp.supprimerProduit(p2));
      
      //CRUD COMMANDE
      
       
       //Commande c1 = new Commande(7,23,"");
       //ServicesCommande sc  = new ServicesCommande();
       //sc.ajouterCommande(c1);  // ajouter
       
       
       
       //System.out.println(sc.afficherCommandes());
       
       //Commande c2 = new Commande(1,7,25,"2022-12-05");
      // System.out.println("Updated successfully ! \n");
      // System.out.println(sc.modifierCommande(c2)); // modifier 
      
      
      //System.out.println("Deleted successfully!");
     // System.out.println(sc.supprimerCommande(c2));
     
     
     
     //CRUD reclamation
       Reclamation r1 = new Reclamation("this app is awesome!",2,"");
       ServicesReclamation sr  = new ServicesReclamation();
       // sr.ajouterReclamation(r1);  // ajouter
      
      
       // System.out.println(sr.afficherReclamations());
      
         Reclamation r2 = new Reclamation(1,"this app is really aweseome!",2,"2022-12-05");
         System.out.println("Updated succesfully \n");
         //System.out.println(sr.modifierReclamation(r2)); // modifier 
       
       
       System.out.println("Deleted successfully!");
       System.out.println(sr.supprimerReclamation(r2));
     
      
     
     
      
       
       
       
       
       
      
      
      
      
      
      
      
      
      
    }
    
}
