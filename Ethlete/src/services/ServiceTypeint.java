/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.I_typeinter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Typee;
import models.Typeinter;

/**
 *
 * @author 21624
 */
public class ServiceTypeint implements I_typeinter {
        Connection cnx = utils.MaConnexion.getInstance().getCnx();

    @Override
    public boolean ajouterTypeinter(Typeinter Ti) {
 String request ="INSERT INTO `typeinter`(`type`) VALUES ('"+Ti.getType()+"' )";
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
    public List<Typeinter> afficherTypeinter() {
List<Typeinter> typeinters = new ArrayList<Typeinter>();

        String req="SELECT * FROM typeinter";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                typeinters.add(new Typeinter(rs.getInt("id_typeint"),rs.getString("type")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return typeinters;     }

    @Override
    public boolean modifierTypeinter(Typeinter Ti) {
 String req = "UPDATE `typeinter` SET `type`='"+Ti.getType()+"' WHERE id_typeint = "+Ti.getId_typeint()+"";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1)
                return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }    }

    @Override
    public boolean supprimerTypeinter(Typeinter Ti) {
String req = "DELETE FROM `typeinter` WHERE id_typeint = "+Ti.getId_typeint()+" ";

        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1)
                return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }        }

    
}
