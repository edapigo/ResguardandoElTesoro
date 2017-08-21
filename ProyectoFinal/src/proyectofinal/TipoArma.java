/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 *
 * @author Andres Ante
 * @author Edward Pino
 * @author Juan Xavier Pita
 */
public enum TipoArma {
    
    LLUVIA_DINAMITA(2),BOMBAS_FETIDAS(4),CAÑON_MUERTE(6);
    private int alcance;

    private TipoArma(int alcance) {
        this.alcance = alcance;
    }

    public int getAlcance() {
        return alcance;
    }
}
