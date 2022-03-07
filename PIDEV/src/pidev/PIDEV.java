/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import com.pidev.models.Formation;
import com.pidev.models.Participation;
import com.pidev.models.Utilisateur;
import com.pidev.servicesImp.ServiceAffectationFormateur;
import com.pidev.servicesImp.ServiceFormateur;
import com.pidev.servicesImp.ServiceFormation;
import com.pidev.servicesImp.ServiceParticipation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author pc
 */
public class PIDEV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServiceFormation s=new ServiceFormation() ;
        Formation f=new Formation(2,"form2",Date.valueOf("2012-02-02"),Date.valueOf("2012-02-02"),"En_Ligne","moatez111111111111111111111111111");
       s.ajouter(f);
        
        /*Utilisateur u=new Utilisateur(1,"","","","","","","","ROLE_FORMATEUR","ROLE_FORMATEUR");
       
 ServiceAffectationFormateur d1=new ServiceAffectationFormateur();
 d1.affectation_formateur(f,u);

        ServiceParticipation s1=new ServiceParticipation();
        s1.Participer_Une_Formation(f, u);
 
      */
    
// ServiceAffectationFormateur d1=new ServiceAffectationFormateur();
 //System.out.print(d1.consulter_toutes_affectation1(1));
ServiceParticipation s1= new ServiceParticipation();
//ServiceFormation sf=new ServiceFormation();
//System.out.println(s1.consulter_particiapnts_par_formation());
//Formation f=sf.consulter_formation(3);
//System.out.print(f.toString());
//System.out.println(s1.consulter_particiapnts_par_formation().keySet());

//s1.fichier_participation();
             // Map<Integer, List<Participation>> map=s1.afficher().stream().collect(Collectors.groupingBy(e -> e.getFormation_id()));
              //System.out.println(map);
 //ServiceAffectationFormateur d1=new ServiceAffectationFormateur();
//System.out.println(d1.consulter_formateurs_par_formation());
 //s1.imprimer_liste_participant_par_form();


    }
    
}
