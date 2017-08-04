/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Juan Xavier Pita
 */
public class ElTesoroDelPirata extends Application {
    
    @Override
    public void start(Stage stage) {
        PaneOrganize po= new PaneOrganize();
        ElijeCapitan eC = new ElijeCapitan();
        Scene scene = new Scene(eC.getRoot(),480,600);
        stage.setScene(scene);
        stage.setTitle("Resguardando el tesoro");
        
        stage.setResizable(true);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
