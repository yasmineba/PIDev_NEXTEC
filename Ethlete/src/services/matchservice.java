 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Journe;
import models.Match;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.mydb;
import java.util.stream.Collectors;
import java.util.TreeSet;


/**
 *
 * @author gaming
 */
public class matchservice implements iservice<Match>{
    Connection cnx;
     public matchservice() {
         cnx = mydb.getInstance().getConncetion();
    }
         @Override
    public void ajouter(Match t) {
        
            try {
          
           String query="INSERT INTO `match` (`Equipe1`, `Equipe2`, `id_journe`) VALUES (?,?,?);";
                PreparedStatement smt = cnx.prepareStatement(query);
                smt.setString(1, t.getEquipe1());
                smt.setString(2, t.getEquipe2());
                smt.setInt(3, t.getId_journe());
                smt.executeUpdate();
                System.out.println("ajout avec succee");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
           
       }
    }
    
    
    
    @Override
    public void modifier(Match t) {
         try {
       String query2="UPDATE `match` SET `Equipe1` = ?, `Equipe2` = ?, `etat` = ? WHERE `match`.`id_match` = ?;";
                PreparedStatement smt = cnx.prepareStatement(query2);
                
                smt.setString(1, t.getEquipe1());
                smt.setString(2, t.getEquipe2());
                smt.setString(3, t.getEtat());              
                smt.setInt(4, t.getId_match());
                smt.executeUpdate();
                System.out.println("modification avec succee");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }}
    @Override
    public void supprimer(Match t) {
         try {
       String query2="DELETE FROM `match` WHERE `match`.`id_match` = ?";
                PreparedStatement smt = cnx.prepareStatement(query2);
                smt.setInt(1, t.getId_match());
                smt.executeUpdate();
                System.out.println("suppression avec succee");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }}
    @Override
    public List<Match> find() {
        List<Match> list = new ArrayList<>();
        try {
       String query2="SELECT * FROM `match`";
                PreparedStatement smt = cnx.prepareStatement(query2);
                Match p;
                ResultSet rs= smt.executeQuery();
                while(rs.next()){
                   p=new Match(rs.getInt("id_match"),rs.getString("equipe1"),rs.getString("equipe2"),rs.getString("etat"));
                System.out.println(p);
                  
                   list.add(p);
                }
                System.out.println(list);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

        return list;
    
}

     public Match findByID_inv(int id_match){
        List<Match> match=find();
        Match resultat=match.stream().filter(i->id_match==i.getId_match()).findFirst().get();
        return resultat;
    }
    public TreeSet<Match> sortByEtat(){
          TreeSet<Match> tr=  this.find().stream().collect(Collectors.toCollection(() -> new TreeSet<>((f1, f2) -> f1.getEtat().compareTo(f2.getEtat()))));
          return tr;
}

    
    
}
