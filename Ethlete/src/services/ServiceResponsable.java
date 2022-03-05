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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Role;
import models.User;
import models.Utilisateur;
import static services.CryptWithMD5.cryptWithMD5;
import util.DataSource;

/**
 *
 * @author pc
 */
public class ServiceResponsable {
       Connection cnx;

    public ServiceResponsable() {
        cnx=DataSource.getInstance().getCnx();
    }
   public List<User> afficher_part() {
        List<User> lu=new ArrayList<>();
        try {
            Statement st=cnx.createStatement();
            String query="select * from user";
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                User u =new User();
                u.setAdresse(rs.getString("adresse"));
                u.setDate_naissance(rs.getDate("date_naissance"));
                u.setEmail(rs.getString("email"));
                u.setId(rs.getLong("id"));
                u.setNom(rs.getString("nom"));
                u.setNumTel(rs.getInt("num_tel"));
                u.setPassword(cryptWithMD5(rs.getString("password")));
                u.setPrenom(rs.getString("prenom"));
                u.setUsername(rs.getString("username"));
                u.setRole(Role.valueOf(rs.getString("role")));
                u.setGenre(rs.getString("genre"));
                lu.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lu;
    }
}
