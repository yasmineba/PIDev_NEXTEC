/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COM.PIDEV.service;

import java.util.List;

/**
 *
 * @author anasl
 */
public interface IService <T> {
    public void ajouter(T t);
    public void modifier(long id_amodifier,T t);
    public void supprimer(long id);
    public List<T> afficher();
    
}
