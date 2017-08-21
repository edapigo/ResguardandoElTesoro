/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javafx.geometry.Insets;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 
 * @author Andres Ante
 * @author Edward Pino
 * @author Juan Xavier Pita
 */
public class IngresoDatos {
    private Scene playerData;
    private Pane root;
    private Image imagen;
    private ImageView vi;
    
    public IngresoDatos(Stage escenario){
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
        
        
        
        VBox principal = new VBox(); 
        // PRIMERA FILA
        HBox box = new HBox();
        box.setSpacing(20);
        box.setPadding(new Insets(210, 100, 70, 200));// top right bottom left        
        TitulosLabel nombre = new TitulosLabel("Ingrese el nombre: ","-fx-font: 25 elephant",250,10,270,30, Color.DARKCYAN,false);
        TextField fieldNombre = new TextField();   
        
        box.getChildren().addAll(nombre.getL(),fieldNombre);
        
        // SEGUNDA FILA
        HBox botones = new HBox();
        botones.setSpacing(20);
        botones.setPadding(new Insets(0, 200, 200, 240));
        
        Boton btnNext = new Boton("Siguiente","-fx-font: 20 century; -fx-background-radius: 30;", 200, 60, 520, 410, 10, Color.DARKSLATEBLUE);
        Boton btnBack = new Boton("Atrás","-fx-font: 20 century; -fx-background-radius: 30;", 200, 60, 520, 410, 10, Color.DARKSLATEBLUE);
        
//        btnNext.getBtn().setDisable(true);
//        btnNext.getBtn().setOpacity(0.6);
                
        botones.getChildren().addAll(btnNext.getBtn(), btnBack.getBtn());
        
        principal.getChildren().addAll(box, botones);
        root.getChildren().addAll(vi, principal);
        playerData = new Scene(root, 800, 550);
        
        btnNext.getBtn().setOnAction(e -> {
            EligeCapitan ec = new EligeCapitan(escenario);
            ec.getElegirCapitan().setCursor(new ImageCursor(new Image("cursor.png")));
            escenario.setScene(ec.getElegirCapitan());
        });
        
        btnBack.getBtn().setOnAction(e -> {
            PaneOrganizer po = new PaneOrganizer(escenario);
            po.getInicio().setCursor(new ImageCursor(new Image("cursor.png")));
            escenario.setScene(po.getInicio());
        });
        
        
    }
    
    public Scene getPlayerData() {
        return playerData;
    }

    public Pane getRoot() {
        return root;
    }    
    
    
}

