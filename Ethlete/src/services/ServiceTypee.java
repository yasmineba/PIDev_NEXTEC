/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.I_typee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Intervenant;
import models.Typee;

/**
 *
 * @author 21624
 */
public class ServiceTypee implements I_typee{
    Connection cnx = utils.MaConnexion.getInstance().getCnx();

    @Override
    public boolean ajouterTypee(Typee T) {
  String request ="INSERT INTO `typee`(`nom_type`) VALUES ('"+T.getNom_type()+"' )";
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
    public List<Typee> afficherTypee() {
 List<Typee> typees = new ArrayList<Typee>();

        String req="SELECT * FROM typee";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                typees.add(new Typee(rs.getInt("id_type"),rs.getString("nom_type")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return typees;    }

    @Override
    public boolean modifierTypee(Typee T) {
         String req = "UPDATE `typee` SET `nom_type`='"+T.getNom_type()+"' WHERE id_type = "+T.getId_type()+"";
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
    public boolean supprimerTypee(Typee T) {
String req = "DELETE FROM `typee` WHERE id_type = "+T.getId_type()+" ";

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
