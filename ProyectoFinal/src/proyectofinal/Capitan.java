/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

/**
 * 
 * @author Andres Ante
 * @author Edward Pino
 * @author Juan Xavier Pita
 */
public abstract class Capitan {
    
    
    private static final int      MOVIMIENTO = 5;
    private static final Duration DURACION = Duration.seconds(0.25);
    private int posicionY;
    private int posicionX;
    private ImageView imageCapitan;
    private TipoArma tipoArma;

    public Capitan() {
    }

    
    public Capitan(int posicionY, int posicionX, String nombreImagen, int altura, int ancho, TipoArma tipoArma,Scene escenaActual) {
        this.posicionY = posicionY;
        this.posicionX = posicionX;
        this.tipoArma = tipoArma;
        
        this.imageCapitan = new ImageView(new Image(nombreImagen));
        this.imageCapitan.setFitHeight(altura);
        this.imageCapitan.setFitWidth(ancho);
       
        final TranslateTransition transition = createTranslateTransition(imageCapitan);
        
        moveCircleOnKeyPress(escenaActual, imageCapitan);
    }
    
    private TranslateTransition createTranslateTransition(final ImageView circle) {
    final TranslateTransition transition = new TranslateTransition(DURACION, circle);
    transition.setOnFinished(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent t) {
        circle.setLayoutX(circle.getTranslateX() + circle.getLayoutX());
        circle.setLayoutY(circle.getTranslateY() + circle.getLayoutY());
        
        circle.setTranslateX(0);
        circle.setTranslateY(0);
      }
    });
    return transition;
  }

    private void moveCircleOnKeyPress(Scene scene, final ImageView circle) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
          @Override public void handle(KeyEvent event) {
            switch (event.getCode()) {
              case UP:    circle.setLayoutY(circle.getLayoutY() - MOVIMIENTO); System.out.println("SUBE");break;
              case DOWN:  circle.setLayoutY(circle.getLayoutY() + MOVIMIENTO); System.out.println("BAJA");break;
            }
          }
        });
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
