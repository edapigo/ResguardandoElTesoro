/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.awt.Cursor;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author usuario
 */
public class ElijeCapitan {
    
    private Pane root;
    private ImageView ive,iv;
    private Image imagen,imagenElije;
    public ElijeCapitan() {
        root = new Pane();
        
        try{
            imagen= new Image("fondoCapitan.jpg");
        }catch(Exception e){System.out.println("No lee imagen ");}
        iv = new ImageView(imagen);
        iv.setFitWidth(820);
        iv.setFitHeight(570);
        
        root = new Pane();
        
        try{
            imagenElije= new Image("fondoCapitan.jpg");
        }catch(Exception e){System.out.println("No lee imagen ");}
        
        
        VBox content = new VBox();
        content.setSpacing(10);
        
        
        //Fila de nombres de Capitanes
        HBox bNombresCaptain = new HBox();
        bNombresCaptain.setPadding(new Insets(10, 20, 20, 30));
        TitulosLabel nameSparrow = new TitulosLabel("Capitán Sparrow","-fx-font: 25 elephant",260,10,270,30, Color.GOLD);
        TitulosLabel nameBarbossa = new TitulosLabel("Capitán Barbossa","-fx-font: 25 elephant",275,10,270,30, Color.GOLD);
        TitulosLabel nameSalazar = new TitulosLabel("Capitán Salazar","-fx-font: 25 elephant",275,10,270,30, Color.GOLD);
        
        
        
        bNombresCaptain.getChildren().addAll(nameSparrow.getL(), nameBarbossa.getL(), nameSalazar.getL());
        
        // Fila de Capitanes
        HBox bCaptain = new HBox();
        
        ToggleGroup groupCaptain = new ToggleGroup();
        JackSparrow capSparrow = new JackSparrow(0,0,0,"Sparrow.png",200,100); 
        ToggleButton toggleSparrow = new ToggleButton("",capSparrow.getImageCapitan());
        toggleSparrow.setToggleGroup(groupCaptain);
        toggleSparrow.setPrefSize(240,250);
        
        toggleSparrow.setStyle("-fx-background-image: url(\"imageElije.jpg\");");
        
        
        Barbossa capBarbossa = new Barbossa(0,0,0,"Barbossa.png",200,125);
        ToggleButton toggleBarbossa = new ToggleButton("",capBarbossa.getImageCapitan());
        toggleBarbossa.setToggleGroup(groupCaptain);
        toggleBarbossa.setPrefSize(240, 250);
//      toggleBarbossa.setCursor(Cursor.getSystemCustomCursor(new Image("cursor.png")));
        
        Salazar capSalazar = new Salazar(0,0,0,"Salazar.png",200,130);
        ToggleButton toggleSalazar = new ToggleButton("",capSalazar.getImageCapitan());
        toggleSalazar.setToggleGroup(groupCaptain);
        toggleSalazar.setPrefSize(240, 250);
        Pane hi  = new Pane();
        
        
        bCaptain.getChildren().addAll(toggleSparrow,toggleBarbossa,toggleSalazar);
        bCaptain.setSpacing(25);
        bCaptain.setPadding(new Insets(2, 10, 10, 20));
        ive = capSparrow.getImageCapitan();
        
//        content.getChildren().add(iv);
        content.getChildren().addAll(bNombresCaptain,bCaptain);
        
        root.getChildren().addAll(iv,content);
        
    }

    /**
     *
     * @return
     */
    public Pane getRoot() {
        return root;
        
        
        
    }
    
    
    
}
