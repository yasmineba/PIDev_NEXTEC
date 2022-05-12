/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import java.util.List;
import com.codename1.ui.events.ActionListener;
import com.company.utils.Statics;
import com.pidev.entities.Categorie;
import com.pidev.entities.Intervenant;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class ServicesCategorie {
    public ArrayList<Categorie> categorie=new ArrayList();
    
    public static ServicesCategorie instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServicesCategorie() {
         req = new ConnectionRequest();
    }

    public static ServicesCategorie getInstance() {
        if (instance == null) {
            instance = new ServicesCategorie();
        }
        return instance;
    }
    
    
    
    public void deletecategorie(int t) {
        System.out.println("******");
       String url = Statics.BASE_URL+"/categorie/deletecatJSON/"+t;
    
           req.setUrl(url);
            req.setPost(false);
            

 
          req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
     public ArrayList<Categorie>  getAllCategorie(){
   categorie=new ArrayList<Categorie>();
        req = new ConnectionRequest();
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"/categorie/catJSON";
        System.out.println("===>"+url);
        req.setUrl(url);
        req.setPost(false);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
            
                try {
                    
    
                    JSONParser j = new JSONParser();
                    String jsonText =new String(req.getResponseData());
              Map<String,Object> categoriesListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
                 List<Map<String,Object>> listOfMaps = (List<Map<String,Object>>)categoriesListJson.get("root");
                   
                
                    for(Map<String,Object> obj : listOfMaps){
                            
                       Categorie t =new Categorie();

                  t.setIdcateg((int)Float.parseFloat(obj.get("idcateg").toString()));
                  t.setNomcateg(obj.get("nomcateg").toString());
                        
                categorie.add(t);
             
            }
                } catch (Exception ex) {
                    System.out.println("error1");
                }
            
                 
                req.removeResponseListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
     //   System.out.println(formations);
       return categorie;
    }
     
     
     public void ajoutCategorie(Categorie cat)
    {
        String url=Statics.BASE_URL+"/categorie/addJSON/new?nomcateg="+cat.getNomcateg();
        
        req.setUrl(url);
        req.addResponseListener((e) ->{
            String str = new String(req.getResponseData());
            
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
     
     public void modifierCategorie(Categorie catg)
    {
        String url=Statics.BASE_URL+"/categorie/updateJSON/edit?idcateg="+catg.getIdcateg()+"&nomcateg="+catg.getNomcateg();
        
        req.setUrl(url);
        req.addResponseListener((e) ->{
            String str = new String(req.getResponseData());
            
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }


     
}
