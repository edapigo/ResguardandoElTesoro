/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 *
 * @author usuario
 */
public class ElijeCapitan {
    
    private Pane root;
    private ImageView ive;
    
    public ElijeCapitan() {
        root = new Pane();
        HBox bCaptain = new HBox();
        ToggleGroup groupCaptain = new ToggleGroup();
        JackSparrow capSparrow = new JackSparrow(0,0,0,"Sparrow.png",200,100); 
        ToggleButton toggleSparrow = new ToggleButton("",capSparrow.getImageCapitan());
        toggleSparrow.setToggleGroup(groupCaptain);
        toggleSparrow.setPrefSize(150,100);
        
        Barbossa capBarbossa = new Barbossa(0,0,0,"Barbossa.png",200,125);
        ToggleButton toggleBarbossa = new ToggleButton("",capBarbossa.getImageCapitan());
        toggleBarbossa.setToggleGroup(groupCaptain);
        toggleBarbossa.setPrefSize(150, 100);
        
        Salazar capSalazar = new Salazar(0,0,0,"Salazar.png",200,130);
        ToggleButton toggleSalazar = new ToggleButton("",capSalazar.getImageCapitan());
        toggleSalazar.setToggleGroup(groupCaptain);
        toggleSalazar.setPrefSize(150, 100);
        Pane hi  = new Pane();
        
        
        bCaptain.getChildren().addAll(toggleSparrow,toggleBarbossa,toggleSalazar);
        bCaptain.setSpacing(10);
        ive = capSparrow.getImageCapitan();
        
        root.getChildren().addAll(bCaptain);
        
    }

    /**
     *
     * @return
     */
    public Pane getRoot() {
        return root;
        
        
        
    }
    
    
    
}
