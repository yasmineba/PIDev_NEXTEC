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
import com.pidev.entities.Intervenant;
import com.pidev.services.ServicesIntervenant;

import java.util.ArrayList;

/**
 *
 * @author chedi
 */
public class ListIntervenant extends Form {
    public ListIntervenant(){
    ArrayList<Intervenant> list = ServicesIntervenant.getInstance().getAllIntervenants();
        System.out.println(list);
            
        setTitle("Afficher Intervenants");
        setLayout(BoxLayout.y());
        
        //BTN RETOUR
        Button btnRetour = new Button("retour");
        btnRetour.addActionListener(eva->{
        Form ajoutform = new Mainwindow();
        ajoutform.show();
        });
        this.add(btnRetour);
        ///////////////////
        
        
        for (Intervenant inter :list)
        {
            
            this.add(create(inter));
        }
        Button btnajout = new Button("AJOUTER UN INTERVENANT");
        btnajout.addActionListener(eva->{
        Form ajoutform = new AjouterIntervenant();
        ajoutform.show();
        });
        this.add(btnajout);
    }
    public Container create(Intervenant inter)
    {
    Label Nom = new Label("Nom = " + inter.getNom());
    Label Prenom = new Label("Prenom = " + inter.getPrenom());
    Label Email = new Label ("Email = "+ inter.getEmail());
    Label Type = new Label ("Type = "+ inter.getId_typeint());
    Label Telephone = new Label ("Telephone = "+ inter.getTelephone());
        Button modif = new Button("Modifier");
        Button supp = new Button("Supprimer");
        modif.addActionListener(ev->{
        Form modifform=new ModifierIntervenant(inter);
        modifform.show();
        });
    supp.addActionListener(e->{
    ServicesIntervenant.getInstance().deleteintervenant(inter.getId_inter());
    Dialog.show("Success", "Supprimer Avec Success", "ok","cancel");
    Form listform = new ListIntervenant();
    listform.show();
    });
    
    return new Container(BoxLayout.yCenter()).addAll(Nom,Prenom,Email,Type,Telephone,modif,supp);
    }
    
}
