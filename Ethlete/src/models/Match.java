/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author gaming
 */
public class Match {
    private int id_match;
    private int equipe1;
    private int equipe2;
    private String etat;
    private int id_journe;
    
    public Match(){
    }
    public Match(int id_match, int equipe1 ,int equipe2 ,String etat ){
        this.id_match=id_match;
        this.equipe1=equipe1;
        this.equipe2=equipe2;
        this.etat=etat;
        
        
        
    }
    public Match(int equipe1, int equipe2 ){
        this.equipe1=equipe1;
        this.equipe2=equipe2;
       
    }

    public Match(int id_match) {
        this.id_match = id_match;
    }
    

    public int getId_match() {
        return id_match;
    }

    public int getEquipe1() {
        return equipe1;
    }

    public int getEquipe2() {
        return equipe2;
    }


    

    public String getEtat() {
        return etat;
    }
    

    public void setId_match(int id_match) {
        this.id_match = id_match;
    }

    public void setEquipe1(int equipe1) {
        this.equipe1 = equipe1;
    }

    public void setEquipe2(int equipe2) {
        this.equipe2 = equipe2;
    }
    

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "match{" + "id_match=" + id_match + ", equipe1=" + equipe1 + ", equipe2=" + equipe2 + ", etat=" + etat +'}';
    }
    
    

    }
    
    
    






    

    

    
