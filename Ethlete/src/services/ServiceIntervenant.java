/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.util.ArrayList;
import interfaces.I_intervenant;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import models.Intervenant;
import util.DataSource;

/**
 *
 * @author 21624
 */
public class ServiceIntervenant implements I_intervenant{
    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public boolean ajouterIntervenant(Intervenant I) {
        String request ="INSERT INTO `intervenant`(`nom`, `prenom`, `email`, `telephone` , `id_typeint`) VALUES ('"+I.getNom()+"','"+I.getPrenom()+"','"+I.getEmail()+"',"+I.getTelephone()+" ,'"+I.getPoste()+"')";
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
    public List<Intervenant> afficherIntervenant() {
         List<Intervenant> intervenants = new ArrayList<Intervenant>();

        String req="SELECT * FROM intervenant";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
                intervenants.add(new Intervenant(rs.getInt("id_inter"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getInt("telephone"),rs.getString("id_typeint")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return intervenants; 
    }
    

    @Override
    public boolean modifierIntervenant(Intervenant I) {
           String req = "UPDATE `intervenant` SET `nom`='"+I.getNom()+"',`prenom`='"+I.getPrenom()+"',`email`='"+I.getEmail()+"',`telephone`="+I.getTelephone()+" ,`id_typeint`='"+I.getPoste()+"' WHERE id_inter = "+I.getId_inter()+"";
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
    public boolean supprimerIntervenant(Intervenant I) {
String req = "DELETE FROM `intervenant` WHERE id_inter = "+I.getId_inter()+" ";

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
    public List<Intervenant> rechercherIntervenant(List<Intervenant> initialList, String input) {
    List<Intervenant> strList = initialList.stream()
                           .map( Intervenant::concat )
                           .filter(pt -> pt.toLowerCase().contains(input.toLowerCase()))
                           .map(pt -> new Intervenant(Integer.parseInt(pt.split("/@/")[0]),pt.split("/@/")[1],pt.split("/@/")[2],pt.split("/@/")[3],Integer.parseInt(pt.split("/@/")[4]),(pt.split("/@/")[5])))
                           .collect( Collectors.toList() );
        
        return strList;
    }    

    
    
     public List<Intervenant> sortByNom(){
         List<Intervenant> intervenant=afficherIntervenant();
         List<Intervenant> resultat = intervenant.stream()
                                                 .sorted(Comparator.comparing(Intervenant::getNom))
                                                 .collect(Collectors.toList());
         return resultat;
     }

   
}

    

    

