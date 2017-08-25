/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

/**
 * Clase para representar al Capitan del juego.
 *
 * @author Andres Ante
 * @author Edward Pino
 * @author Juan Xavier Pita
 */
public abstract class Capitan {

    private static final int MOVIMIENTO = 125;
    private int posicionY;
    private int posicionX;
    private ImageView imageCapitan;
    private TipoArma tipoArma;

    public Capitan() {
    }

    public Capitan(int posicionY, int posicionX, String nombreImagen, int altura, int ancho, TipoArma tipoArma, Scene escenaActual) {
        this.posicionY = posicionY;
        this.posicionX = posicionX;
        this.tipoArma = tipoArma;

        try {
            this.imageCapitan = new ImageView(new Image(nombreImagen));
            this.imageCapitan.setFitHeight(altura);
            this.imageCapitan.setFitWidth(ancho);
        } catch (Exception e) {
            System.out.println("No lee imagen");
        }
        

        moveImageCaptainOnKeyPress(escenaActual, imageCapitan);
    }

    private void moveImageCaptainOnKeyPress(Scene scene, final ImageView imageCaptain) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case UP:
                    if (!(imageCaptain.getLayoutY() <= 0)) {
                        imageCaptain.setLayoutY(imageCaptain.getLayoutY() - MOVIMIENTO);
                        System.out.println("SUBE Posicion: " + imageCaptain.getLayoutY());
                    }
                    break;
                case DOWN:
                    if (!(imageCaptain.getLayoutY() >= 500)) {
                        imageCaptain.setLayoutY(imageCaptain.getLayoutY() + MOVIMIENTO);
                        System.out.println("BAJA Posicion: " + imageCaptain.getLayoutY());
                    }
                    break;
//                    case LEFT:    imageCaptain.setLayoutX(imageCaptain.getLayoutX() - MOVIMIENTO); System.out.println("IZQ Posicion: " + imageCaptain.getLayoutX());break;
//                    case RIGHT:   imageCaptain.setLayoutX(imageCaptain.getLayoutX() + MOVIMIENTO); System.out.println("DER Posicion: " + imageCaptain.getLayoutX());break;
            }
        });
    }

    /**
     * Un método abstracto que permite usar el poder.
     */
    public abstract void usarPoder();

    /**
     * Método que devuelve una ImageView del Capitain
     *
     * @return imageCapitan
     */
    public ImageView getImageCapitan() {
        return imageCapitan;
    }

}
