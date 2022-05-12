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


/**
 *
 * @author chedi
 */
public class Mainwindow extends Form {
    public Mainwindow (){
        setTitle("Ethlete");
        
        Button intervenantsBtn = new Button("Intervenants");
        Button categoriesBtn = new Button("Categories");

      
      
        this.setLayout(BoxLayout.y());
        this.addAll(intervenantsBtn,categoriesBtn);
      
        intervenantsBtn.addActionListener(l->{    
        Form listform = new ListIntervenant();
        listform.show();
        });
        categoriesBtn.addActionListener(l->{    
        Form listform = new ListCategorie();
        listform.show();
        });


    }
    
}
