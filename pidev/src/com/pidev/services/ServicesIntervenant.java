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

import com.codename1.ui.events.ActionListener;
import com.company.utils.Statics;
import com.pidev.entities.Intervenant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 *
 * @author ASUS
 */
public class ServicesIntervenant {
     public ArrayList<Intervenant> intervenant=new ArrayList();
    
    public static ServicesIntervenant instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServicesIntervenant() {
         req = new ConnectionRequest();
    }

    public static ServicesIntervenant getInstance() {
        if (instance == null) {
            instance = new ServicesIntervenant();
        }
        return instance;
    }
    
    
    
     public void deleteintervenant(int t) {
        
       String url = Statics.BASE_URL+ "/intervenant/deleteJSON/"+t;
    
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
     
     public ArrayList<Intervenant>  getAllIntervenants(){
   intervenant=new ArrayList<Intervenant>();
        req = new ConnectionRequest();
 
        String url = Statics.BASE_URL+"/intervenant/IntJSON";
     
        req.setUrl(url);
        req.setPost(false);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
            
                try {
                    
    
                   // System.out.println(new String(req.getResponseData()));
                    JSONParser j = new JSONParser();
                    String jsonText =new String(req.getResponseData());
              Map<String,Object> intervenantsListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
                 List<Map<String,Object>> listOfMaps = (List<Map<String,Object>>)intervenantsListJson.get("root");
                
                for(Map<String, Object> obj : listOfMaps){                           
                       Intervenant t =new Intervenant();

                  t.setId_inter((int)Float.parseFloat(obj.get("idInter").toString()));
                  t.setImage_In(obj.get("imageIn").toString());
                  t.setNom(obj.get("nom").toString());
                  t.setPrenom(obj.get("prenom").toString());
                  t.setId_typeint(obj.get("idTypeint").toString());
                  t.setEmail(obj.get("email").toString());
                  t.setTelephone((int)Float.parseFloat(obj.get("telephone").toString()));
         
                
               
    
                intervenant.add(t);
             
            }
                } catch (Exception ex) {
                    System.out.println("error1");
                }
            
                 
                req.removeResponseListener(this);
            }
        });
                          
        NetworkManager.getInstance().addToQueueAndWait(req);

       return intervenant;
    }
     
     
     
     public void ajoutIntervenant(Intervenant inter)
    {
        String url=Statics.BASE_URL+"/intervenant/addJSON/add?nom="+inter.getNom()+"&prenom="+inter.getPrenom()+"&email="+inter.getEmail()+"&telephone="+inter.getTelephone()+"&type="+inter.getId_typeint();
        
        req.setUrl(url);
        req.addResponseListener((e) ->{
            String str = new String(req.getResponseData());
            
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
     
     public void modifierIntervenant(Intervenant inter)
    {
        String url=Statics.BASE_URL+"/intervenant/UpdateJSON/edit?id="+inter.getId_inter()+"&nom="+inter.getNom()+"&prenom="+inter.getPrenom()+"&email="+inter.getEmail()+"&telephone="+inter.getTelephone()+"&type="+inter.getId_typeint();
        
        req.setUrl(url);
        req.addResponseListener((e) ->{
            String str = new String(req.getResponseData());
            
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
     
    

     
}
