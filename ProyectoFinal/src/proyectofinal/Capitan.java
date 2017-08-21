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
 * @author Andres Ante
 * @author Edward Pino
 * @author Juan Xavier Pita
 */
public abstract class Capitan {
    
    private Pane figura;
    private int alcance;
    private int posicionY;
    private int posicionX;
    private ImageView imageCapitan;
    private TipoArma tipoArma;

    public Capitan() {
    }

    
    public Capitan(int alcance, int posicionY, int posicionX, String nombreImagen, int altura, int ancho, TipoArma tipoArma) {
        this.alcance = alcance;
        this.posicionY = posicionY;
        this.posicionX = posicionX;
        this.tipoArma = tipoArma;
        
        this.imageCapitan = new ImageView(new Image(nombreImagen));
        this.imageCapitan.setFitHeight(altura);
        this.imageCapitan.setFitWidth(ancho);
        
        this.figura = new Pane();
        this.figura.getChildren().addAll(this.imageCapitan);
    }
    
    /**
     *  Un método abstracto que permite usar el poder.
     */
    public abstract void usarPoder();

    /**
     *
     * @return
     */
    public ImageView getImageCapitan() {
        return imageCapitan;
    }
    
    
   
}
