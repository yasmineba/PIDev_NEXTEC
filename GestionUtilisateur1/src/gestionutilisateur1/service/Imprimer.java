/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionutilisateur1.service;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Properties;

/**
 *
 * @author MSI
 */


class MonDessin extends JPanel  {
    MonDessin() {
	setPreferredSize(new Dimension(180, 120));
    }
    
}
public class Imprimer extends JFrame implements  ActionListener {  
    MonDessin dessin = new MonDessin();
    JButton imprimer = new JButton("imprimer");
    JRadioButton choixTout = new JRadioButton("tout", true);
    JRadioButton choixDessin = new JRadioButton("dessin", false);
    
    public Imprimer() {
	ButtonGroup choix = new ButtonGroup();
	choix.add(choixTout);
	choix.add(choixDessin);
	
	JPanel p = new JPanel();
	
	
	
	add(imprimer, BorderLayout.SOUTH);

	imprimer.addActionListener(this);

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	pack();
	setVisible(true);	
    }
    
    public void actionPerformed(ActionEvent e) {
	Properties props = new Properties();
	
	props.setProperty("awt.print.paperSize", "a4");
	props.setProperty("awt.print.destination", "printer");
	
	PrintJob demandeDImpression = getToolkit().getPrintJob(this, "Impression", props);
	if (demandeDImpression != null) {
	    Graphics gImpr = demandeDImpression.getGraphics();
	    if (choixTout.isSelected()) printAll(gImpr);
	    else dessin.printAll(gImpr);
	    gImpr.dispose();
	    demandeDImpression.end();
	    
	}
    }
}
