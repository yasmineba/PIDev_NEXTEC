/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.servicesImp;

import Utils.DataSource;
import com.pidev.models.AffectationFormateur;
import com.pidev.models.Formation;
import com.pidev.models.Participation;
import com.pidev.models.Reponse_Form;
import com.pidev.models.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.NoArgsConstructor;

/**
 *
 * @author pc
 */
@NoArgsConstructor
public class ServiceAffectationFormateur {
    Connection cnx = DataSource.getInstance().getCnx();
    ServiceReponseImp serR=new ServiceReponseImp();

    public void affectation_formateur(Formation f  , Utilisateur u){
        
        
         try {
Reponse_Form rep=serR.consulter_rep_non_cons();
             
             
            String req = "INSERT INTO affectation_formateur (formateur_id,formation_id,reponse) VALUES (?,?,?)";
                                PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, u.getId());
                       pst.setInt(2,f.getId_formation());
                       
                       pst.setInt(3,rep.getId_reponse());

            pst.executeUpdate();
            System.out.println("Formation "+f.getNom_formation()+"attribuée à  !"+u.getNom());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
    
    public void annuler_toute_affectation(Utilisateur f)
    {try {
             String req = "DELETE FROM affectation_formateur WHERE formateur_id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,f.getId());
            pst.executeUpdate();
            System.out.println("Affectation supprimée de  !"+f.getNom());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
      public void annuler_affectation_précise(Utilisateur f,Formation f1)
    {try {
             String req = "DELETE FROM affectation_formateur WHERE formateur_id=? and formation_id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,f.getId());            pst.setInt(1,f1.getId_formation());

            pst.executeUpdate();
            System.out.println("Affectation supprimée de  !"+f.getNom());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     /*  public List<Formation> consulter_toutes_affectation(int id_formateur) {
           List<Formation> list = new ArrayList<>();
        
        
        try{    String req = "SELECT id_formation,nom_formation,date_debut,date_fin,type FROM formation where id_formation in (select formation_id"
                + "from affectation_formateur where formateur_id=?) ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,id_formateur);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Formation(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
                
            
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;    }*/
          public void modifier_affectation(AffectationFormateur a,int id_formateur)
          {
         try {
            String req = "UPDATE affectation_formateur SET formateur_id=? WHERE formation_id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, id_formateur);
            pst.setInt(2, a.getFormation_id());
            pst.executeUpdate();
            System.out.println("Affectation modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }}
       
          public void accpter_affectation(Utilisateur f,Formation f1)
          {  
        String s="confirmé";
        
            
              
              try {                Reponse_Form rep=serR.consulter_rep_accep();


              
            String req = "UPDATE affectation_formateur SET reponse=? WHERE formation_id=? and formateur_id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,rep.getId_reponse());
            pst.setInt(2, f1.getId_formation());
              pst.setInt(2, f.getId());
            pst.executeUpdate();
            System.out.println("Affectation modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
          }
             public void refuser_affectation(Utilisateur f,Formation f1)
          {  String s="refusé";
        
            
              
              try {            Reponse_Form rep=serR.consulter_rep_ref();
                  
            String req = "UPDATE affectation_formateur SET reponse=? WHERE formation_id=? and formateur_id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,rep.getId_reponse());
            pst.setInt(2, f1.getId_formation());
              pst.setInt(2, f.getId());
            pst.executeUpdate();
            System.out.println("Affectation modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
          }
             
             public AffectationFormateur ConsulterAffectation_precise(Utilisateur f,Formation f1)
             {AffectationFormateur AF=new AffectationFormateur() ;
         try{    String req = "SELECT * FROM affectation_formateur where formation_id=? and formateur_id=?  ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,f1.getId_formation());
                        pst.setInt(2,f.getId());

            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
            AF=   new AffectationFormateur(rs.getInt(1),rs.getInt(1),rs.getInt(1));
                
            
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }     
             return AF;
             }
    public List<AffectationFormateur> afficher() {
List<AffectationFormateur> list = new ArrayList<>();
        
        
        try{    String req = "SELECT * FROM affectation_formateur ";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new AffectationFormateur(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
                
            
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;    }    
    public   Map<Integer, List<AffectationFormateur>> formateur_par_Affectaion()
     // Retourner une Map qui regroupe les affectations par formation
    {  
        
        
        Map<Integer, List<AffectationFormateur>> map = this.afficher().stream().collect(Collectors.groupingBy(e -> e.getFormation_id()));
return map;
    }
    
    
    
      public Map<Formation, List<Utilisateur>> consulter_formateurs_par_formation()
              {ServiceFormateur sf1=new ServiceFormateur();
             Map<Integer, List<AffectationFormateur>> map=this.formateur_par_Affectaion();
            Map<Formation, List<Utilisateur>> map1=new HashMap();
                       ServiceFormation sf=new ServiceFormation();


            for(Integer x:map.keySet())
            {
                  List<Utilisateur> list = new ArrayList<>();
                for(int i=0;i<map.get(x).size();i++)
                
            {list.add(sf1.findbyId(map.get(x).get(i).getFormateur_idt()));}
                    
            map1.put(sf.consulter_formation(x),list);}
            
             
             return map1;
              }
    
    
    
    
    
    
    
    
    
    
    
 public List<Formation> consulter_toutes_affectation1(int id_formateur)    
         
 {           List<Formation> list = new ArrayList<>();
 Formation f4=new Formation();
  List<Integer> formations_id=this.afficher().stream().filter(e->e.getFormateur_idt()==id_formateur).map(f->f.getFormation_id()).collect(Collectors.toList());
  ServiceFormation sf=new ServiceFormation();
 for (int i=0;i<formations_id.size();i++)
     
 {  int s=formations_id.get(i);
     
     Formation get = sf.afficher().stream().filter(e -> e.getId_formation() == s).findFirst().get();
     list.add(get);
     
     
 }

 return list;
 }
     public AffectationFormateur ConsulterAffectation_precise1(Utilisateur f,Formation f1)
     {AffectationFormateur AF=new AffectationFormateur() ;
     AF=this.afficher().stream().filter(e->e.getFormateur_idt()==f.getId()).filter(e->e.getFormation_id()==f1.getId_formation()).findFirst().get();
     return AF;
     }
      public List<Utilisateur> consulter_toutes_affectation2(int id_formation)
      {ServiceFormateur sf=new ServiceFormateur();
       List<Utilisateur> list = new ArrayList<>();
      List<Integer> ListFormateurs=this.afficher().stream().filter(e->e.getFormation_id()==id_formation).map(f->f.getFormateur_idt()).collect(Collectors.toList());
     
      for(Integer x:ListFormateurs)
      {int s=x;
      Utilisateur formateur=sf.afficher().stream().filter(e -> e.getId()== s).findFirst().get();
      list.add(formateur);
      }
      return list;
      }
      
      
      public List<Formation> filtrer_formations_no_consulté()
      {
       
        
       
             Reponse_Form rep=serR.consulter_rep_non_cons();
             List<Formation> list = new ArrayList<>();
 Formation f4=new Formation();
  List<Integer> formations_id=this.afficher().stream().filter(e->e.getReponse()==rep.getId_reponse()).map(f->f.getFormation_id()).collect(Collectors.toList());

  ServiceFormation sf=new ServiceFormation();

         for (int i=0;i<formations_id.size();i++)
     
 {  int s=formations_id.get(i);
     
     Formation get = sf.afficher().stream().filter(e -> e.getId_formation() == s).findFirst().get();
     list.add(get);
     
     
 }

 return list;}
      
      

     
       }
   
    
    