/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import static interfaces.I_commande.cnx;
import interfaces.I_reclamation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import models.Commande;
import models.Reclamation;

/**
 *
 * @author ASUS
 */
public class ServicesReclamation implements I_reclamation {

    @Override
    public boolean ajouterReclamation(Reclamation r) {
       String request = "INSERT INTO `reclamation`(`contenu`,`id`,`daterec`) VALUES ('"+r.getContenu()+"',"+r.getId()+",NOW())";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(request) == 1)
                    return true;
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
    }

    @Override
    public List<Reclamation> afficherReclamations() {
      List<Reclamation> reclamations = new ArrayList<Reclamation>();
       String req="SELECT * FROM reclamation";
       
         try {
             Statement st = cnx.createStatement();
             
             ResultSet rs = st.executeQuery(req);
             while (rs.next())
             {
                Reclamation r = new Reclamation (rs.getInt("idr"),rs.getString("contenu"),rs.getInt("id"),rs.getString("daterec"));
                reclamations.add(r);
                
                
             }
             
             
         } catch (SQLException ex) {
             ex.printStackTrace();// twarik mochkla win//
         }
         return reclamations;
            }

    @Override
    public boolean modifierReclamation(Reclamation r) {
        String req = "UPDATE `reclamation` SET `contenu`='"+r.getContenu()+"',`id`="+r.getId()+",`daterec`='"+r.getDaterec()+"' WHERE idr = "+r.getIdr()+" ";
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
    public boolean supprimerReclamation(Reclamation r) {
        String req = "DELETE FROM `reclamation` WHERE idr = "+r.getIdr()+" ";

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
     public int nombreReclamation(){
      String sql="SELECT COUNT(*) FROM reclamation";
        ResultSet rs;
        int countIdFed=0;
        try {
            PreparedStatement st= cnx.prepareStatement(sql);
			ResultSet res= st.executeQuery(); 
                        while(res.next()) {
                           countIdFed= res.getInt(1);
                        }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return countIdFed;
     }

   
    
     
      
     
}

