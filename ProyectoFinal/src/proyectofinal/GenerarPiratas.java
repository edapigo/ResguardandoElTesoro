/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.layout.Pane;

/**
 *
 * @author Juan Xavier Pita
 */
public class GenerarPiratas extends Thread {

    private Pane pane;
    private Queue<Pirata> piratasAlmacenados;
    private ArrayList<Pirata> piratasEnJuego;
    private int[] posiciones = {0, 125, 250, 375, 500};
    private Pirata pirata;
    private Jugador player;
    private boolean finPartida;

    public GenerarPiratas(Pane pane, Queue<Pirata> piratas, boolean finPartida, Jugador player) {
        this.pane = pane;
        this.piratasAlmacenados = piratas;
        this.piratasEnJuego = new ArrayList<>();
        this.player = player;
        this.finPartida = finPartida;
    }

    @Override
    public void run() {
//        while (finPartida == false) {
            if (piratasAlmacenados.isEmpty()) {//this.player.getDificultad().getNumPiratas()
                for (int i = 0; i < player.getDificultad().getNumPiratas(); i++) {//ARREGLAR
                    int posicion = (int) (Math.random()*5);
//                    System.out.println("LENGHT::" +posiciones.length);
//                    System.out.println("POSICION ALEATORIA: " + posicion);
                    pirata = new Pirata("Pirata.png", 1030, posiciones[posicion], finPartida, player);
                    piratasAlmacenados.add(pirata);
                }
                System.out.println(piratasAlmacenados+ " Tamaño :" +piratasAlmacenados.size());
            }

            Platform.runLater(() -> {
                try {
                    if (piratasEnJuego.isEmpty()) {
                        piratasEnJuego.add(piratasAlmacenados.poll());
                        piratasEnJuego.add(piratasAlmacenados.poll());
                       

                        for (int i = 0; i < (piratasEnJuego.size()); i++) {
                            piratasEnJuego.get(i).adjuntarPirata(pane);
                            piratasEnJuego.get(i).start();
                        }
                        System.out.println(piratasEnJuego+ " Tamaño :" +piratasEnJuego.size());
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    Logger.getLogger(GenerarPiratas.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }

//    }
}
