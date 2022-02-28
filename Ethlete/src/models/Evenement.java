/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author 21624
 */
public class Evenement {
    private int id_event;
    private String nom_event;
    private String date_debut;
    private String date_fin;
    private int id_typeE;
    private int id_formation;
    private int id_inter;
    private int id_compet;


    public Evenement() {
    }

    public Evenement(int id_event, String nom_event, String date_debut, String date_fin, int id_typeE, int id_formation, int id_inter, int id_compet) {
        this.id_event = id_event;
        this.nom_event = nom_event;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.id_typeE = id_typeE;
        this.id_formation = id_formation;
        this.id_inter = id_inter;
        this.id_compet = id_compet;
    }

    public Evenement(String nom_event, String date_debut, String date_fin, int id_typeE, int id_formation, int id_inter, int id_compet) {
        this.nom_event = nom_event;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.id_typeE = id_typeE;
        this.id_formation = id_formation;
        this.id_inter = id_inter;
        this.id_compet = id_compet;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getNom_event() {
        return nom_event;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public int getId_typeE() {
        return id_typeE;
    }

    public void setId_typeE(int id_typeE) {
        this.id_typeE = id_typeE;
    }

    public int getId_formation() {
        return id_formation;
    }

    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }

    public int getId_inter() {
        return id_inter;
    }

    public void setId_inter(int id_inter) {
        this.id_inter = id_inter;
    }

    public int getId_compet() {
        return id_compet;
    }

    public void setId_compet(int id_compet) {
        this.id_compet = id_compet;
    }
    
    

    @Override
    public String toString() {
        return "Evenement{" + "id_event=" + id_event + ", nom_event=" + nom_event + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", id_typeE=" + id_typeE + ", id_formation=" + id_formation + ", id_inter=" + id_inter + ", id_compet=" + id_compet + '}';
    }

    
}
