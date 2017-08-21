/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Una clase para representar a los a los labels en el juego.
 * @version 1.0
 * @author Andres Ante
 * @author Edward Pino
 * @author Xavier Pita
 */
public class TitulosLabel {
    private Label l;
    public TitulosLabel(String nombre, String estilo, double ancho, double alto, double posX, double posY, Color color, boolean sombra) {
        l = new Label(nombre);
        l.setPrefSize(ancho, alto);
        l.setLayoutX(posX);
        l.setLayoutY(posY);
        l.setStyle(estilo);
        l.setTextFill(color);
        
        if(sombra) {
           DropShadow ds = new DropShadow();
        ds.setOffsetY(2.0f);
        ds.setColor(Color.rgb(35, 42, 228, .99));
        l.setCache(true);
        l.setEffect(ds);
        l.setFont(Font.font(null, FontWeight.EXTRA_BOLD,32));
        }
        
    }

    /**
     * Método que devuelve el label.
     * @return l
     */
    public Label getL() {
        return l;
    }

    /**
     * Método que modifica el label.
     * @param l de tipo Label que representa el label
     */
    public void setL(Label l) {
        this.l = l;
    }
    
    
}
