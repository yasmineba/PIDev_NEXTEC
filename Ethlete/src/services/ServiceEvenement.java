/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import interfaces.I_evenement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import models.Evenement;
import util.DataSource;

/**
 *
 * @author 21624
 */
public class ServiceEvenement implements I_evenement{
     //var
    Connection cnx = DataSource.getInstance().getCnx();

    
    @Override
    public boolean ajouterEvenement(Evenement t) {
         String request;
                PreparedStatement pst=null;

      // request = "INSERT INTO `evenement`(`nom_event`, `date_debut`, `date_fin`,  `id_typeE` , `id_formation` ,`id_inter` ,`id_compet` ) VALUES ('"+E.getNom_event()+"',"+E.getDate_debut()+","+E.getDate_fin()+",'"+E.getTypeE()+"',"+E.getId_formation()+","+E.getId_inter()+" ,"+null+")";
      
        
        
        try {
            String req1;
     
   if(t.getTypeE().equals("Formation"))
   {
       req1 = "INSERT INTO evenement (nom_event,date_debut,date_fin,id_typeE,id_formation,id_inter) VALUES (?,?,"
                    + "?,?,?,?)";
        pst = cnx.prepareStatement(req1); 
       pst.setString(1,t.getNom_event());

              pst.setDate(2,   t.getDate_debut());          
            pst.setDate(3,   t.getDate_fin());

            pst.setString(4, t.getTypeE());
            pst.setInt(5,t.getId_formation());
                        pst.setInt(6,t.getId_inter());
   
   }
   else 
   {  req1 = "INSERT INTO evenement (nom_event,date_debut,date_fin,id_typeE,id_compet,id_inter) VALUES (?,?,"
                    + "?,?,?,?)";
        pst = cnx.prepareStatement(req1); 
       pst.setString(1,t.getNom_event());

              pst.setDate(2,   t.getDate_debut());          
            pst.setDate(3,   t.getDate_fin());

            pst.setString(4, t.getTypeE());
            pst.setInt(5,t.getId_compet());
                        pst.setInt(6,t.getId_inter());

   }
    pst.executeUpdate();
System.out.println("Evenement ajouté");
          
           
           
                                       return true;


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<Evenement> afficherEvenement() {

        
        List<Evenement> evenements = new ArrayList<Evenement>();

        String req="SELECT * FROM evenement";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                evenements.add(new Evenement(rs.getInt("id_event"),rs.getString("nom_event"),rs.getDate("date_debut"),rs.getDate("date_fin"),rs.getString("id_typeE"),rs.getInt("id_formation"),rs.getInt("id_inter"),rs.getInt("id_compet")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return evenements;    }

    @Override
    public boolean modifierEvenement(Evenement E) {

           String req = "UPDATE `evenement` SET `nom_event`='"+E.getNom_event()+"',`date_debut`='"+E.getDate_debut()+"',`date_fin`='"+E.getDate_fin()+"',`id_typeE`='"+E.getTypeE()+"',`id_inter`="+E.getId_inter()+" WHERE id_event = "+E.getId_event()+" ";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1)
                return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean supprimerEvenement(Evenement E) {
   String req = "DELETE FROM `evenement` WHERE id_event = "+E.getId_event()+" ";

        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1)
                return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    }


   


