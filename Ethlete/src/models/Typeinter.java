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
public class Typeinter {
    private int id_typeint;
    private String type;

    public Typeinter(int id_typeint, String type) {
        this.id_typeint = id_typeint;
        this.type = type;
    }

    public Typeinter() {
    }

    public Typeinter(String type) {
        this.type = type;
    }

    public int getId_typeint() {
        return id_typeint;
    }

    public void setId_typeint(int id_typeint) {
        this.id_typeint = id_typeint;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Typeinter{" + "id_typeint=" + id_typeint + ", type=" + type + '}';
    }
    
    
}
