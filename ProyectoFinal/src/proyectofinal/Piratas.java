/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author Juan Xavier Pita
 */
public class Piratas extends Thread {

    // ESTA CLASE VA A GENERAR LOS PIRATAS
    private int posX;
    private int posY;
    private int ancho;
    private int alto;
    private boolean finPartida;

    public Piratas() {

    }

    public Piratas(Image imPirata, int posX, int posY, int ancho, int alto, boolean finPartida) {
        this.posX = posX;
        this.posY = posY;
        this.ancho = ancho;
        this.alto = alto;
        this.finPartida = finPartida;
        
        try {
            imPirata = new Image("pirata.png");
        } catch (Exception e) {
            System.out.println("No lee imagen");
        }
        ImageView iv = new ImageView(imPirata);
        
        
    }

    @Override
    public void run() {
        

    }

}
