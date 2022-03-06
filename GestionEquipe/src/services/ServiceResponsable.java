/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Utilisateur;
import util.Myconnexion;

/**
 *
 * @author anasl
 */
public class ServiceResponsable {
     Connection cnx;

    public ServiceResponsable() {
        cnx=Myconnexion.getInstance().getCnx();
    }
   public List<Utilisateur> afficher_part() {
List<Utilisateur> list = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM utilisateur ";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Utilisateur(rs.getInt(1), rs.getString(2),rs.getDate(3),rs.getString(7),rs.getString(5),rs.getString(6)
                ,rs.getString(10),rs.getString(4),rs.getString(11)));
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list ;
   }
    
}
