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
public class Billet {
    private int id_billet;
    private int id_event;
    private float prix;
    private Date date_achat;

    public Billet(int id_billet, int id_event, float prix, Date date_achat) {
        this.id_billet = id_billet;
        this.id_event = id_event;
        this.prix = prix;
        this.date_achat = date_achat;
        
    }

    public Billet(int id_event, float prix, Date date_achat) {
        this.id_event = id_event;
        this.prix = prix;
        this.date_achat = date_achat;
    }

    public Billet() {
    }

    public int getId_billet() {
        return id_billet;
    }

    public void setId_billet(int id_billet) {
        this.id_billet = id_billet;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Date getDate_achat() {
        return date_achat;
    }

    public void setDate_achat(Date date_achat) {
        this.date_achat = date_achat;
    }
    
    
    
}
