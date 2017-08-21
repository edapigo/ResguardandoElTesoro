/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 * Enumeracion que representa lo niveles de dificultad del juego.
 * @author Andres Ante
 * @author Edward Pino
 * @author Juan Xavier Pita
 */
public enum Dificultad {

    /**
     * Nivel Basico: La velocidad es de 2 y aparecen 15 piratas.
     */
    BASICO(2,15),

    /**
     * Nivel Intermedio: La velocidad es de 4 y aparecen 25 piratas.
     */
    INTERMEDIO(4,25),

    /**
     * Nivel Avanzado: La veloccidad es de 8 y aparecen 35 piratas.
     */
    AVANZADO(8,35);
    
    private int velocidad;
    private int nunPiratas;

    private Dificultad(int velocidad, int nunPiratas) {
        this.velocidad = velocidad;
        this.nunPiratas = nunPiratas;
    }

    /**
     * Método que devuelve la velocidad de los piratas.
     * @return velocidad
     */
    public int getVelocidad() {
        return velocidad;
    }


    /**
     * Método que devuelve el número de piratas que apareceran en el juego.
     * @return numPiratas
     */
    public int getNunPiratas() {
        return nunPiratas;
    }
    
}
