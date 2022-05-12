/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.pidev.entities.Categorie;
import com.pidev.entities.Intervenant;
import com.pidev.services.ServicesCategorie;
import com.pidev.services.ServicesIntervenant;
import java.util.List;
import java.util.StringTokenizer;


/**
 *
 * @author chedi
 */
public class AjouterCategorie extends Form {
    public AjouterCategorie (){
        setTitle("Ajouter Categorie");
        setLayout(BoxLayout.y());
        
        //ADD RETOUR BUTTON
        Button btnRetour = new Button("retour");
        btnRetour.addActionListener(l->{
        Form listform = new ListCategorie();
        listform.show();
        });
        this.add(btnRetour);
        ////////////////////
       
        TextField Categorie = new TextField("","Categorie");
        Button btnajout = new Button("ajouter");
        
        
      
      
     
        this.addAll(Categorie,btnajout);
      
        btnajout.addActionListener(l->{
            if(catIsValid(Categorie)){
            Categorie cat = new Categorie();
        
        cat.setNomcateg(Categorie.getText());
      
        ServicesCategorie.getInstance().ajoutCategorie(cat);
           Dialog.show("success", "Categorie Ajoute avec success", "ok", "cancel");
        Form listform = new ListCategorie();
        listform.show();
            }
        });
        
        
    }
    
    public boolean catIsValid(TextField Categorie){
        
//cat Checker
        
            if(Categorie.getText().length() == 0){
                Dialog.show("failed", "All fields must be filled", "ok", "cancel");
                return false;
            }

        return true;

    }

    
}
