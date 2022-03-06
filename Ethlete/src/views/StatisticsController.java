/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class StatisticsController implements Initializable {

    @FXML
    private NumberAxis nombre;
    @FXML
    private CategoryAxis raison;
    @FXML
    private BarChart<String,Number> barchart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series<String,Number> series= new XYChart.Series<>();
        series.setName("Raisons de reclamation");
        series.getData().add(new XYChart.Data<>("probleme de connexion",63));
        series.getData().add(new XYChart.Data<>("probleme ",2));
        series.getData().add(new XYChart.Data<>("probleme e connexion",10));
        series.getData().add(new XYChart.Data<>("probleme de conexion",103));
        
        
        
        barchart.getData().add(series);
        
    }    
    
}
