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
public class Intervenant {
    private int id_inter;
    private String nom;
    private String prenom;
    private String poste;    
    private String email;    
    private int telephone;

    public Intervenant(int id_inter, String nom, String prenom, String poste, String email, int telephone) {
        this.id_inter = id_inter;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.email = email;
        this.telephone = telephone;
    }

    public Intervenant(String nom, String prenom, String poste, String email, int telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.email = email;
        this.telephone = telephone;
    }

    public int getId_inter() {
        return id_inter;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPoste() {
        return poste;
    }

    public String getEmail() {
        return email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setId_inter(int id_inter) {
        this.id_inter = id_inter;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Intervenant{" + "id_inter=" + id_inter + ", nom=" + nom + ", prenom=" + prenom + ", poste=" + poste + ", email=" + email + ", telephone=" + telephone + '}';
    }

  
    
}
