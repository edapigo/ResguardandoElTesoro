/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javafx.application.Application;
import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Andres Ante
 * @author Edward Pino
 * @author Juan Xavier Pita
 */
public class ElTesoroDelPirata extends Application {

    @Override
    public void start(Stage escenario) throws Exception {

        PaneOrganizer po = new PaneOrganizer(escenario);

        escenario.setScene(po.getInicio());

        escenario.setTitle("Resguardando el Tesoro del Pirata");
        po.getInicio().setCursor(new ImageCursor(new Image("cursor.png")));
//        escenario.setResizable(false);
        escenario.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
