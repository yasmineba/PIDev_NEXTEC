/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM.PIDEV.models;

/**
 *
 * @author anasl
 */
public class Avis {
    private long id_avis;
    private long id_user;
    private Integer note;

    public Avis() {
    }

    public Avis(long id_avis, long id_user, Integer note) {
        this.id_avis = id_avis;
        this.id_user = id_user;
        this.note = note;
    }

    public Avis(String non_consulté, long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public long getId_avis() {
        return id_avis;
    }

    public long getId_user() {
        return id_user;
    }

    public int getnote() {
        return note;
    }

    public void setId_avis(long id_avis) {
        this.id_avis = id_avis;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public void setnote(Integer note) {
        this.note = note;
    }


    @Override
    public String toString() {
        return "Avis{" + "id_avis=" + id_avis + ", id_user=" + id_user + ", note=" + note + '}';
    }
    
  
    
}
