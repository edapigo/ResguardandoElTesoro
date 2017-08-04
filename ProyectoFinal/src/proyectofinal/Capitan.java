/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author usuario
 */
public class Capitan extends Jugador{
    
    private Pane figura;
    private int alcance;
    private int posicionY;
    private int posicionX;
    private ImageView imageCapitan;

    public Capitan() {
    }

    
    public Capitan(int alcance, int posicionY, int posicionX, String nombreImagen, int altura, int ancho) {
        this.alcance = alcance;
        this.posicionY = posicionY;
        this.posicionX = posicionX;
        
        this.imageCapitan = new ImageView(new Image(nombreImagen));
        this.imageCapitan.setFitHeight(altura);
        this.imageCapitan.setFitWidth(ancho);
        
        this.figura = new Pane();
        this.figura.getChildren().addAll(this.imageCapitan);
    }

    public ImageView getImageCapitan() {
        return imageCapitan;
    }
    
    
   
}
