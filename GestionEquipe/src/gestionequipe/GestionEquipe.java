/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionequipe;

import gestionequipe.Service.ServiceEquipe;
import gestionequipe.Service.ServiceInvitation;
import gestionequipe.entity.Equipe;
import gestionequipe.entity.Invitation;

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
        
        Equipe u=new Equipe(1920,"lefriki",1);
        us.ajouter(u);
        ServiceInvitation ss=new ServiceInvitation();
        ss.ajouter(new Invitation("",1924,1));
    }
    
}
