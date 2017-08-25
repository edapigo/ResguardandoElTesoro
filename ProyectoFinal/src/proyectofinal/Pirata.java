/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author Juan Xavier Pita
 */
public class Pirata extends Thread {

    // ESTA CLASE VA A GENERAR LOS PIRATAS
    private Jugador player;
    private int posX;
    private int posY;
    private ImageView pirata;
    private boolean finPartida;

    public Pirata() {

    }

    // DIMENSIONES DEL PIRATA = ANCHO -> 90 | ALTO -> 120
    public Pirata(String nombreImagen, int posX, int posY, boolean finPartida, Jugador player) {
        this.posX = posX;
        this.posY = posY;
        this.player = player;
        this.finPartida = finPartida;

        try {
            pirata = new ImageView(new Image(nombreImagen));
            pirata.setFitWidth(90);
            pirata.setFitHeight(120);
            pirata.setLayoutX(posY);
            pirata.setLayoutY(posY);
        } catch (Exception e) {
            System.out.println("No lee imagen");
        }
    }

    @Override
    public void run() {
        while(!(pirata.getLayoutX() <=-80)){
            try {

                Platform.runLater(() -> {
                    pirata.setLayoutX(pirata.getLayoutX()-15);
                    System.out.println("POSICION PIRATAS: " + pirata.getLayoutX());
                });
                Thread.sleep(400/player.getDificultad().getVelocidad());//ARREGLAR
            } catch (InterruptedException e) {
                System.out.println("Se ha interrumpido el proceso");
            }
        }

    }

    public Jugador getPlayer() {
        return player;
    }

    public void setPlayer(Jugador player) {
        this.player = player;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public ImageView getPirata() {
        return pirata;
    }

    public void setPirata(ImageView pirata) {
        this.pirata = pirata;
    }

    public boolean isFinPartida() {
        return finPartida;
    }

    public void setFinPartida(boolean finPartida) {
        this.finPartida = finPartida;
    }

    public void adjuntarPirata(Pane pane) {
        this.pirata.setLayoutX(this.getPosX());
        this.pirata.setLayoutY(this.getPosY());
        pane.getChildren().add(this.pirata);
    }

}
