/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 * Clase para representar el jugador del juego.
 * @author Andres Ante
 * @author Edward Pino
 * @author Juan Xavier Pita
 */
public class Jugador {
    private String nombre;
    private int monedas;
    private Dificultad dificultad;

    public Jugador() {
    }

    public Jugador(String nombre, int monedas, Dificultad dificultad) {
        this.nombre = nombre;
        this.monedas = monedas;
        this.dificultad = dificultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMonedas() {
        return monedas;
    }

    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }
    
    
    
}
