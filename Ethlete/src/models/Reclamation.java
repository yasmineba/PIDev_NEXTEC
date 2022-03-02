/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ASUS
 */
public class Reclamation {
    private int idr; // Primary Key
    private String contenu;
    private int id;
    private String daterec; 

    public Reclamation() {
    }

    public Reclamation(String contenu, int id, String daterec) {
        this.contenu = contenu;
        this.id = id;
        this.daterec = daterec;
    }

    public Reclamation(int idr, String contenu, int id, String daterec) {
        this.idr = idr;
        this.contenu = contenu;
        this.id = id;
        this.daterec = daterec;
    }

    public int getIdr() {
        return idr;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDaterec() {
        return daterec;
    }

    public void setDaterec(String daterec) {
        this.daterec = daterec;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "idr=" + idr + ", contenu=" + contenu + ", id=" + id + ", daterec=" + daterec + '}';
    }
    
    
    
}
