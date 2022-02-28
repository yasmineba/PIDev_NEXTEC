/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM.PIDEV.service;

import COM.PIDEV.models.Invitation;
import gestionequipe.utils.Myconnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author anasl
 */
public class ServiceInvitation implements IService <Invitation> {
    Connection cnx;

    public ServiceInvitation() {
        cnx=Myconnexion.getInstance().getCnx();
    }
    

    @Override
    public void ajouter(Invitation t) {
         try {
            Statement st;
            st=cnx.createStatement();
         
            String query1="INSERT INTO `invitation`( `etat`,`id_eq`,`id_joueur`) VALUES ('"+t.getEtat()+"','"+t.getId_eq()+"','"+t.getId_joueur()+"')";
            
            st.executeUpdate(query1);
            System.out.println("invitation ajoutée avec success");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceInvitation.class.getName()).log(Level.SEVERE, null, ex);
        }}

    @Override
    public void modifier(long id_amodifier, Invitation t) {
         try {
            PreparedStatement st;
            st=cnx.prepareStatement(
                    "UPDATE `invitation` SET `id_invitation`=?,`id_joueur`=? WHERE id=?");
            st.setInt (1,(int) t.getId_eq());
            st.setInt (2,(int) t.getId_joueur());
            st.setLong(3, id_amodifier);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceInvitation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void supprimer(long id_invitation) {
 try {
            Statement st=cnx.createStatement();
            String query="delete from invitation where id="+id_invitation;
            st.executeUpdate(query);
            System.out.println("suppression avec success");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceInvitation.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public List<Invitation> afficher() {
 List<Invitation> lu=new ArrayList<>();
        try {
            
            Statement st=cnx.createStatement();
            String query="select * from invitation";
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                Invitation i =new Invitation();
                i.setId_invitation(rs.getInt("id_invitation"));
                i.setId_eq(rs.getInt("id_eq"));
                i.setId_joueur(rs.getInt("id_joueur"));
                lu.add(i);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEquipe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lu;
    
    }     
    public Invitation findByID_inv(int id_invitation){
        List<Invitation> invitation=afficher();
        Invitation resultat=invitation.stream().filter(i->id_invitation==i.getId_invitation()).findFirst().get();
        return resultat;
    }
    public TreeSet<Invitation> sortByEtat(){
          TreeSet<Invitation> tr=  this.afficher().stream().collect(Collectors.toCollection(() -> new TreeSet<>((f1, f2) -> f1.getEtat().compareTo(f2.getEtat()))));
          return tr;
        
     }
    
}
