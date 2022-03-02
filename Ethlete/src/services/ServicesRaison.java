/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.I_raison;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import models.Raison;
import models.Raison;
import models.Raison;

/**
 *
 * @author ASUS
 */
public class ServicesRaison implements I_raison {

    @Override
    public boolean ajouterRaison(Raison rz) {
        String request = "INSERT INTO `raison`(`raisontxt`) VALUES ('"+rz.getRaisontxt()+"')";
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
    public List<Raison> afficherRaisons() {
        List<Raison> raisons= new ArrayList<Raison>();

        String req="SELECT * FROM raison";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
               raisons.add(new Raison(rs.getInt("idraison"),rs.getString("raisontxt")));
            }
        

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return raisons;
    
    }

    @Override
    public boolean modifierRaison(Raison rz) {
      String req = "UPDATE `raison` SET `raisontxt`='"+rz.getRaisontxt()+"' WHERE idraison = "+rz.getIdraison()+" ";
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
    public boolean supprimerRaison(Raison rz) {
        String req = "DELETE FROM `raison` WHERE idraison = "+rz.getIdraison()+" ";

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
    public List<Raison> trierRaison() {
        List<Raison> raisons=afficherRaisons();
         List<Raison> sortedRaison =raisons.stream().sorted(Comparator.comparing(Raison::getIdraison)).collect(Collectors.toList());
         return sortedRaison;
    }

    @Override
     public List<Raison> chercherRaison(List<Raison> initialList, String input) {
         
                  
                  List<Raison> rzList = initialList.stream()
                           .map( Raison::concat )
                           .filter(pt -> pt.contains(input))
                           .map(pt -> new Raison(Integer.parseInt(pt.split(".@.")[0]),pt.split(".@.")[1]))
                           .collect( Collectors.toList() );
        
        return rzList;
    }

    
    
}
