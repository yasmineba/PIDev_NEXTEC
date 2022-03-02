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
    private String email;    
    private int telephone;
    private String poste;

    public Intervenant(int id_inter, String nom, String prenom, String email, int telephone, String id_typeint) {
        this.id_inter = id_inter;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.poste = id_typeint;
    }
    public Intervenant(int id_inter) {
        this.id_inter = id_inter;
    }


    public Intervenant(String nom, String prenom, String email, int telephone, String id_typeint) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.poste = id_typeint;
    }

    public Intervenant() {
    }

    public int getId_inter() {
        return id_inter;
    }

    public void setId_inter(int id_inter) {
        this.id_inter = id_inter;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String id_typeint) {
        this.poste = id_typeint;
    }

    @Override
    public String toString() {
        return "Intervenant{" + "id_inter=" + id_inter + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone=" + telephone + ", poste=" + poste + '}';
    }
    
    public String concat(){
        return id_inter + "/@/" + nom + "/@/" + prenom + "/@/" + email + "/@/" + telephone + "/@/" + poste ;
    }
   

   

  
    
}
