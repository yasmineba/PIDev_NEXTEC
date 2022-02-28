/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.I_billet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Billet;

/**
 *
 * @author 21624
 */
public class ServiceBillet implements I_billet {
    Connection cnx = utils.MaConnexion.getInstance().getCnx();

    @Override
    public boolean ajouterBillet(Billet B) {
        
            Connection cnx = utils.MaConnexion.getInstance().getCnx();

        String request ="INSERT INTO `billets`(`id_event`, `prix`,`date_achat`) VALUES ('"+B.getId_event()+"',"+B.getPrix()+",NOW())";
           try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(request) == 1)
                    return true;
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }    }

    @Override
    public List<Billet> afficherBillet() {
   List<Billet> billets = new ArrayList<Billet>();

        String req="SELECT * FROM billets";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SOB HEDHA FI HEDHA
            while(rs.next()){
             billets.add(new Billet(rs.getInt("id_billet"),rs.getInt("id_event"),rs.getFloat("prix"),rs.getString("date_achat")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return billets;     }

    @Override
    public boolean modifierEvenement(Billet B) {
 String req = "UPDATE `billet` SET `id_event`='"+B.getId_event()+"',`prix`="+B.getPrix()+" ,`date_achat`='"+B.getDate_achat()+"' WHERE id_inter = "+B.getId_billet()+"";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1)
                return true;
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }    }

    @Override
    public boolean supprimerEvenement(Billet B) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
