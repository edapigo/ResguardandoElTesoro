/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author Estudiante
 */
public class PaneOrganize {
    private Pane root;
    private ImageView iv;
    private Image imagen;
    
    public PaneOrganize(){
        root = new Pane();
        try{
            imagen= new Image("juegof.jpg");
        }catch(Exception e){System.out.println("No lee imagen ");}
        iv = new ImageView(imagen);
        iv.setFitWidth(1020);
        iv.setFitHeight(770);
        
        TitulosLabel titulo = new TitulosLabel("TYPERSHARK","-fx-font: 40 elephant",450,10,270,30, Color.DARKGRAY);
        
        Button btnNuevoJuego = new Button("Nuevo Juego");
        Button btnHistorial = new Button("Historial de jugadores");
        Button btnSalir = new Button("Salir");
        
        
        

        root.getChildren().addAll(iv);
        
    }
    
    
    public Pane getRoot() {
        return root;
    }
    
    
}
