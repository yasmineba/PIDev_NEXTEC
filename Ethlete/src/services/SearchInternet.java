/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.itextpdf.text.Element;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.lang.model.util.Elements;
import org.jsoup.Jsoup;

/**
 *
 * @author ASUS
 */
public class SearchInternet {
    
    public static void main(String[] args) throws IOException
    {
        Scanner scan= new Scanner(System.in);
        System.out.println("please provide keyword");
        String keyword = scan.nextLine();
        
        String url="https://www.google.com/search" +"?qa"+ keyword;
        
        org.jsoup.nodes.Document doc= Jsoup.connect(url).get();
        String html= doc.html();
        
        Files.write(Paths.get("C:\\Users\\ASUS\\googlesearch.txt"),html.getBytes());
        
        org.jsoup.select.Elements links =  doc.select("");
        
        for (org.jsoup.nodes.Element link : links){
            System.out.println(link.text());
           }
        
        
        
        scan.close();
        
    
    }
}
