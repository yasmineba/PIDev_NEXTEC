/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.text.SimpleDateFormat;
import java.sql.Date;
import lombok.*;


public class Formation {
     
    private int id_formation;
    private String nom_formation;
    private Date date_debut;
    private Date date_fin;
    private String dispositif;
    private String programme;
    
    public Formation(int id_formation) {
        this.id_formation = id_formation;
    }
    public Formation() {}
    public Formation(String nom_formation) {
        this.nom_formation = nom_formation;
    }
   

    public Formation(String nom_formation, Date date_debut, Date date_fin, String type, String programme) {
        this.nom_formation = nom_formation;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.dispositif = type;
        this.programme = programme;
    }

    public Formation(int id_formation, String nom_formation, Date date_debut, Date date_fin, String dispositif, String programme) {
        this.id_formation = id_formation;
        this.nom_formation = nom_formation;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.dispositif = dispositif;
        this.programme = programme;
    }
   

    public int getId_formation() {
        return id_formation;
    }

    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }

    public String getNom_formation() {
        return nom_formation;
    }

    public void setNom_formation(String nom_formation) {
        this.nom_formation = nom_formation;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getDispositif() {
        return dispositif;
    }

    public void setDispositif(String dispositif) {
        this.dispositif = dispositif;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public Formation(int id_formation, String nom_formation, Date date_debut, Date date_fin, String type) {
        this.id_formation = id_formation;
        this.nom_formation = nom_formation;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.dispositif = type;
    }

    public Formation(String nom_formation, Date date_debut, Date date_fin, String type) {
        this.nom_formation = nom_formation;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.dispositif = type;
    }
   

    

}
