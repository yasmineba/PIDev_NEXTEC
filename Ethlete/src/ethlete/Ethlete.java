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
import services.ServiceIntervenant;

public class Ethlete {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Intervenant I = new Intervenant("Ben Abda","Yasmine","Sponsor","benabda@gmail.com",27156643);
        // SERVICE
        ServiceIntervenant si = new ServiceIntervenant();

        // AJOUT PERSONNE
        //System.out.println(si.ajouterIntervenant(I));
        // AFFICHER PERSONNES
       //System.out.println(si.afficherIntervenant());
        // MODIFIER
        Intervenant I1 = new Intervenant(3,"Maalej", "Walid","invite","maalej@gmail.com",554466245);
        System.out.println("Update\n");
        System.out.println(si.modifierIntervenant(I1));
        
        //SUPPRIMER
        System.out.println("Delete");
        System.out.println(si.supprimerIntervenant(I1));
        
        
        // Evenement E = new Evenement("league",to_date('2/10/2022','DD/MM/YYYY'),to_date('5/10/2022','DD/MM/YYYY'),"competition");


    }
    
}
