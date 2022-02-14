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
    private Date date_debut;
    private Date date_fin;
    private String type;

    public Evenement() {
    }

    
    public Evenement(int id_event, String nom_event, Date date_debut, Date date_fin, String type) {
        this.id_event = id_event;
        this.nom_event = nom_event;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.type = type;
    }

    public Evenement(String nom_event, Date date_debut, Date date_fin, String type) {
        this.nom_event = nom_event;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.type = type;
    }

    
    public int getId_event() {
        return id_event;
    }

    public String getNom_event() {
        return nom_event;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public String getType() {
        return type;
    }

    
    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_event=" + id_event + ", nom_event=" + nom_event + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", type=" + type + '}';
    }
    
}
