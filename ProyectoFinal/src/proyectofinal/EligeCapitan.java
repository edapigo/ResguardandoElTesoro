/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
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
public class EligeCapitan {

    private Scene elegirCapitan;
    private Pane root;
    private ImageView ive, iv, ivC;
    private Image imagen, imagenElige, imagenCandado;

    public EligeCapitan() {

    }

    public EligeCapitan(Stage escenario, Jugador player) {
        root = new Pane();

        try {
            imagen = new Image("fondoCapitan.jpg");
        } catch (Exception e) {
            System.out.println("No lee imagen ");
        }
        iv = new ImageView(imagen);
        iv.setFitWidth(820);
        iv.setFitHeight(570);

        root = new Pane();

        try {
            imagenElige = new Image("fondoCapitan.jpg");
        } catch (Exception e) {
            System.out.println("No lee imagen ");
        }
        ive = new ImageView(imagenElige);
        ive.setFitWidth(240);
        ive.setFitHeight(250);

        try {
            imagenCandado = new Image("candado.png");
        } catch (Exception e) {
            System.out.println("No lee imagen ");
        }
        ivC = new ImageView(imagenElige);
        ivC.setFitWidth(240);
        ivC.setFitHeight(250);

        VBox content = new VBox();
        content.setSpacing(10);

        //Fila de nombres de Capitanes
        HBox bNombresCaptain = new HBox();
        bNombresCaptain.setPadding(new Insets(10, 20, 20, 30));
        // ancho alto posX posY
        TitulosLabel nameSparrow = new TitulosLabel("Capitán Sparrow", "-fx-font: 25 elephant", 260, 10, 270, 30, Color.GOLD, true);
        TitulosLabel nameBarbossa = new TitulosLabel("Capitán Barbossa", "-fx-font: 25 elephant", 275, 10, 270, 30, Color.GOLD, true);
        TitulosLabel nameSalazar = new TitulosLabel("Capitán Salazar", "-fx-font: 25 elephant", 275, 10, 270, 30, Color.GOLD, true);

        bNombresCaptain.getChildren().addAll(nameSparrow.getL(), nameBarbossa.getL(), nameSalazar.getL());

        // Fila de Capitanes
        HBox bCaptain = new HBox();

        ToggleGroup groupCaptain = new ToggleGroup();
        JackSparrow capSparrow = new JackSparrow(0, 0, "Sparrow.png", 200, 100, TipoArma.LLUVIA_DINAMITA, escenario.getScene());
        ToggleButton toggleSparrow = new ToggleButton("", capSparrow.getImageCapitan());
        toggleSparrow.setToggleGroup(groupCaptain);
        toggleSparrow.setPrefSize(240, 250);

//      toggleSparrow.setBackground(new Background(new BackgroundImage(new Image( getClass().getResource("/testing/background.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
//      toggleSparrow.getStylesheets().add(this.getClass().getResource("fondoElige.jpg").toExternalForm());
//      toggleSparrow.setGraphic(new ImageView ( new Image(getClass().getResourceAsStream("fondoElige.jpg"))));
        Barbossa capBarbossa = new Barbossa(0, 0, "Barbossa.png", 200, 125, TipoArma.BOMBAS_FETIDAS, escenario.getScene());
        ToggleButton toggleBarbossa = new ToggleButton("", capBarbossa.getImageCapitan());
        toggleBarbossa.setDisable(true);
        toggleBarbossa.setOpacity(0.6);
        toggleBarbossa.setToggleGroup(groupCaptain);
        toggleBarbossa.setPrefSize(240, 250);
//      toggleBarbossa.setCursor(Cursor.getSystemCustomCursor(new Image("cursor.png")));

        Salazar capSalazar = new Salazar(0, 0, "Salazar.png", 200, 130, TipoArma.CAÑON_MUERTE, escenario.getScene());
        ToggleButton toggleSalazar = new ToggleButton("", capSalazar.getImageCapitan());
        toggleSalazar.setDisable(true);
        toggleBarbossa.setOpacity(0.6);
        toggleSalazar.setToggleGroup(groupCaptain);
        toggleSalazar.setPrefSize(240, 250);
        Pane hi = new Pane();

        bCaptain.getChildren().addAll(toggleSparrow, toggleBarbossa, toggleSalazar);
        bCaptain.setSpacing(20);
        bCaptain.setPadding(new Insets(20, 10, 10, 20));
        ive = capSparrow.getImageCapitan();

        //Fila Boton
        HBox bBotones = new HBox();
        bBotones.setSpacing(70);
        bBotones.setPadding(new Insets(40, 20, 40, 200));// top right bottom left

        Boton btnBack = new Boton("Atras", "-fx-font: 20 century; -fx-background-radius: 30;", 160, 50, 520, 410, 10, Color.DARKSLATEBLUE);
        Boton btnNext = new Boton("Siguiente", "-fx-font: 20 century; -fx-background-radius: 30;", 160, 50, 520, 410, 10, Color.DARKSLATEBLUE);

        btnNext.getBtn().setDisable(true);
        btnNext.getBtn().setOpacity(0.6);

        bBotones.getChildren().addAll(btnNext.getBtn(), btnBack.getBtn());

        content.getChildren().addAll(bNombresCaptain, bCaptain, bBotones);

        root.getChildren().addAll(iv, content);
        elegirCapitan = new Scene(root, 800, 550);

        groupCaptain.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (groupCaptain.getSelectedToggle() != null) {
                    btnNext.getBtn().setDisable(false);
                    btnNext.getBtn().setOpacity(1.0);
                } else {
                    btnNext.getBtn().setDisable(true);
                    btnNext.getBtn().setOpacity(0.6);
                }
            }
        });

        //Evento del Boton Siguiente
        btnNext.getBtn().setOnAction(e -> {
            DatosJuego dj = new DatosJuego(escenario, player);
            dj.getPartida().setCursor(new ImageCursor(new Image("cursor.png")));
            escenario.setScene(dj.getPartida());
        });

        //Evento del Boton Atras 
        btnBack.getBtn().setOnAction(e -> {
            IngresoDatos pd = new IngresoDatos(escenario);
            pd.getPlayerData().setCursor(new ImageCursor(new Image("cursor.png")));
            escenario.setScene(pd.getPlayerData());
        });

    }

    public Pane getRoot() {
        return root;
    }

    public Scene getElegirCapitan() {
        return elegirCapitan;
    }

}
