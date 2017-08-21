/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 
 * @author Andres Ante
 * @author Edward Pino
 * @author Juan Xavier Pita
 */
public class IngresoDatos {
    
    private Pane root;
    private Image imagen;
    private ImageView vi;
    
    public IngresoDatos(Stage stagePrincipal){
        root = new Pane();
        try{
            imagen= new Image("fondoIngreso.jpg");
        
        }
        catch(Exception e){System.out.println("No lee imagen");}
        
//        this.stagePrincipal = stageP;
        
       
        vi=new ImageView(imagen);
        vi.setFitHeight(550);
        vi.setFitWidth(820);
        vi.setImage (imagen);
        
        HBox box = new HBox();
        box.setSpacing(20);
        box.setPadding(new Insets(270, 100, 100, 200));// top right bottom left        
        TitulosLabel nombre = new TitulosLabel("Ingrese el nombre: ","-fx-font: 25 elephant",250,10,270,30, Color.DARKCYAN,false);
//      Label nombre = new Label("Ingrese su nombre: ");
        TextField  fieldNombre = new TextField ();
        
        box.getChildren().addAll(nombre.getL(),fieldNombre);
        
        root.getChildren().addAll(vi,box);
        
        
    }

    public Pane getRoot() {
        return root;
    }    
    
    
}

