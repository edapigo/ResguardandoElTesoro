/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author HP ELECTRONIC
 */
public class Historial {

    private Scene historial;
    private Pane windowHist;
    private File file;
    private ImageView ivHist;
    private Image imageHist;
    private TitulosLabel tl;
    private TextArea text;
    private HBox tituloHis;
    private Stage stage;
    private Image imagen;
    private ImageView vi;
    private TextField txtFirst;
    private TextField txtSecond;
    private TextField txtPhone;
    private TableView<DatosJuego> table;
    private ObservableList<DatosJuego> data;
    private SimpleStringProperty jugador, tiempo, monedas, fecha, nivel, estado;

    public Historial(Stage escenario) {

        try {
            imagen = new Image("fondoHistorial.jpg");

        } catch (Exception e) {
            System.out.println("No lee imagen");
        }
        vi = new ImageView(imagen);
        vi.setFitHeight(600);
        vi.setFitWidth(900);
        vi.setImage(imagen);

        windowHist = new Pane();
        windowHist.getChildren().add(vi);

        TitulosLabel titulo = new TitulosLabel("HISTORIAL DE JUGADORES", "-fx-font: 20 elephant", 450, 10, 100, 20, Color.WHITESMOKE, true);
        TitulosLabel player = new TitulosLabel("JUGADOR", "-fx-font: 20 elephant", 400, 10, 10, 85, Color.WHITESMOKE, true);
        TitulosLabel time = new TitulosLabel("TIEMPO", "-fx-font: 20 elephant;", 400, 10, 150, 85, Color.WHITESMOKE, true);
        TitulosLabel coin = new TitulosLabel("MONEDA", "-fx-font: 20 elephant;", 400, 10, 300, 85, Color.WHITESMOKE, true);
        TitulosLabel date = new TitulosLabel("FECHA ", "-fx-font: 20 elephant", 400, 10, 450, 85, Color.WHITESMOKE, true);
        TitulosLabel rank = new TitulosLabel("NIVEL ", "-fx-font: 20 elephant", 400, 10, 600, 85, Color.WHITESMOKE, true);
        TitulosLabel siono = new TitulosLabel("GANO ", "-fx-font: 20 elephant", 400, 10, 700, 85, Color.WHITESMOKE, true);

        ArrayList<DatosHistorial> contenido = this.LeerDatos();
//        System.out.println(contenido.get(0).getCoins());
//Recorrer el array

        Boton regreso = new Boton("Regresar", "-fx-font: 20 century; -fx-background-color: transparent;-fx-background-radius: 30;", 150, 60, 580, 438, 10, Color.WHITESMOKE);

        //Agregar al pane
        windowHist.getChildren().addAll(titulo.getL(), regreso.getBtn());
        windowHist.getChildren().addAll(player.getL(), time.getL(), coin.getL(), date.getL(), rank.getL(), siono.getL());
        historial = new Scene(windowHist, 800, 550);

        int i = 115;
        for (int x = 0; x < contenido.size(); x++) {
            TitulosLabel name1 = new TitulosLabel(" ", "-fx-font: 15 elephant", 400, 10, 10, i, Color.WHITESMOKE, false);
            TitulosLabel name2 = new TitulosLabel(" ", "-fx-font: 15 elephant", 400, 10, 150, i, Color.WHITESMOKE, false);
            TitulosLabel name3 = new TitulosLabel(" ", "-fx-font: 15 elephant", 400, 10, 300, i, Color.WHITESMOKE, false);
            TitulosLabel name4 = new TitulosLabel(" ", "-fx-font: 15 elephant", 400, 10, 450, i, Color.WHITESMOKE, false);
            TitulosLabel name5 = new TitulosLabel(" ", "-fx-font: 15 elephant", 400, 10, 600, i, Color.WHITESMOKE, false);
            TitulosLabel name6 = new TitulosLabel(" ", "-fx-font: 15 elephant", 400, 10, 700, i, Color.WHITESMOKE, false);

            name1.getL().setText(contenido.get(x).getPlayer());
            name2.getL().setText(contenido.get(x).getTimer());
            name3.getL().setText(contenido.get(x).getCoins());
            name4.getL().setText(contenido.get(x).getDate());
            name5.getL().setText(contenido.get(x).getNivel());
            name6.getL().setText(contenido.get(x).getGano());
            System.out.println(contenido.get(x));

            windowHist.getChildren().addAll(name1.getL(), name2.getL(), name3.getL(), name4.getL(), name5.getL(), name6.getL());
            i += 30;
        }

        //Accion del boton regresar a la anterior escena
        regreso.getBtn().setOnAction(e -> {
            PaneOrganizer po = new PaneOrganizer(escenario);
            po.getInicio().setCursor(new ImageCursor(new Image("cursor.png")));
            escenario.setScene(po.getInicio());
        });

    }

    public Scene getHistorial() {
        return historial;
    }

    public Pane getWindowHist() {
        return windowHist;
    }

    public ImageView getIvHist() {
        return ivHist;
    }

    public File getFile() {

        return file;
    }

    public static class DatosHistorial {

        private final SimpleStringProperty player;
        private final SimpleStringProperty timer;
        private final SimpleStringProperty coins;
        private final SimpleStringProperty date;
        private final SimpleStringProperty nivel;
        private final SimpleStringProperty gano;

        private DatosHistorial(String first, String second, String tres, String cuatro, String cinco, String seis) {
            this.player = new SimpleStringProperty(first);
            this.timer = new SimpleStringProperty(second);
            this.coins = new SimpleStringProperty(tres);
            this.date = new SimpleStringProperty(cuatro);
            this.nivel = new SimpleStringProperty(cinco);
            this.gano = new SimpleStringProperty(seis);

        }

        public String getPlayer() {
            return player.get();
        }

        public String getTimer() {
            return timer.get();
        }

        public String getCoins() {
            return coins.get();
        }

        public String getDate() {
            return date.get();
        }

        public String getNivel() {
            return nivel.get();
        }

        public String getGano() {
            return gano.get();
        }

    }

    public ArrayList<DatosHistorial> LeerDatos() {
        file = new File("historial.txt");
        FileReader fReader = null;
        BufferedReader bReader = null;
        ArrayList<DatosHistorial> contenido = new ArrayList();
        String cont[];
        try {
            fReader = new FileReader(file);
            bReader = new BufferedReader(fReader);
            String linea = bReader.readLine();
            while (linea != null) {
                cont = linea.split(",");
//                data = FXCollections.observableArrayList(new Historial(Integer.toString(cont[0]),cont[1],cont[2],cont[3],cont[4],cont[5]));
                contenido.add(new DatosHistorial(cont[0], cont[1], cont[2], cont[3], cont[4], cont[5]));

                linea = bReader.readLine();
            }
            bReader.close();
            fReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("No lee archivo");
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        return contenido;

    }

}
