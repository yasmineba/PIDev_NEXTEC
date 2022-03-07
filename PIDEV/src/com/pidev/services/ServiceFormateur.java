/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import util.DataSource;
import models.Formation;
import models.Utilisateur;
import interfaces.IService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author pc
 */
public class ServiceFormateur implements IService <Utilisateur> {

    public ServiceFormateur() {
    }
    
    Connection cnx = DataSource.getInstance().getCnx();

   /* @Override
    public void ajouter(Utilisateur t) {
   try {String s="ROLE_FORMATEUR";
        Random rand = new Random();
   
String alphabet = "abcd12345#/";
String pswd="";
int longueur = alphabet.length();
for(int i = 0; i < 12; i++) {
  int k = rand.nextInt(longueur);
 
  pswd=pswd+alphabet.charAt(k);
}


       t.setPassword(pswd);
       t.setUsername(t.getEmail());
     
       
            String req = "SELECT id from roles  where nom_role like '"+s+"'";
            PreparedStatement pst1 = cnx.prepareStatement(req);
            ResultSet rs = pst1.executeQuery();
              while(rs.next()) {
t.setRole(rs.getInt(1));                
            
            }
           

String req1 = "INSERT INTO utilisateur (nom, prenom,adresse,email,telephone,date_naissance,username,password,role) VALUES (?,?,"
                    + "?,?,?,?,?,?,?)";
                    PreparedStatement pst = cnx.prepareStatement(req1);

           cnx.prepareStatement(req1);
          
            pst.setString(1, t.getNom());
            pst.setString(2, t.getPrenom());
            pst.setString(3, t.getAdresse());
            pst.setString(4, t.getEmail());
            pst.setString(5, t.getTelephone());
            pst.setString(6,  t.getDate_naissance());
            pst.setString(7, t.getEmail());
            pst.setString(8, t.getPassword());
            pst.setString(9, t.getRole());
            pst.executeUpdate();
            System.out.println("Formateur bien ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }

    @Override
    public void supprimer(Utilisateur t) {
          try {
            String req = "DELETE FROM utilisateur WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getId());
            pst.executeUpdate();
            System.out.println("Personne suprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
*/
  
//list de tous les formateurs
    @Override
    public List<Utilisateur> afficher() {
             List<Utilisateur> formateurs = new ArrayList<>();
       
            
       
            formateurs=this.afficher_part().stream().filter(e->e.getRole().equals("ROLE_FORMATEUR")).collect(Collectors.toList());
            

            
            
            
      
        
        return formateurs;
    }

    @Override
    public void modifier(Utilisateur t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //consulterformateur
    public Utilisateur consulte_formateur(int id)
    {
        Utilisateur u=new Utilisateur();
        u=this.afficher().stream().filter(e->e.getId()==id).findFirst().get();
        return u;
    }

    @Override
    public void ajouter(Utilisateur t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(Utilisateur t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Utilisateur> afficher_part() {
List<Utilisateur> list = new ArrayList<>();
             List<Utilisateur> formateurs = new ArrayList<>();
        try {String s="ROLE_FORMATEUR";
            String req = "SELECT * FROM utilisateur ";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(7),rs.getString(5),rs.getString(6)
                ,rs.getString(10),rs.getString(4),rs.getString(11))
                
                );
            }
            
       
           
            

            
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    public Utilisateur findbyId(int id)
    {return this.afficher_part().stream().filter(e->e.getId()==id).findFirst().get();
    }
 }

    


