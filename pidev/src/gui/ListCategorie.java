/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.pidev.entities.Categorie;
import com.pidev.services.ServicesCategorie;

import java.util.ArrayList;

/**
 *
 * @author chedi
 */
public class ListCategorie extends Form {
    public ListCategorie(){
    ArrayList<Categorie> list = ServicesCategorie.getInstance().getAllCategorie();
        System.out.println(list);
            
        setTitle("Afficher Categories");
        setLayout(BoxLayout.y());
        
        
        //BTN RETOUR
        Button btnRetour = new Button("retour");
        btnRetour.addActionListener(eva->{
        Form ajoutform = new Mainwindow();
        ajoutform.show();
        });
        this.add(btnRetour);
        ///////////////////

        for (Categorie catg :list)
        {
            
            this.add(create(catg));
        }
        Button btnajout = new Button("AJOUTER UNE CATEGORIE");
        btnajout.addActionListener(eva->{
        Form ajoutform = new AjouterCategorie();
        ajoutform.show();
        });
        this.add(btnajout);
    }
    public Container create(Categorie catg)
    {
    Label Categorie = new Label("Categorie = " + catg.getNomcateg());
   
        Button modif = new Button("Modifier");
        Button supp = new Button("Supprimer");
        modif.addActionListener(ev->{
        Form modifform=new ModifierCategorie(catg);
        modifform.show();
        });
    supp.addActionListener(e->{
    ServicesCategorie.getInstance().deletecategorie(catg.getIdcateg());
    Dialog.show("Success", "Supprimer Avec Success", "ok","cancel");
    Form listform = new ListCategorie();
    listform.show();
    });
    
    return new Container(BoxLayout.yCenter()).addAll(Categorie,modif,supp);
    }
    
    
    
}
