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
import com.pidev.entities.Intervenant;
import com.pidev.services.ServicesIntervenant;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author chedi
 */
public class ModifierIntervenant extends Form {
    public ModifierIntervenant(Intervenant inter){
         setTitle("Modifier Intervenant");
        setLayout(BoxLayout.y());
        
        //ADD RETOUR BUTTON
        Button btnRetour = new Button("retour");
        btnRetour.addActionListener(l->{
        Form listform = new ListIntervenant();
        listform.show();
        });
        this.add(btnRetour);
        ////////////////////
        
        
        TextField Nom = new TextField(inter.getNom(),"Nom");
        TextField Prenom = new TextField(inter.getPrenom(),"Prenom");
        TextField Email = new TextField(inter.getEmail(),"email@host");
        TextField Type = new TextField(inter.getId_typeint(),"Type");
        TextField Telephone = new TextField(String.valueOf(inter.getTelephone()),"Telephone");
        Button btn = new Button("MODIFIER");
        
      
      
        this.addAll(Nom,Prenom,Email,Type,Telephone,btn);
    
        btn.addActionListener(l->{
            List<TextField> other = new ArrayList<>();
      other.add(Nom);
      other.add(Prenom);
      other.add(Email);
      other.add(Type);
      other.add(Telephone);

            if(interIsValid(Email,Telephone, other)){
            
        
        inter.setId_inter(inter.getId_inter());
        inter.setNom(Nom.getText());
        inter.setPrenom(Prenom.getText());
        inter.setEmail(Email.getText());
        inter.setId_typeint(Type.getText());
        
        inter.setTelephone(Integer.parseInt(Telephone.getText()));
      
        ServicesIntervenant.getInstance().modifierIntervenant(inter);
        
        Dialog.show("success", "Modifiee avec success", "ok", "cancel");
        
        Form listform = new ListIntervenant();
    listform.show();
            }
        });
    }
    
    public boolean interIsValid(TextField Email, TextField Telephone, List<TextField> other){
        
//other Checker
        for(TextField tf : other){
            if(tf.getText().length() == 0){
                Dialog.show("failed", "All fields must be filled", "ok", "cancel");
                return false;
            }
        }
        
        //Email checker
        StringTokenizer emailTokens = new StringTokenizer(Email.getText(), "@");
        if(emailTokens.countTokens() != 2){
            Dialog.show("failed", "Email must be in the correct form", "ok", "cancel");
            return false;
        }
        
        //telephone checker
        String teleph = Telephone.getText();
        if(teleph.length()!=8){
            Dialog.show("failed", "Telephone must contain 8 digits", "ok", "cancel");
            return false;

        }
        try {
        Integer.parseInt( teleph );
        }
        catch( Exception e ) {
        Dialog.show("failed", "Telephone must be a number", "ok", "cancel");
        return false;
        }

        
        return true;

    }

}
