/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javafx.geometry.Insets;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Una clase para representar la pantalla de juego.
 * @author Andres Ante
 * @author Edward Pino
 * @author Juan Xavier Pita
 */
public class DatosJuego {
    
    private Scene partida;
    private String tiempo;//LABEL
    private String fecha;
    private int nivel;// LABEL
    private BorderPane root;
    private Image imagen, imagenFondo;
    private ImageView iv, ivf;
//    private String ;
    
    public DatosJuego() {
        
    }
    
    public DatosJuego(Stage escenario, Jugador player) {
        this.tiempo = "";
        this.fecha = "";
        this.root = new BorderPane();
        
        // CENTRO
        Pane centro = new Pane();
        try {
            imagen= new Image("fondoJuego.jpg");
        } catch(Exception e) {System.out.println("No lee imagen ");}
        iv = new ImageView(imagen);
        iv.setFitHeight(632);
        iv.setFitWidth(1000);
        
        JackSparrow j = new JackSparrow(2,50,50,"captainSparrow.png" ,150,120,TipoArma.LLUVIA_DINAMITA,escenario.getScene());// validad bien esto
        
        centro.getChildren().addAll(iv, j.getImageCapitan());
               
        // TOP
        HBox top = new HBox();
        top.setSpacing(30);
        top.setPadding(new Insets(15, 0, 15, 10));    // top, right, bot, left        
        Circle circulo = new Circle(10, Color.GREY);
        // NOMBRE-USUARIO
        HBox boxNombre = new HBox();
        boxNombre.setSpacing(-20);
        TitulosLabel tagNombre = new TitulosLabel("Nombre", "-fx-font: 15 elephant", 150, 0, 0, 0, Color.GOLD, false);
        TitulosLabel labNombre = new TitulosLabel(player.getNombre(), "-fx-font: 15 elephant", 150, 0, 0, 0, Color.DARKSLATEGRAY, false);
        boxNombre.getChildren().addAll(tagNombre.getL(), labNombre.getL());
        // NIVEL-NUMERO
        HBox boxNivel = new HBox();
        boxNivel.setSpacing(-15);
        TitulosLabel tagNivel = new TitulosLabel("Nivel", "-fx-font: 15 elephant", 150, 0, 0, 0, Color.GOLD, false);
        TitulosLabel labNivel = new TitulosLabel(player.getDificultad().getNivel() + "", "-fx-font: 15 elephant", 150, 0, 0, 0, Color.DARKSLATEGRAY, false);
        boxNivel.getChildren().addAll(tagNivel.getL(), labNivel.getL());
        // MONEDAS-CANTIDAD
        HBox boxMonedas = new HBox();
        boxMonedas.setSpacing(-15);
        TitulosLabel tagMonedas = new TitulosLabel("Monedas", "-fx-font: 15 elephant", 150, 0, 0, 0, Color.GOLD, false);
        TitulosLabel labMonedas = new TitulosLabel(player.getMonedas() + "", "-fx-font: 15 elephant", 150, 0, 0, 0, Color.DARKSLATEGRAY, false);
        boxMonedas.getChildren().addAll(tagMonedas.getL(), labMonedas.getL());
        // TIEMPO-RELOJ (hh:mm:ss)
        HBox boxTiempo = new HBox();
        boxTiempo.setSpacing(-15);
        TitulosLabel tagTiempo = new TitulosLabel("Tiempo", "-fx-font: 15 elephant", 150, 0, 0, 0, Color.GOLD, false);
        TitulosLabel labTiempo = new TitulosLabel(tiempo, "-fx-font: 15 elephant", 150, 0, 0, 0, Color.DARKSLATEGRAY, false);
        boxTiempo.getChildren().addAll(tagTiempo.getL(), labTiempo.getL());

        top.getChildren().addAll(circulo, boxNombre, boxNivel, boxMonedas, boxTiempo);
        
        
        
        // BOTTOM
        HBox bottom = new HBox();
        bottom.setSpacing(20);
        bottom.setPadding(new Insets(0, 0, 12, 700));   // top, right, bottom, left
        
        Boton btnPause = new Boton("Pausa","-fx-font: 20 century; -fx-background-radius: 30;", 130, 50, 520, 410, 10, Color.DARKSLATEBLUE);
        Boton btnBack = new Boton("Atrás","-fx-font: 20 century; -fx-background-radius: 30;", 130, 50, 520, 410, 10, Color.DARKSLATEBLUE);
        
        bottom.getChildren().addAll(btnPause.getBtn(), btnBack.getBtn());
        
        try{
            imagenFondo= new Image("fondo2.png");
        }catch(Exception e){System.out.println("No lee imagen ");}
        ivf= new ImageView(imagenFondo);
        ivf.setFitHeight(750);
        ivf.setFitWidth(1000);
        
        root.getChildren().add(ivf);
        root.setCenter(centro);
        root.setTop(top);
        root.setBottom(bottom);
        
//        root.getBottom().setStyle("-fx-background-color: #DAA520");
        partida = new Scene(root, 1000, 750);
        
        btnPause.getBtn().setOnAction(e -> {
            // BOTON PARA PAUSAR JUEGO (Usar Threads)
        });
        
        btnBack.getBtn().setOnAction(e -> {
            EligeCapitan ec = new EligeCapitan(escenario, player);
            ec.getElegirCapitan().setCursor(new ImageCursor(new Image("cursor.png")));
            escenario.setScene(ec.getElegirCapitan());
        });
        
        
    }    
    
    public DatosJuego(String tiempo, String fecha, int nivel, BorderPane root) {
        this.tiempo = tiempo;
        this.fecha = fecha;
        this.root = root;
    }
    
    public Scene getPartida() {
        return partida;
    }
    
    public String getTiempo() {
        return tiempo;
    }
    
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getFecha() {
        return fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNivel() {
         return nivel;
    }
    
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }
    
    
}
