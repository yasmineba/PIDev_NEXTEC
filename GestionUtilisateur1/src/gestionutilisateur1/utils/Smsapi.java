/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionutilisateur1.utils;

import com.twilio.Twilio;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
/**
 *
 * @author MSI
 */
public class Smsapi {
    public static final String ACCOUNT_SID = "AC68d4b1a9a27586d27aa6f9410dde36f5";
    public static final String AUTH_TOKEN = "3cf893f5dadd191a2489feae35d0eb3d";

    public static void sendSMS(String num, String msg) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(/*num ili bch yjih il msg */new PhoneNumber("+21624030100"),new PhoneNumber("+14439032479"), msg).create();

        System.out.println(message.getSid());

    }
}
