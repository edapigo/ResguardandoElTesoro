/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Una clase para representar la pantalla de juego.
 * @author Andres Ante
 * @author Edward Pino
 * @author Juan Xavier Pita
 */
public class DatosJuego {
    
    private Scene partida;
    private String tiempo;//LABEL
//    private int monedas; LABEL
    private String fecha;
    private int nivel;// LABEL
    private BorderPane root;
    private Image imagen,imagenFondo;
    private ImageView iv,ivf;
    
    public DatosJuego() {
        
    }
    
    public DatosJuego(Stage escenario) {
        this.tiempo = "";
        this.fecha = "";
        this.nivel = 1;
        this.root = new BorderPane();
        
        // CENTRO
        Pane centro = new Pane();
         try{
            imagen= new Image("fondoJuego.jpg");
        }catch(Exception e){System.out.println("No lee imagen ");}
        iv = new ImageView(imagen);
        iv.setFitHeight(490);
        iv.setFitWidth(800);
        
        centro.getChildren().add(iv);
        
        // BOTTOM
        HBox botones = new HBox();
        botones.setSpacing(20);
        botones.setPadding(new Insets(0, 0, 0, 300));   // top, right, bottom, left
        
        Boton btnNext = new Boton("Siguiente","-fx-font: 20 century; -fx-background-radius: 30;", 200, 60, 520, 410, 10, Color.DARKSLATEBLUE);
        Boton btnBack = new Boton("Atrás","-fx-font: 20 century; -fx-background-radius: 30;", 200, 60, 520, 410, 10, Color.DARKSLATEBLUE);
        
        botones.getChildren().addAll(btnNext.getBtn(), btnBack.getBtn());
        
       
        // TOP
        TitulosLabel nombreJugador = new TitulosLabel("Nombre: ","-fx-font: 25 elephant",275,10,270,30, Color.GOLD,false);
        
         try{
            imagenFondo= new Image("fondo2.png");
        }catch(Exception e){System.out.println("No lee imagen ");}
        ivf= new ImageView(imagenFondo);
        ivf.setFitHeight(550);
        ivf.setFitWidth(800);
        
        
        
        root.getChildren().add(ivf);
        root.setCenter(centro);
        root.setBottom(botones);
//        root.getBottom().setStyle("-fx-background-color: #DAA520");
        partida = new Scene(root, 800, 550);
        
    }    
    
    public DatosJuego(String tiempo, String fecha, int nivel, BorderPane root) {
        this.tiempo = tiempo;
        this.fecha = fecha;
        this.nivel = nivel;
        this.root = root;
    }
    
    public Scene getPartida() {
        return partida;
    }
    
    public String getTiempo() {
        return tiempo;
    }
    
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getFecha() {
        return fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNivel() {
         return nivel;
    }
    
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }
    
    
}
