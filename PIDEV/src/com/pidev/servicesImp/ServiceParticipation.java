/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.servicesImp;

import Utils.DataSource;
import com.pidev.models.AffectationFormateur;
import com.pidev.models.Formation;
import com.pidev.models.Impression;
import com.pidev.models.Participation;
import com.pidev.models.Utilisateur;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileWriter;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import lombok.NoArgsConstructor;

/**
 *
 * @author pc
 */@NoArgsConstructor

public class ServiceParticipation {
      Connection cnx = DataSource.getInstance().getCnx();
    public void Participer_Une_Formation(Formation f  , Utilisateur u){
        
         try {
            String req = "INSERT INTO participation (id_participant,formation_id,date_participation) VALUES (?,?,?)";
                                PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, u.getId());
                       pst.setInt(2,f.getId_formation());
                            Date d=new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/YYYY" );

                           pst.setString(3,df.format(d));

            pst.executeUpdate();
            System.out.println("Participation ajoutée !"+u.getNom());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
    
    public void annuler_participation_précise(Utilisateur f,Formation f1)
    {try {
             String req = "DELETE FROM participation WHERE id_participant=? and formation_id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,f.getId());            pst.setInt(1,f1.getId_formation());

            pst.executeUpdate();
            System.out.println("Participation supprimée de  !"+f.getNom());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
       public List<Utilisateur> consulter_participants(Formation f) {
           List<Utilisateur> list = new ArrayList<>();
        
        
        try{    String req = "SELECT * FROM utilisateur where id in (select id_participant"
                + "from participation where formation_id=?) ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,f.getId_formation());
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)
                ,rs.getString(7)));
                
            
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;    }
       public int nb_participant(Formation f)
       {return this.consulter_participants(f).size();
       }
         public List<Formation> consulter_formation(Utilisateur f) {
           List<Formation> list = new ArrayList<>();
        
        
        try{    String req = "SELECT * FROM formation where id_formation in (select formation_id"
                + "from participation where id_participant=?) ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,f.getId());
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Formation(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getString(6)));
                
            
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }return list;
         }
         
         
             public List<Participation> afficher() {
List<Participation> list = new ArrayList<>();
        
        
        try{    String req = "SELECT * FROM participation ";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Participation(rs.getInt(1),rs.getInt(2),rs.getString(3)));
                
            
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;    }
             
             
              public List<Formation> consulter_formations_Part(Utilisateur f) {
           List<Formation> list = new ArrayList<>();
           ServiceFormation sf=new ServiceFormation();
                List<Integer> formations_id=this.afficher().stream().filter(e->e.getId_participant()==f.getId()).map(q->q.getFormation_id()).collect(Collectors.toList());
for (Integer x: formations_id)
{list.add(sf.consulter_formation(x));
}
return list;
              }
              
              
              public Map<Formation, List<Utilisateur>> consulter_particiapnts_par_formation()
              {ServiceFormateur sf1=new ServiceFormateur();
             Map<Integer, List<Participation>> map=this.afficher().stream().collect(Collectors.groupingBy(e -> e.getFormation_id()));
            Map<Formation, List<Utilisateur>> map1=new HashMap();
                       ServiceFormation sf=new ServiceFormation();


            for(Integer x:map.keySet())
            {
                  List<Utilisateur> list = new ArrayList<>();
                for(int i=0;i<map.get(x).size();i++)
                
            {list.add(sf1.findbyId(map.get(x).get(i).getId_participant()));}
                    
            map1.put(sf.consulter_formation(x),list);}
            
             
             return map1;
              }
              public List<Participation> trier_par_date()
              {
              return this.afficher().stream()
                       .sorted((a, b) -> a.getDate_participation().compareTo(b.getDate_participation()))
               .collect(Collectors.toList());}
               
              
              public void fichier_participation()
         { Map<Formation, List<Utilisateur>> map1=new HashMap();
map1=this.consulter_particiapnts_par_formation();
 try{              FileWriter fw=new FileWriter("C:\\Users\\pc\\OneDrive\\Bureau\\partParform.txt");    
fw.write("Bienvenue \n");
     
     for(Formation e:map1.keySet())
       
     
     {    fw.write("\n La formation "+e.toString());
       fw.write("\n La liste des participants à cette formation \n ");
          for (int i=0;i<map1.get(e).size();i++)
            fw.write("\nParticipant:  "+(i+1)+"  "+map1.get(e).get(i));

       
              }fw.close(); 
          }catch(Exception e){System.out.println(e);}    
          System.out.println("Success...");             
         }
           
          public void imprimer_liste_participant_par_form()
        {
          PrinterJob job = PrinterJob.getPrinterJob();
      HashPrintRequestAttributeSet printRequestSet = new HashPrintRequestAttributeSet();
      
      printRequestSet.add(OrientationRequested.LANDSCAPE);
     Impression i= new Impression();
      job.setPrintable(new Impression());
      if (job.printDialog(printRequestSet)){
         try {
            job.print();
            
         } catch (PrinterException ex) {
            ex.printStackTrace();
         }
      }
        }
         
}
