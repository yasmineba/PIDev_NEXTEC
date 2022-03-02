  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionequipe;

import services.ServiceAvis;
import services.ServiceEquipe;
import services.ServiceInvitation;
import models.Equipe;
import models.Invitation;

/**
 *
 * @author anasl
 */
public class GestionEquipe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServiceEquipe us=new ServiceEquipe();
        
        Equipe u=new Equipe("lefriki",1);
       // us.ajouter(u);
        ServiceAvis ss=new ServiceAvis();
                ServiceAvis ss1=new ServiceAvis();
       // System.out.println(us.paginateEquipes(1, 1));
        System.out.println(ss.afficher());
        //System.out.println(ss1.sortBynote());
    
    }
    
}
