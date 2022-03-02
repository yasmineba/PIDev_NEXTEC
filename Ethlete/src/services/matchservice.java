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
import java.util.stream.Collectors;
import java.util.TreeSet;
import util.DataSource;


/**
 *
 * @author gaming
 */
public class matchservice implements iservice<Match>{
    Connection cnx;
     public matchservice() {
         cnx = DataSource.getInstance().getCnx();
    }
         @Override
    public void ajouter(Match t) {
        
            try {
          
           String query="INSERT INTO `match` (`Equipe1`, `Equipe2`) VALUES (?,?);";
                PreparedStatement smt = cnx.prepareStatement(query);
                smt.setInt(1, t.getEquipe1());
                smt.setInt(2, t.getEquipe2());
                
                
                smt.executeUpdate();
                System.out.println("ajout avec succee");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
           
       }
    }
    
    
    
    @Override
    public void modifier(Match t) {
         try {
       String query2="update match set equipe1=?,equipe2=?,etat=?, where id_match=?";
                PreparedStatement smt = cnx.prepareStatement(query2);
                
                smt.setInt(1, t.getEquipe1());
                smt.setInt(2, t.getEquipe2());
                smt.setString(3, t.getEtat());
               
                smt.setInt(5, t.getId_match());
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
        ArrayList l=new ArrayList(); 
        
        try {
       String query2="select * from match";
                PreparedStatement smt = cnx.prepareStatement(query2);
                Match p;
                ResultSet rs= smt.executeQuery();
                while(rs.next()){
                   p=new Match(rs.getInt("id_match"),rs.getInt("equipe1"),rs.getInt("equipe2"),rs.getString("etat"));
                System.out.println(p);
                  
                   l.add(p);
                }
                System.out.println(l);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

        return l;
    
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
