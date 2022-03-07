/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import models.CompetitionData;
import models.User;
import java.io.FileWriter;
import java.io.IOException;
import services.IPdf;

/**
 *
 * @author Kernel
 */
public class servicePDF implements IPdf {

    @Override
    public void pdfWrite() {
        CompetitionData cmData = CompetitionData.getInstance();
        
        String items = "";
        for (int i = 0; i < cmData.getProds().size(); i++) {
            items += "	<tr class=\"item\">\n"
                    + "					<td>"+ cmData.getProds().get(i).getTitre() +"</td>\n"
                    + "\n"
                    + "					<td> "+ cmData.getProds().get(i).getPrix() + " </td>\n"
                    + "				</tr>";
        }
        
     
         float somme =0;
        for (int i = 0; i < cmData.getProds().size() ; i++)
        {
            somme+= cmData.getProds().get(i).getPrix();
        }
        String page ="<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"	<head>\n" +
"		<meta charset=\"utf-8\" />\n" +
"		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n" +
"\n" +
"		<title>A simple, clean, and responsive HTML invoice template</title>\n" +
"\n" +
"		<!-- Favicon -->\n" +
"		<link rel=\"icon\" href=\"./images/favicon.png\" type=\"image/x-icon\" />\n" +
"\n" +
"		<!-- Invoice styling -->\n" +
"		<style>\n" +
"			body {\n" +
"				font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;\n" +
"				text-align: center;\n" +
"				color: #777;\n" +
"			}\n" +
"\n" +
"			body h1 {\n" +
"				font-weight: 300;\n" +
"				margin-bottom: 0px;\n" +
"				padding-bottom: 0px;\n" +
"				color: #000;\n" +
"			}\n" +
"\n" +
"			body h3 {\n" +
"				font-weight: 300;\n" +
"				margin-top: 10px;\n" +
"				margin-bottom: 20px;\n" +
"				font-style: italic;\n" +
"				color: #555;\n" +
"			}\n" +
"\n" +
"			body a {\n" +
"				color: #06f;\n" +
"			}\n" +
"\n" +
"			.invoice-box {\n" +
"				max-width: 800px;\n" +
"				margin: auto;\n" +
"				padding: 30px;\n" +
"				border: 1px solid #eee;\n" +
"				box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);\n" +
"				font-size: 16px;\n" +
"				line-height: 24px;\n" +
"				font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;\n" +
"				color: #555;\n" +
"			}\n" +
"\n" +
"			.invoice-box table {\n" +
"				width: 100%;\n" +
"				line-height: inherit;\n" +
"				text-align: left;\n" +
"				border-collapse: collapse;\n" +
"			}\n" +
"\n" +
"			.invoice-box table td {\n" +
"				padding: 5px;\n" +
"				vertical-align: top;\n" +
"			}\n" +
"\n" +
"			.invoice-box table tr td:nth-child(2) {\n" +
"				text-align: right;\n" +
"			}\n" +
"\n" +
"			.invoice-box table tr.top table td {\n" +
"				padding-bottom: 20px;\n" +
"			}\n" +
"\n" +
"			.invoice-box table tr.top table td.title {\n" +
"				font-size: 45px;\n" +
"				line-height: 45px;\n" +
"				color: #333;\n" +
"			}\n" +
"\n" +
"			.invoice-box table tr.information table td {\n" +
"				padding-bottom: 40px;\n" +
"			}\n" +
"\n" +
"			.invoice-box table tr.heading td {\n" +
"				background: #eee;\n" +
"				border-bottom: 1px solid #ddd;\n" +
"				font-weight: bold;\n" +
"			}\n" +
"\n" +
"			.invoice-box table tr.details td {\n" +
"				padding-bottom: 20px;\n" +
"			}\n" +
"\n" +
"			.invoice-box table tr.item td {\n" +
"				border-bottom: 1px solid #eee;\n" +
"			}\n" +
"\n" +
"			.invoice-box table tr.item.last td {\n" +
"				border-bottom: none;\n" +
"			}\n" +
"\n" +
"			.invoice-box table tr.total td:nth-child(2) {\n" +
"				border-top: 2px solid #eee;\n" +
"				font-weight: bold;\n" +
"			}\n" +
"\n" +
"			@media only screen and (max-width: 600px) {\n" +
"				.invoice-box table tr.top table td {\n" +
"					width: 100%;\n" +
"					display: block;\n" +
"					text-align: center;\n" +
"				}\n" +
"\n" +
"				.invoice-box table tr.information table td {\n" +
"					width: 100%;\n" +
"					display: block;\n" +
"					text-align: center;\n" +
"				}\n" +
"			}\n" +
"		</style>\n" +
"	</head>\n" +
"\n" +
"	<body>\n" +
"		<h1>A simple, clean, and responsive HTML invoice template</h1>\n" +
"		<h3>Because sometimes, all you need is something simple.</h3>\n" +
"		Find the code on <a href=\"https://github.com/sparksuite/simple-html-invoice-template\">GitHub</a>. Licensed under the\n" +
"		<a href=\"http://opensource.org/licenses/MIT\" target=\"_blank\">MIT license</a>.<br /><br /><br />\n" +
"\n" +
"		<div class=\"invoice-box\">\n" +
"			<table>\n" +
"				<tr class=\"top\">\n" +
"					<td colspan=\"2\">\n" +
"						<table>\n" +
"							<tr>\n" +
"								<td class=\"title\">\n" +
"									<img src=\"./images/logo.png\" alt=\"Company logo\" style=\"width: 100%; max-width: 300px\" />\n" +
"								</td>\n" +
"\n" +
"								<td>\n" +
"									Invoice #: 123<br />\n" +
"									Created: January 1, 2015<br />\n" +
"									Due: February 1, 2015\n" +
"								</td>\n" +
"							</tr>\n" +
"						</table>\n" +
"					</td>\n" +
"				</tr>\n" +
"\n" +
"				<tr class=\"information\">\n" +
"					<td colspan=\"2\">\n" +
"						<table>\n" +
"							<tr>\n" +
"								<td>\n" +
"									Sparksuite, Inc.<br />\n" +
"									12345 Sunny Road<br />\n" +
"									Sunnyville, TX 12345\n" +
"								</td>\n" +
"\n" +
"								<td>\n" +
"									Acme Corp.<br />\n" +
"									John Doe<br />\n" +
"									john@example.com\n" +
"								</td>\n" +
"							</tr>\n" +
"						</table>\n" +
"					</td>\n" +
"				</tr>\n" +
"\n" +
"				<tr class=\"heading\">\n" +
"					<td>Payment Method</td>\n" +
"\n" +
"					<td>Check #</td>\n" +
"				</tr>\n" +
"\n" +
"				<tr class=\"details\">\n" +
"					<td>Check</td>\n" +
"\n" +
"					<td>1000</td>\n" +
"				</tr>\n" +
"\n" +
"				<tr class=\"heading\">\n" +
"					<td>Item</td>\n" +
"\n" +
"					<td>Price</td>\n" +
"				</tr>\n" +
"\n" + items+
"				 \n" +
"				<tr class=\"total\">\n" +
"					<td></td>\n" +
"\n" +
"					<td>Total: "+ somme + " DT </td>\n" +
"				</tr>\n" +
"			</table>\n" +
"		</div>\n" +
"	</body>\n" +
"</html>";
        User sd = User.getInstance();
       
        String location = "C:\\wamp64\\www\\assets\\factures\\facture_"+sd.getNom()+"_"+sd.getPrenom()+".html";
        try {
            FileWriter myWriter = new FileWriter(location);
            myWriter.write(page);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void pdfsend(String file) {

    }

}
