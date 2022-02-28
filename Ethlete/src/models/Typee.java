/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author 21624
 */
public class Typee {
    private int id_type;
    private String nom_type;

    public Typee(int id_type, String nom_type) {
        this.id_type = id_type;
        this.nom_type = nom_type;
    }

    public Typee(String nom_type) {
        this.nom_type = nom_type;
    }

    public Typee() {
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public String getNom_type() {
        return nom_type;
    }

    public void setNom_type(String nom_type) {
        this.nom_type = nom_type;
    }

    @Override
    public String toString() {
        return "Typee{" + "id_type=" + id_type + ", nom_type=" + nom_type + '}';
    }
    
    
}
