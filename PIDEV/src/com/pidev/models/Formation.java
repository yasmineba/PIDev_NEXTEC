/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.models;

import java.text.SimpleDateFormat;
import java.sql.Date;
import lombok.*;

/**
 *
 * @author pc
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Formation {
     private int id_formation;

    public Formation(int id_formation) {
        this.id_formation = id_formation;
    }
   
    private String nom_formation;



    private Date date_debut;

    private Date date_fin;
    

    private String dispositif;

 
    private  String programme;

    public Formation(String nom_formation, Date date_debut, Date date_fin, String type, String programme) {
        this.nom_formation = nom_formation;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.dispositif = type;
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
