
package util;

import java.sql.*;

/**
 *
 * @author msi
 */
public class Maconnexion {
    
    final String URL="jdbc:mysql://127.0.0.1:3306/ethlete";
    final String USR="root";
    final String PWD="";
    
    
    private Connection cnx;
   //etape1 
    static Maconnexion instance=null;
    
    //constructeur limiter la connection etape2

    private Maconnexion() {
        try {
            cnx=DriverManager.getConnection(URL, USR, PWD);
            System.out.println("connected!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static Maconnexion getInstance() {
        //3eme etape
        if(instance==null){
            instance=new Maconnexion();}
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
    
}
