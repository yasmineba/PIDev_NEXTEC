/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import interfaces.I_evenement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import models.Evenement;

/**
 *
 * @author 21624
 */
public class ServiceEvenement implements I_evenement{
     //var
    Connection cnx = utils.MaConnexion.getInstance().getCnx();

    @Override
    public boolean ajouterEvenement(Evenement E) {
        String request = "INSERT INTO `evenement`(`nom_event`, `date_debut`, `date_fin`, `type`) VALUES ('"+E.getNom_event()+"',"+E.getDate_debut()+","+E.getDate_fin()+",'"+E.getType()+"')";
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
    public List<Evenement> afficherEvenement() {

        
        List<Evenement> evenements = new ArrayList<Evenement>();

        String req="SELECT * FROM evenement";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                evenements.add(new Evenement(rs.getInt("id_event"),rs.getString("nom_event"),rs.getDate("date_debut"),rs.getDate("date_fin"),rs.getString("type")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return evenements;    }

    @Override
    public boolean modifierEvenement(Evenement E) {

           String req = "UPDATE `evenement` SET `nom_event`='"+E.getNom_event()+"',`date_debut`='"+E.getDate_debut()+"',`date_fin`="+E.getDate_fin()+",`type`='"+E.getType()+"' WHERE id = "+E.getId_event()+" ";
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
   String req = "DELETE FROM `evenement` WHERE id = "+E.getId_event()+" ";

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


   


