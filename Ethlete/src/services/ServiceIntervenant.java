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
import java.util.List;
import models.Intervenant;

/**
 *
 * @author 21624
 */
public class ServiceIntervenant implements I_intervenant{
    Connection cnx = utils.MaConnexion.getInstance().getCnx();

    @Override
    public boolean ajouterIntervenant(Intervenant I) {
        String request ="INSERT INTO `intervenant`(`nom`, `prenom`, `poste`, `email`, `telephone`) VALUES ('"+I.getNom()+"','"+I.getPrenom()+"','"+I.getPoste()+"','"+I.getEmail()+"',"+I.getTelephone()+")";
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
                intervenants.add(new Intervenant(rs.getInt("id_inter"),rs.getString("nom"),rs.getString("prenom"),rs.getString("poste"),rs.getString("email"),rs.getInt("telephone")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return intervenants; 
    }
    

    @Override
    public boolean modifierIntervenant(Intervenant I) {
           String req = "UPDATE `intervenant` SET `nom`='"+I.getNom()+"',`prenom`='"+I.getPrenom()+"',`poste`='"+I.getPoste()+"',`email`='"+I.getEmail()+"',`telephone`="+I.getTelephone()+" WHERE id_inter = "+I.getId_inter()+"";
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
        }    }

    
}
