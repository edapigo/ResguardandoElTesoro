/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Clase para representar la bala del capitan;
 * @author Dennise Guizado
 * @author Edward Pino
 * @author Xavier Pesantes
 */
public class Bala extends Thread {
    private int posicionX;
    private int posicionY;
    private ImageView imagenBala;
    private boolean finBala;
    
    public Bala(String nombreImagen, int posX, int posY, boolean finBala) {
        this.posicionX = posX;
        this.posicionY = posY;
        this.finBala = finBala;
        
        try {
            imagenBala = new ImageView(new Image(nombreImagen));
        } catch (Exception e) {
            System.out.println("No lee imagen");
        }    
        

        
        try {
            imagenBala = new ImageView(new Image(nombreImagen));
            imagenBala.setFitHeight(30);
            imagenBala.setFitWidth(40);
            imagenBala.setLayoutX(posX);
            imagenBala.setLayoutY(posY);
            
        } catch (Exception e) {
            System.out.println("No lee imagen");
        }        
    }
    
    @Override
    public void run() {
        
        try {
            while(imagenBala.getLayoutX() != 1000){
//                this.setPosicionX(this.getPosicionX());

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        imagenBala.setLayoutX(imagenBala.getLayoutX() + 15);
                        System.out.println("Bala: " + imagenBala.getLayoutX());
                    }
                });
                Thread.sleep(150);
            }
        } catch (InterruptedException e) {
            System.out.println("C mamut\nC equivoco\n");
        }
       
        
    }

    /**
     * Método 
     * @return
     */
    public int getPosicionX() {
        return posicionX;
    }

    /**
     *
     * @param posicionX
     */
    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    /**
     *
     * @return
     */
    public int getPosicionY() {
        return posicionY;
    }

    /**
     *
     * @param posicionY
     */
    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    /**
     *
     * @return
     */
    public ImageView getImagenBala() {
        return imagenBala;
    }

    /**
     *
     * @param imagenBala
     */
    public void setImagenBala(ImageView imagenBala) {
        this.imagenBala = imagenBala;
    }
    
    
    
    
}
