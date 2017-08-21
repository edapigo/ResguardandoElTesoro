/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.io.File;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 *
 * @author Andres Ante
 * @author Edward Pino
 * @author Juan Xavier Pita
 */
public class Historial {
    private Pane windowHist;
    private File file;
    private ImageView ivHist;
    private Image imageHist;
    private TitulosLabel tl;
    private Text text ;

    public Historial() {
        this.getWindowHist();
         
        
        //Agregar al pane
//        

    }

    public Pane getWindowHist() {
        windowHist = new Pane();
        try{
            imageHist= new Image("pirate_av4j.jpg");
        }catch(Exception e){System.out.println("No lee imagen ");}
        ivHist = new ImageView(imageHist);
        ivHist.setFitWidth(820);
        ivHist.setFitHeight(570);
        windowHist.getChildren().addAll(ivHist,this.getText());

        return windowHist;
    }

    public ImageView getIvHist() {
        return ivHist;
    }

    public File getFile() {
        
        return file;
    }
    
    public void MostrarDatos(){
       //TitulosLabel tl=new TitulosLabel("HISTORIAL", estilo, 0, 0, 0, 0, Color.CORALColor.CORAL); 
      
       TextField textField = new TextField();
       textField.setText("Neon Sign");
       text.textProperty().bind(textField.textProperty());
    }

    public Text getText() {
        return text;
    }


}
