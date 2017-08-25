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

    public GenerarPiratas(Pane pane, Queue<Pirata> piratas, boolean finPartida) {
        this.pane = pane;
        this.piratasAlmacenados = piratas;
        this.piratasEnJuego = new ArrayList<>();
        this.finPartida = finPartida;
    }

    @Override
    public void run() {
        while (finPartida == false) {
            if (piratasAlmacenados.isEmpty()) {
                for (int i = 0; i < (this.player.getDificultad().getNumPiratas()); i++) {
                    int posicion = new Random().nextInt(posiciones.length);
                    pirata = new Pirata("Pirata.png", 1100, posicion, finPartida);
                    piratasAlmacenados.add(pirata);
                }
            }

            Platform.runLater(() -> {
                try {
                    if (piratasEnJuego.isEmpty()) {
                        piratasEnJuego.add(piratasAlmacenados.poll());

                        for (int i = 0; i < (piratasEnJuego.size()); i++) {
                            piratasEnJuego.get(i).adjuntarPirata(pane);
                            piratasEnJuego.get(i).start();
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    Logger.getLogger(GenerarPiratas.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }

    }
}
