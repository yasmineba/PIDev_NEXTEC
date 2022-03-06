/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anasl
 */
public class Myconnexion {
     private final String URL="jdbc:mysql://127.0.0.1:3306/ethlete" ;
    private final String USER="root";
    private final String PWD="";
    
    private static Connection cnx;
    private static Myconnexion instance;

    private Myconnexion() {
        
        try {
            cnx=DriverManager.getConnection(URL,USER,PWD);
            System.out.println("connexion etablie avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(Myconnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Myconnexion getInstance(){
        if (instance==null){
            instance=new Myconnexion();
        }else{
            System.out.println("deja connecte");
        }
        return instance;
    }
    
    public static Connection getCnx(){
        return cnx;
    }

    
}
