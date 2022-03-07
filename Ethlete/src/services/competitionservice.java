/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;



import models.Competition;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Journe;
import util.mydb;
/**
 *
 * @author gaming
 */
public class competitionservice implements iservice<Competition>{
Connection cnx;
     public competitionservice() {
         cnx = mydb.getInstance().getConncetion();
    }
         @Override
    public void ajouter(Competition t) {
        
            try {
          
           String query="INSERT INTO competition(nb_equipe,date,adresse,nom) values(?,?,?,?)";
                PreparedStatement smt = cnx.prepareStatement(query);
                smt.setInt(1, t.getNb_equipe());  
                smt.setString(2, t.getDate());
                    smt.setString(3, t.getAdresse());

                smt.setString(4, t.getNom());
                

                smt.executeUpdate();
                System.out.println("ajout avec succee");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
           
       }
    }
    
    
    
    @Override
    public void modifier(Competition t) {
         try {
       String query2="UPDATE `competition` SET  `nb_equipe` = ?, `date` = ?, `adresse` = ?, `nom` = ? WHERE `competition`.`id_competition` = ?";
                PreparedStatement smt = cnx.prepareStatement(query2);
                
                 smt.setInt(1, t.getNb_equipe());  
                smt.setString(3, t.getDate());
                    smt.setString(4, t.getAdresse());

                smt.setString(2, t.getNom());
                smt.setInt(5, t.getId_competition());
                
                smt.executeUpdate();
                System.out.println("modification avec succee");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }}
    @Override
    public void supprimer(Competition t) {
         try {
       String query2="delete from competition where id_competition=?";
                PreparedStatement smt = cnx.prepareStatement(query2);
                smt.setInt(1, t.getId_competition());
               
                smt.executeUpdate();
                System.out.println("suppression avec succee");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }}
    @Override
    public List<Competition> find() {
     List<Competition> list = new ArrayList<>();        
        try {
       String query2="select * from competition";
                PreparedStatement smt = cnx.prepareStatement(query2);
                Competition p;
                ResultSet rs= smt.executeQuery();
                while(rs.next()){
                   p=new Competition(rs.getInt("id_competition"),rs.getInt("nb_equipe"),rs.getString("date"),rs.getString("adresse"),rs.getString("nom"));
                System.out.println(p);
                  
                   list.add(p);
                }
                System.out.println(list);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

        return list;
    
}
         public Competition findByID_inv(int id_competition){
        List<Competition> competition=find();
        Competition resultat=competition.stream().filter(i->id_competition==i.getId_competition()).findFirst().get();
        return resultat;    
    }
    public TreeSet<Competition> sortByEtat(){
          TreeSet<Competition> tr=  this.find().stream().collect(Collectors.toCollection(() -> new TreeSet<>((f1, f2) -> f1.getNom().compareTo(f2.getNom()))));
          return tr;
}
 public ObservableList<Competition> getlist1() {
        ArrayList l=new ArrayList(); 
        
        try { String query2="select * from competition";
                PreparedStatement smt = cnx.prepareStatement(query2);
                Competition p;
                ResultSet rs= smt.executeQuery();
                while(rs.next()){
                   p=new Competition(rs.getInt("id_competition"),rs.getInt("nb_equipe"),rs.getString("date"),rs.getString("adresse"),rs.getString("nom"));
                System.out.println(p);
                  
                   l.add(p);
                }
                System.out.println(l);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }
        return FXCollections.observableList(l);

        
    
}
 
}
