/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 
 * @author Andres Ante
 * @author Edward Pino
 * @author Juan Xavier Pita
 */
public class PaneOrganizer {
    private Scene inicio;
    private Pane root;
    private ImageView iv;
    private Image imagen;
    
    public PaneOrganizer() {
        
    }
    
    public PaneOrganizer(Stage escenario) {
        root = new Pane();
        try{
            imagen= new Image("juegof.jpg");
        }catch(Exception e){System.out.println("No lee imagen ");}
        iv = new ImageView(imagen);
        iv.setFitWidth(820);
        iv.setFitHeight(570);
        
        TitulosLabel titulo = new TitulosLabel("RESGUARDANDO EL TESORO","-fx-font: 40 elephant",450,10,270,30, Color.FIREBRICK, true);
        
        Boton btnNuevoJuego= new Boton("NUEVO JUEGO","-fx-font: 20 century; -fx-background-radius: 30;", 200, 60, 80, 410, 10, Color.DARKSLATEBLUE);
        Boton btnHistorial= new Boton("HISTORIAL","-fx-font: 20 century; -fx-background-radius: 30;", 200, 60, 300, 410, 10, Color.DARKSLATEBLUE);
        Boton btnSalir= new Boton("SALIR","-fx-font: 20 century; -fx-background-radius: 30;", 100, 60, 520, 410, 10, Color.DARKSLATEBLUE);

        root.getChildren().addAll(iv);
        root.getChildren().addAll(titulo.getL(),btnNuevoJuego.getBtn(), btnHistorial.getBtn(), btnSalir.getBtn());
        inicio = new Scene(root, 800, 550);
                
        //Evento de Boton NuevoJuego
        btnNuevoJuego.getBtn().setOnAction(e -> {
            EligeCapitan ec = new EligeCapitan(escenario);
            escenario.setScene(ec.getElegirCapitan());
        });        
        
        //Evento de Boton Historial
        btnHistorial.getBtn().setOnAction(e -> { });
        
        //Evento de Boton Salir
        btnSalir.getBtn().setOnAction(e -> System.exit(0));
        
        
    }   
    
    public Pane getRoot() {
        return root;
    }
    
    public Scene getScene() {
        return inicio;
    }
    
    public void cambioEscena(Stage escenario, Scene escena, Button cambio) {
        cambio.setOnAction(e -> escenario.setScene(escena));
    }
    
    
}
