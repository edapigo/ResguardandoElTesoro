/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javafx.scene.Scene;

/**
 *
 * @author Andres Ante
 * @author Edward Pino
 * @author Juan Xavier Pita
 */
public class JackSparrow extends Capitan {

    public JackSparrow(int posicionY, int posicionX, String nombreImagen, int altura, int ancho, TipoArma tipoArma, Scene escenaActual) {
        super(posicionY, posicionX, nombreImagen, altura, ancho, tipoArma, escenaActual);
    }

    @Override
    public void usarPoder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
