package services;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail
{
 public static void mailing(String recep, String contenu, String objet) throws Exception{
     
     System.out.println("preparing to send");
     Properties properties=new Properties();
     
     properties.put("mail.smtp.auth","true");
     properties.put("mail.smtp.starttls.enable","true");
     properties.put("mail.smtp.host","smtp.gmail.com");
     properties.put("mail.smtp.port","587");
     
     
     String myAccountEmail="rmatoussi3@gmail.com";
     String password="rihem1234";
     
     Session session= Session.getInstance(properties, new Authenticator() {
         @Override
     protected PasswordAuthentication getPasswordAuthentication(){
         return new PasswordAuthentication(myAccountEmail, password);
     }
     
      });
     
     
     Message message= prepareMessage(session,myAccountEmail,recep,contenu,objet);
     Transport.send(message);
     System.out.println("Message sent!");
     
     
 
 
 }

    private static Message prepareMessage(Session session, String myAccountEmail, String recep,String objet,String contenu) {
       try{
       Message message= new MimeMessage(session);
       message.setFrom(new InternetAddress(myAccountEmail));
       message.setRecipient(Message.RecipientType.TO, new InternetAddress(recep));
       message.setSubject(objet);
       message.setText(contenu);
       return message;
       }catch( Exception ex){ 
           Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
       }
     return null;
    }
   
     
}


