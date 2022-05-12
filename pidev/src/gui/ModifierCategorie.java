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

/**
 *
 * @author chedi
 */
public class ModifierCategorie extends Form {
    public ModifierCategorie(Categorie catg){
         setTitle("Modifier Categorie");
        setLayout(BoxLayout.y());
        
        //ADD RETOUR BUTTON
        Button btnRetour = new Button("retour");
        btnRetour.addActionListener(l->{
        Form listform = new ListCategorie();
        listform.show();
        });
        this.add(btnRetour);
        ////////////////////
        
        TextField Categorie = new TextField(catg.getNomcateg(),"Categorie");
      
        
        Button btn = new Button("MODIFIER");
        
      
      
        this.addAll(Categorie,btn);
    
        btn.addActionListener(l->{
             if(catIsValid(Categorie)){
            
        
        catg.setNomcateg(Categorie.getText());
      
      
            ServicesCategorie.getInstance().modifierCategorie(catg);
        
        Dialog.show("success", "Modifiee avec success", "ok", "cancel");
        
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
