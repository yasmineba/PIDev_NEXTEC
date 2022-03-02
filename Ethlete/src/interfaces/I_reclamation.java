/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Connection;
import java.util.List;
import javafx.scene.chart.BarChart;
import models.Reclamation;
import util.DataSource;

/**
 *
 * @author ASUS
 */
public interface I_reclamation {
    Connection cnx= DataSource.getInstance().getCnx();
    
    public boolean ajouterReclamation(Reclamation r);

    public List<Reclamation> afficherReclamations();

    public boolean modifierReclamation(Reclamation r);

    public boolean supprimerReclamation(Reclamation r);
    
    public int nombreReclamation();
  
}
