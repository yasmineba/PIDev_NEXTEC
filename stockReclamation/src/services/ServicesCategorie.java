/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.I_categorie;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Categorie;
import util.Maconnexion;

/**
 *
 * @author ASUS
 */
public class ServicesCategorie implements I_categorie{
 Connection cnx= Maconnexion.getInstance().getCnx();
    @Override
    public boolean ajouterCategorie(Categorie cg) {
        String request = "INSERT INTO `categorie`(`nomcateg`) VALUES ('"+cg.getNomcateg()+"')";
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
    public List<Categorie> afficherCategorie() {
        List<Categorie> categories = new ArrayList<Categorie>();

        String req="SELECT * FROM categorie";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
               categories.add(new Categorie(rs.getInt("idcateg"),rs.getString("nomcateg")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return categories;
    }

    @Override
    public boolean modifierCategorie(Categorie cg) {
        String req = "UPDATE `categorie` SET `nomcateg`='"+cg.getNomcateg()+"' WHERE idcateg = "+cg.getIdcateg()+" ";
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
    public boolean supprimerCategorie(Categorie cg) {
        String req = "DELETE FROM `categorie` WHERE idcateg = "+cg.getIdcateg()+" ";

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
