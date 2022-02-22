/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionequipe.Service;

import gestionequipe.entity.Equipe;
import gestionequipe.utils.Myconnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author anasl
 */
public class ServiceEquipe implements IService <Equipe> {
     Connection cnx;

    public ServiceEquipe() {
        cnx=Myconnexion.getInstance().getCnx();
    }
    

    @Override
    public void ajouter(Equipe t) {
       try {
            Statement st;
            st=cnx.createStatement();
           // String query="SELECT * FROM `utilisateur` , `equipe` WHERE id=id_responsable ";
            String query1="INSERT INTO `equipe`( `nom_equipe`, `id_responsable`) VALUES ('"+t.getNom_equipe()+"','"+t.getId_responsable()+"')";
            //st.executeUpdate(query);
            st.executeUpdate(query1);
            System.out.println("equipe  ajouter avec success");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEquipe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(long id_amodifier, Equipe t) {
        try {
            PreparedStatement st;
            st=cnx.prepareStatement(
                    "UPDATE `equipe` SET `nom_equipe`=?,`id_responsable`=? WHERE id=?");
            st.setString(1, t.getNom_equipe());
            st.setInt(2, (int) t.getId_responsable());
            st.setLong(3, id_amodifier);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEquipe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void supprimer(long id_equipe) {
        try {
            Statement st=cnx.createStatement();
            String query="delete from equipe where id="+id_equipe;
            st.executeUpdate(query);
            System.out.println("suppression avec success");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEquipe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Equipe> afficher() {
         List<Equipe> lu=new ArrayList<>();
        try {
            
            Statement st=cnx.createStatement();
            String query="select * from equipe";
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                Equipe u =new Equipe();
                u.setId_equipe(rs.getInt("id_equipe"));
                u.setNom_equipe(rs.getString("nom_equipe"));
                u.setId_responsable(rs.getInt("id_responsable"));
                lu.add(u);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEquipe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lu;
    
    } 
    public List<Equipe> findBynom_equipe(String nom_equipe){
        List<Equipe> equipes=afficher();
        List<Equipe> resultat=equipes.stream().filter(equipe->nom_equipe.equals(equipe.getNom_equipe())).collect(Collectors.toList());
        return resultat;
    }
    public List<Equipe> sortByNom(){
         List<Equipe> equipes=afficher();
         List<Equipe> resultat=new ArrayList();
              return  equipes.stream().sorted((a, b) -> a.getNom_equipe().compareTo(b.getNom_equipe()))
               .collect(Collectors.toList());
     }
    }
    

   
