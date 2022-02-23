/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionutilisateur1.service;

import gestionutilisateur1.entity.Role;
import gestionutilisateur1.entity.User;
import gestionutilisateur1.utils.MyConnexion;
import gestionutilisateur1.service.CryptWithMD5;
import static gestionutilisateur1.service.CryptWithMD5.cryptWithMD5;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.event.PrintJobEvent;
import javax.print.event.PrintJobListener;



/**
 *
 * @author MSI
 */
public class UserService implements IService <User> {
    Connection cnx;
    
    public UserService(){
        cnx=MyConnexion.getInstance().getCnx();
        
    }

    @Override
    public void ajouter(User t) {
        try {
            Statement st;
            st=cnx.createStatement();
            String query="INSERT INTO `user`( `adresse`, `date_naissance`, `email`, `nom`, `num_tel`, `password`, `prenom`, `role`, `username`) "
                    + "VALUES ('"+t.getAdresse()+"','"+t.getDate_naissance()+"','"+t.getEmail()+"','"+t.getNom()+"','"+t.getNumTel()+"','"+cryptWithMD5(t.getPassword())+"','"+t.getPrenom()+"','"+t.getRole()+"','"+t.getUsername()+"')";
            st.executeUpdate(query);
            System.out.println("user ajouter avec success");
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(long id_amodifier, User t) {
        try {
            PreparedStatement st;
            st=cnx.prepareStatement("UPDATE `user` SET `adresse`=?,`date_naissance`=?,"
                    + "`email`=?,`nom`=?,`num_tel`=?,"
                    + "`password`=?,`prenom`=?,"
                    + "`role`=?,`username`=? WHERE id=?");
            st.setString(1, t.getAdresse());
            st.setDate(2,new java.sql.Date(t.getDate_naissance().getTime()));
            st.setString(3,t.getEmail());
            st.setString(4,t.getNom());
            st.setInt(5, t.getNumTel());
            st.setString(6,cryptWithMD5( t.getPassword()));
            st.setString(7, t.getPrenom());
            st.setString(8, t.getRole().toString());
            st.setString(9, t.getUsername());
            st.setLong(10, id_amodifier);
            if (st.executeUpdate()==1){
            System.out.println("user modifier avec success");
            }else {
                System.out.println("user n'existe pas");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void supprimer(long id) {
        try {
            Statement st=cnx.createStatement();
            String query="delete from user where id="+id;
            if(st.executeUpdate(query)==1){
            System.out.println("suppression avec success");
            }else {
                System.out.println("user n'existe pas");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<User> afficher() {
        List<User> lu=new ArrayList<>();
        try {
            Statement st=cnx.createStatement();
            String query="select * from user";
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                User u =new User();
                u.setAdresse(rs.getString("adresse"));
                u.setDate_naissance(rs.getDate("date_naissance"));
                u.setEmail(rs.getString("email"));
                u.setId(rs.getLong("id"));
                u.setNom(rs.getString("nom"));
                u.setNumTel(rs.getInt("num_tel"));
                u.setPassword(cryptWithMD5(rs.getString("password")));
                u.setPrenom(rs.getString("prenom"));
                u.setUsername(rs.getString("username"));
                u.setRole(Role.valueOf(rs.getString("role")));
                lu.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lu;
    }
    
    public User findById(long id){
         User u =new User();
          try {
            Statement st=cnx.createStatement();
            String query="select * from user where id="+id;
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                
                u.setAdresse(rs.getString("adresse"));
                u.setDate_naissance(rs.getDate("date_naissance"));
                u.setEmail(rs.getString("email"));
                u.setId(rs.getLong("id"));
                u.setNom(rs.getString("nom"));
                u.setNumTel(rs.getInt("num_tel"));
                u.setPassword(cryptWithMD5(rs.getString("password")));
                u.setPrenom(rs.getString("prenom"));
                u.setUsername(rs.getString("username"));
                u.setRole(Role.valueOf(rs.getString("role")));
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
        
    }
    
    public List<User> findByName(String name){
        List<User> users=afficher();
        List<User> resultat=users.stream().filter(user->name.equals(user.getNom())).collect(Collectors.toList());
        //resultat.forEach(System.out::println);
        return resultat;
    }

    public List<User> findByPrenom(String prenom){
        List<User> users=afficher();
        List<User> resultat=users.stream().filter(user->prenom.equals(user.getPrenom())).collect(Collectors.toList());
        return resultat;
    }
    
     public List<User> findByRole(Role role){
         List<User> users=afficher();
         List<User> resultat=users.stream().filter(user->role.equals(user.getRole())).collect(Collectors.toList());
         return resultat;
     }
    
     public List<User> findByDate(Date date){
         List<User> users=afficher();
         List<User> resultat=users.stream().filter(user->date.toString().equals(user.getDate_naissance().toString())).collect(Collectors.toList());
         return resultat;
     }
     
     public List<User> findByEmail(String email){
         List<User> users = afficher();
         List<User> resultat=users.stream().filter(user->email.equals(user.getEmail())).collect(Collectors.toList());
         return resultat;
     }
     
     public List<User> findByUsername(String username){
         List<User> users = afficher();
         List<User> resultat=users.stream().filter(user->username.equals(user.getUsername())).collect(Collectors.toList());
         return resultat;
     }
     
     public List<User> findByNum(int numtel){
         List<User> users=afficher();
         List<User> resultat=users.stream().filter(user->numtel==user.getNumTel()).collect(Collectors.toList());
         return resultat;
     }
     
     public List<User> findByAdresse(String adresse){
         List<User> users=afficher();
         List<User> resultat=users.stream().filter(user->adresse.equals(user.getAdresse())).collect(Collectors.toList());
         return resultat;
     }
     
     public List<User> sortByDate(){
         List<User> users=afficher();
         List<User> resultat=users.stream().sorted(Comparator.comparing(User::getDate_naissance)).collect(Collectors.toList());
         return resultat;
         
     }
     
     public List<User> sortById(){
         List<User> users=afficher();
         List<User> resultat=users.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());
         return resultat;
     }
     
     public List<User> sortByNom(){
         List<User> users=afficher();
         List<User> resultat=users.stream().sorted(Comparator.comparing(User::getNom)).collect(Collectors.toList());
         return resultat;
     }
     
     public boolean checklogin(String username,String password){
        try {
            Statement st=cnx.createStatement();
            String query="SELECT * FROM `user` WHERE `username`='"+username+"' AND `password`='"+password+"'";
            ResultSet rs=st.executeQuery(query);
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
     }
    
     public void BasicPrint() throws PrintException, IOException{
         // On donne la type MIME d'impression
  DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;

  // On peut prendre tous les services disponibles
  //PrintService[] services = PrintServiceLookup.lookupPrintServices(flavor, null);

  PrintService service = PrintServiceLookup.lookupDefaultPrintService();

  PrintRequestAttributeSet pref = new HashPrintRequestAttributeSet();
  // On peut ouvrir la boite de dialogue avec aucune préférences
  //PrintService service = ServiceUI.printDialog(null, 200, 200, services, null, flavor, pref);

  if (service == null) {
   System.out.println("Impression annulée");
   System.exit(0);
  }

  // La chaine à imprimer
  InputStream is = new ByteArrayInputStream("Super texte".getBytes());

  /* On crée un document et l'impression */
  Doc doc = new SimpleDoc(is, flavor, null);
  DocPrintJob job = service.createPrintJob();

  // On ajoute un Job Listener pour savoir si le texte à été imprimé
  PrintJobWatcher printJobWatcher = new PrintJobWatcher();
  job.addPrintJobListener(printJobWatcher);

  // impression
  job.print(doc, pref);

  /*
   * processus bloquant... on attend que l'impression se termine
   */
  printJobWatcher.waitForDone();

  is.close();

 }
}

class PrintJobWatcher implements PrintJobListener {

 boolean done = false;

 // processus bloquant
 public synchronized void waitForDone() {
  try {
   // on attend tant que l'impression n'est pas terminée
   while (!done)
    wait();
  } catch (InterruptedException e) {}
 }

 @Override
 public void printDataTransferCompleted(PrintJobEvent arg0) {
  System.out.println("Donnée transférée");
 }

 @Override
 public void printJobCanceled(PrintJobEvent arg0) {
  System.out.println("Impression annulée");
  notifyDone();
 }

 @Override
 public void printJobRequiresAttention(PrintJobEvent arg0) {
  System.out.println("Erreur... (Pas de papier)");
 }

 @Override
 public void printJobCompleted(PrintJobEvent evt) {
  System.out.println("Texte imprimé avec succès");
  notifyDone();
 }

 @Override
 public void printJobNoMoreEvents(PrintJobEvent arg0) {
  System.out.println("Texte imprimé avec succès (sans vérification)");
  notifyDone();

 }

 @Override
 public void printJobFailed(PrintJobEvent evt) {
  System.out.println("Erreur lors de l'impression");
  notifyDone();
 }

 void notifyDone() {
  synchronized(this) {
   done = true;
   System.out.println("Impression terminée !");
   this.notify();
  }
 }

    

     }


     
         
     
     
    
     
     
    

