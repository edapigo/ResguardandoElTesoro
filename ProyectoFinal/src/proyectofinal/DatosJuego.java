/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
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
    private Image imagen;
    private ImageView iv;
    
    public DatosJuego() {
        
    }
    
    public DatosJuego(Stage escenario) {
        this.tiempo = "";
        this.fecha = "";
        this.nivel = 1;
        this.root = new BorderPane();
        
        
        try{
            imagen= new Image("fondoJuego.jpg");
        }catch(Exception e){System.out.println("No lee imagen ");}
        iv = new ImageView(imagen);
        iv.setFitHeight(570);
        iv.setFitWidth(910);
        
        this.root.getChildren().add(iv);
        partida = new Scene(this.root, 800, 550);
        
    }    
    
    public DatosJuego(Stage escenario, String tiempo, String fecha, int nivel, BorderPane root) {
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
