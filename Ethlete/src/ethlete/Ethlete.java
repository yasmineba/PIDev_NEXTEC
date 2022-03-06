/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ethlete;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static jdk.nashorn.tools.ShellFunctions.input;
import models.Categorie;
import models.Commande;
import models.Fournisseur;
import models.Produit;
import models.Raison;
import models.Reclamation;
import services.ServicesCategorie;
import services.ServicesCommande;
import services.ServicesFournisseur;
import services.ServicesProduit;
import services.ServicesRaison;
import services.ServicesReclamation;
import util.Maconnexion;
import services.SendEmail;

/**
 *
 * @author ASUS
 */
public class Ethlete {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        
       // SendEmail.mailing("rmatoussi3@gmail.com","confirmation de paiement","hey rihem :)");
        
        
        
        
        
        //CRUD FOURNISSEUR
      //Fournisseur f1 = new Fournisseur("Ben abda","Yasmine","benabda.yasmine@gmail.com",54749899,"AArgoub ezaater",5);
      ServicesFournisseur sf = new ServicesFournisseur();
      
                        
      //s.ajouterfournisseur(f1);  // ajouter
       // System.out.println(sf.afficherFournisseurProduit());
        
      
      //System.out.println(s.afficherFournisseurs()); // afficher
        
        
       Fournisseur f2 = new Fournisseur(1,"MEch matoussi","mech rihem","rihem.matoussi@esprit.tn",657687921,"mech aargoub",5);
        //System.out.println("Update\n");
        //System.out.println(s.modifierFournisseur(f2)); // modifier 
          
        
       // System.out.println("Delete");
        //System.out.println(s.supprimerFournisseur(f2));//
        
        
        //CRUD CATEGORIE//
       
    
         //ServicesRaison rs=new ServicesRaison();
        // System.out.println(rs.afficherRaisons());
                 
        
        
        
      
        
       
        //Categorie cg1 = new Categorie("accessoires");
       //ServicesCategorie scg  = new ServicesCategorie();
      //scg.ajouterCategorie(cg1);  // ajouter\
        //System.out.println(scg.getidcateg("Accessoires"));
      
         
        //System.out.println(scg.afficherCategorie());
      
      
      
         //System.out.println(cg1.getNomcateg());
         //categories.stream().filter(t->t.getName().charAt(0)=='s').sorted((p1,p2)->p1.getSalary()-p2.getSalary()).forEach(t->System.out.print(t));
      
      /*Categorie cg2 = new Categorie("Bureatique");
        System.out.println("Updated succesfully \n");
       System.out.println(scg.modifierCategorie(cg2)); // modifier*/
       
       
       //System.out.println("Deleted successfully!");
       // System.out.println(scg.supprimerCategorie(cg2));
       
       
       //CRUD Produit
       ServicesProduit sp = new ServicesProduit();
        System.out.println(sp.afficherProduitCateg());
       //Produit p1 = new Produit("haja",15,7);
      
       //sp.ajouterProduit(p1);  // ajouter
       
       
      // System.out.println(sp.getidcprod("yasmine"));
       
        Produit p2 = new Produit(1,"necklace",78,8);
       //System.out.println("Updated succesfully \n");
       //System.out.println(sp.modifierProduit(p2)); // modifier
       
      
      
      
       // System.out.println("Deleted successfully!");
       // System.out.println(sp.supprimerProduit(p2));
       //System.out.println(sp.trierProduit());
        
        
        
        
      
      //CRUD COMMANDE
      
       
       //Commande c1 = new Commande(8,25,"");
       //ServicesCommande sc  = new ServicesCommande();
       //sc.ajouterCommande(c1);  // ajouter
        //System.out.println(sc.trierCommandeProduit());
       
       
       //System.out.println(sc.afficherCommandeProduit());
       
       //Commande c2 = new Commande(1,7,25,"2022-12-05");
      // System.out.println("Updated successfully ! \n");
      // System.out.println(sc.modifierCommande(c2)); // modifier 
      
      
      //System.out.println("Deleted successfully!");
     // System.out.println(sc.supprimerCommande(c2));
     
     
     
     //CRUD reclamation
      Reclamation r2 = new Reclamation(12,"this app is awesome!",10,"2022-03-22",13,"termine");
      ServicesReclamation sr  = new ServicesReclamation();
       //sr.modifierReclamation(r2);  // ajouter
       
        System.out.println(sr.nombreReclamation());
      
      
        //System.out.println(sr.afficherReclamationUser());
      
         //Reclamation r2 = new Reclamation(1,"this app is really aweseome!",2,"2022-12-05",4);
         //System.out.println("Updated succesfully \n");
         //System.out.println(sr.modifierReclamation(r2)); // modifier 
       
       
       //System.out.println("Deleted successfully!");
      // System.out.println(sr.supprimerReclamation(r2));
       
       
       //System.out.println("liste categories triee");
       //System.out.println(scg.trierCategorie());
            
        // System.out.println(sc.chercherCommande(sc.afficherCommandes(),""));
           //System.out.println(sc.trierCommande());
           
           
           
           
          //ServicesFournisseur serf= new ServicesFournisseur();
          //System.out.println(sf.trierFournisseurProduit());
          //System.out.println(sf.chercherFournisseurPorduit("rihem"));
           
          
          //Raison rz1= new Raison("i cannot change my password");
          ServicesRaison srz = new ServicesRaison();
          //Raison rz2= new Raison(1,"i cannot change my username");
          //System.out.println(srz.afficherNomRaison());
          
          ServicesCategorie sc=new  ServicesCategorie();
          //System.out.println(sc.afficherNomCategorie());
          
           //System.out.println(srz.getidraison("something"));
           
           //System.out.println(srz.chercherRaison(srz.afficherRaisons(),"password"));
          
          
     
      
     
       
    
       
       
      
      
      
      
      
      
     
      
      
    }

   
    
}
