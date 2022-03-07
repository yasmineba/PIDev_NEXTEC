/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ethlete;
import models.Intervenant;
import models.Evenement;
import services.ServiceEvenement;

/**
 *
 * @author 21624
 */

import javax.xml.ws.Service;
import java.sql.Connection;
import models.Billet;
import services.ServiceBillet;
import services.ServiceIntervenant;


public class Ethlete {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       /* Typeinter Ti = new Typeinter("sponsor");
        // SERVICE
        ServiceTypeint st = new ServiceTypeint();
        System.out.println(st.ajouterTypeinter(Ti));
        System.out.println(st.afficherTypeinter());
        
        Typeinter Ti1 = new Typeinter("president");
        System.out.println(st.modifierTypeinter(Ti1));
        System.out.println(st.supprimerTypeinter(Ti1));

        
        Intervenant I = new Intervenant("Ben Abda","Yasmine","benabda@gmail.com",27156643,2);
        // SERVICE
       ServiceIntervenant si = new ServiceIntervenant();

        // AJOUT INTERVENANT
        System.out.println(si.ajouterIntervenant(I));
        // AFFICHER INTERVENANT
         System.out.println(si.afficherIntervenant());
        // MODIFIER INTERVENANT
       Intervenant I1 = new Intervenant(0,"Maalej", "Walid","maalej@gmail.com",554466245,2);
        System.out.println("Update\n");
        System.out.println(si.modifierIntervenant(I1));
        
        //SUPPRIMER
        System.out.println("Delete");
       System.out.println(si.supprimerIntervenant(I1));
        
      
       
       Typee T = new Typee("comp");
       ServiceTypee sty = new ServiceTypee();
        //System.out.println(sty.ajouterTypee(T));
        System.out.println(sty.afficherTypee());
        Typee T1 = new Typee("compettt");
         System.out.println(sty.modifierTypee(T1));
         System.out.println(sty.supprimerTypee(T1));

        
         
        Evenement E = new Evenement("league","2020-10-2","2020-10-3",1,2,1,1);
         ServiceEvenement se = new ServiceEvenement();

       // System.out.println(se.ajouterEvenement(E));
         */
       
       ServiceIntervenant si = new ServiceIntervenant();
        System.out.println(si.sortByNom());

       
      // Billet B = new Billet(2,6,(float) 4.5,"");
        ServiceBillet sb = new ServiceBillet();

  //      System.out.println(sb.ajouterBillet(B));
           

        // SERVICE
      // ServiceIntervenant si = new ServiceIntervenant();
        //System.out.println(si.afficherIntervenant());
        //System.out.println(si.rechercherIntervenant(si.afficherIntervenant(), "qdkjhqskjdhqskjdsq"));
       
    }
    
}
