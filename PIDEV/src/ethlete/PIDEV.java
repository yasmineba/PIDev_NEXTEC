/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ethlete;

import models.Formation;
import models.Participation;
import models.Utilisateur;
import services.ServiceAffectationFormateur;
import services.ServiceFormateur;
import services.ServiceFormation;
import services.ServiceParticipation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import models.AffectationFormateur;
import models.Reponse_Form;
import services.ServiceReponseImp;

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
        //ServiceFormation s=new ServiceFormation() ;
       // Formation f=new Formation(2,"form2",Date.valueOf("2012-02-02"),Date.valueOf("2012-02-02"),"En_Ligne","moatez111111111111111111111111111");
       //s.generer_pdf(f);
       // s.ajouter(f);
       // 
       
 /*ServiceAffectationFormateur d1=new ServiceAffectationFormateur();
 d1.affectation_formateur(f,u);

      
 
      */
 ServiceParticipation sp=new ServiceParticipation();
   
int nbh=0;
        int nbf=0;
                 Map<Formation,List<Utilisateur>> map1=new HashMap();
                 System.out.println(sp.consulter_particiapnts_par_formation().keySet());

   
 /*Formation f=new Formation(9);
List <Utilisateur> list=map1.get(f);
 for(Formation c:map1.keySet())
 System.out.println(map1.get(c));
  Utilisateur u=new Utilisateur(7);*/
 
 /*     ServiceParticipation s1=new ServiceParticipation();
        s1.Participer_Une_Formation(f, u);*/
           /*      ServiceReponseImp sr=new ServiceReponseImp();
ServiceAffectationFormateur af=new ServiceAffectationFormateur();
 AffectationFormateur rf = af.ConsulterAffectation_precise1(u, f);
 //System.out.print(rf.toString());
 ServiceReponseImp srr=new ServiceReponseImp();
 srr.consulter_rep(rf.getReponse());
 for(Formation c:map1.keySet())
 System.out.println(map1.get(c));*/


 
// ServiceAffectationFormateur d1=new ServiceAffectationFormateur();
 //System.out.print(d1.consulter_toutes_affectation1(1));
//ServiceParticipation s1= new ServiceParticipation();
//ServiceFormation sf=new ServiceFormation();
//System.out.println(s1.consulter_particiapnts_par_formation());
//Formation f=sf.consulter_formation(3);
//System.out.print(f.toString());
//System.out.println(s1.consulter_particiapnts_par_formation().keySet());

//s1.fichier_participation();
             // Map<Integer, List<Participation>> map=s1.afficher().stream().collect(Collectors.groupingBy(e -> e.getFormation_id()));
              //System.out.println(map);
 //ServiceAffectationFormateur d1=new ServiceAffectationFormateur();
 //d1.affectation_formateur(f, u);
//System.out.println(d1.consulter_formateurs_par_formation());
 //s1.imprimer_liste_participant_par_form();


    }
    
}
