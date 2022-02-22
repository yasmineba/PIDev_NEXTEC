/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionequipe.Service;

import gestionequipe.entity.Avis;
import gestionequipe.utils.Myconnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author anasl
 */
public class ServiceAvis implements IService<Avis> {

    Connection cnx;

    public ServiceAvis() {
        cnx = Myconnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(Avis t) {
        try {
            Statement st;
            st = cnx.createStatement();
            String query1 = "INSERT INTO `avis`( `id_user`, `note`) VALUES ('" + t.getId_user() + "','" + t.getnote() + "')";
            st.executeUpdate(query1);
            System.out.println("note  ajouter avec success");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAvis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(long id_amodifier, Avis t) {
        try {
            PreparedStatement st;
            st = cnx.prepareStatement(
                    "UPDATE `avis` SET `note`=?,`id_user`=? WHERE id=?");
            st.setLong(1, t.getId_user());
            st.setInt(2, (int) t.getnote());
            st.setLong(3, id_amodifier);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAvis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(long id_avis) {
        try {
            Statement st = cnx.createStatement();
            String query = "delete from avis where id=" + id_avis;
            st.executeUpdate(query);
            System.out.println("suppression avec success");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAvis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Avis> afficher() {
        List<Avis> lu = new ArrayList<>();
        try {

            Statement st = cnx.createStatement();
            String query = "select * from avis";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Avis u = new Avis();
                u.setId_avis(rs.getInt("id_avis"));
                u.setId_user(rs.getInt("id_user"));
                u.setnote(rs.getInt("note"));
                lu.add(u);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceAvis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lu;

    }

    public Avis findByID_avis(int id_avis) {
        List<Avis> avis = afficher();
        Avis resultat = avis.stream().filter(i -> id_avis == i.getId_avis()).findFirst().get();
        return resultat;
    }

    public List<Avis> sortBynote() {
        List<Avis> avis= afficher();
         List<Avis> resultat=avis.stream().sorted(Avis::getnote).collect(Collectors.toList());
                return resultat;
    }
}
