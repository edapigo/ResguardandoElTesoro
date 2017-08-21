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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author HP ELECTRONIC
 */
public class Historial {
    private Pane windowHist;
    private File file;
    private ImageView ivHist;
    private Image imageHist;
    private TitulosLabel tl;
    private TextArea text ;
    private HBox tituloHis;
    private Stage stage;
    private Image imagen;
    private ImageView vi; 
    private TextField txtFirst;
    private TextField txtSecond;
    private TextField txtPhone;
    private TableView<DatosJuego> table;
    private ObservableList<DatosJuego> data;
    private SimpleStringProperty jugador,tiempo,monedas,fecha,nivel,estado;
    
    
    
    
    public Historial(String jugado,String tiemp,String moneda,String fech,String nive,String estad){
        
        this.jugador=new SimpleStringProperty(jugado);
        this.tiempo=new SimpleStringProperty(tiemp);
        this.monedas=new SimpleStringProperty(moneda);
        this.fecha=new SimpleStringProperty(fech);
        this.nivel=new SimpleStringProperty(nive);
        this.estado=new SimpleStringProperty(estad);
        
    }

    public SimpleStringProperty getJugador() {
        return jugador;
    }

    public void setJugador(SimpleStringProperty jugador) {
        this.jugador = jugador;
    }

    public SimpleStringProperty getMonedas() {
        return monedas;
    }

    public void setMonedas(SimpleStringProperty monedas) {
        this.monedas = monedas;
    }

    public SimpleStringProperty getFecha() {
        return fecha;
    }

    public void setFecha(SimpleStringProperty fecha) {
        this.fecha = fecha;
    }

    public SimpleStringProperty getNivel() {
        return nivel;
    }

    public void setNivel(SimpleStringProperty nivel) {
        this.nivel = nivel;
    }

    public SimpleStringProperty getEstado() {
        return estado;
    }

    public void setEstado(SimpleStringProperty estado) {
        this.estado = estado;
    }

   
    


    
    
    
    
    public Historial() {
        
        try{
            imagen = new Image("fondohistorial.jpg");
        
        }
        catch(Exception e){System.out.println("No lee imagen");}
        vi=new ImageView(imagen);
        vi.setFitHeight(600);
        vi.setFitWidth(900);
        vi.setImage (imagen);
        
        
        
        
        windowHist=new Pane();
        windowHist.getChildren().add(vi);

        
        
        
        TitulosLabel titulo= new TitulosLabel("HISTORIAL DE JUGADORES", "-fx-font: 20 elephant",450,10,100,20, Color.WHITESMOKE,true);
        TitulosLabel player= new TitulosLabel("JUGADOR","-fx-font: 20 elephant",400,10,10,120, Color.WHITESMOKE,true);
        TitulosLabel time= new TitulosLabel("TIEMPO", "-fx-font: 20 elephant;", 400, 10,150, 120, Color.WHITESMOKE,true);
        TitulosLabel coin= new TitulosLabel("MONEDA", "-fx-font: 20 elephant;", 400, 10, 300,120, Color.WHITESMOKE,true);
        TitulosLabel date= new TitulosLabel("FECHA ","-fx-font: 20 elephant",400,10,450,120, Color.WHITESMOKE,true);
        TitulosLabel rank= new TitulosLabel("NIVEL ","-fx-font: 20 elephant",400,10,600,120, Color.WHITESMOKE,true);
        TitulosLabel siono= new TitulosLabel("GANO ","-fx-font: 20 elephant",400,10,700,120, Color.WHITESMOKE,true);

//        TitulosLabel 
        table = new TableView<DatosJuego>();
        

        
        
        

        //Se crea las columnas 
        TableColumn jugadorCol = new TableColumn("Jugador");
        jugadorCol.setCellValueFactory(new PropertyValueFactory<Historial, String>("Jugador"));
        jugadorCol.setMinWidth(100);       
        TableColumn tiempoCol= new TableColumn("Tiempo");
        tiempoCol.setCellValueFactory(new PropertyValueFactory<Historial, String>("Tiempo"));
        tiempoCol.setMinWidth(100);       
        TableColumn monedasCol = new TableColumn("Monedas");
        monedasCol.setCellValueFactory(new PropertyValueFactory<Historial, String>("Monedas"));
        monedasCol.setMinWidth(100);       
        TableColumn fechaCol = new TableColumn("Fecha");
        fechaCol.setCellValueFactory(new PropertyValueFactory<Historial, String>("Fecha"));
        fechaCol.setMinWidth(100);       
        TableColumn nivelCol = new TableColumn("Nivel");
        nivelCol.setCellValueFactory(new PropertyValueFactory<Historial, String>("Nivel"));
        nivelCol.setMinWidth(100);       
        TableColumn estadoCol = new TableColumn("Gano");
        estadoCol.setCellValueFactory(new PropertyValueFactory<Historial, String>("Gano"));
        estadoCol.setMinWidth(100);       

        
        Boton regreso= new Boton("Regresar","-fx-font: 20 century; -fx-background-color: transparent;-fx-background-radius: 30;", 150, 60, 580, 438, 10, Color.WHITESMOKE);

        //Agregar al pane
        windowHist.getChildren().addAll(titulo.getL(),regreso.getBtn());
        windowHist.getChildren().addAll(player.getL(),time.getL(),coin.getL(),date.getL(),rank.getL(),siono.getL());
//        windowPuntajes.getChildren().addAll(jugador.getL(),puntaje.getL(),name1.getL(),name2.getL(),name3.getL(),name4.getL(),name5.getL(),name6.getL(),name7.getL(),name8.getL(),name9.getL(), name10.getL());
//        windowPuntajes.getChildren().addAll(puntaje1.getL(),puntaje2.getL(),puntaje3.getL(),puntaje4.getL(),puntaje5.getL(), puntaje6.getL(),puntaje7.getL(),puntaje8.getL(),puntaje9.getL(), puntaje10.getL());
//        regreso.getBtn().setOnAction(new regresar());
//        ver.getBtn().setOnAction(new verPuntaje());
//        Scene scenePuntajes = new Scene(this.windowPuntajes, 890, 500);
//        this.sc=this.stagePrincipal.getScene();
//        this.stagePrincipal.setScene(scenePuntajes);

    }
    
    public Pane getWindowHist() {
       
//      

        return windowHist;
    }

    public ImageView getIvHist() {
        return ivHist;
    }

    public File getFile() {
        
        return file;
    }
    
    public void MostrarDatos(){
//        
    }
    
    public ArrayList<Historial> LeerDatos(){
        file = new File("historial.txt");
        FileReader fReader = null;
        BufferedReader bReader = null;
        ArrayList<Historial> contenido= new ArrayList();
        String cont[];
        try{
            fReader= new FileReader(file);
            bReader = new BufferedReader(fReader);
            String linea = bReader.readLine();
            while(linea != null){
                cont=linea.split(",");
//                data = FXCollections.observableArrayList(new Historial(Integer.toString(cont[0]),cont[1],cont[2],cont[3],cont[4],cont[5]));
                
                contenido.add(new Historial(cont[0],cont[1],cont[2],cont[3],cont[4],cont[5]));
                linea = bReader.readLine();
            }
            bReader.close();
            fReader.close();
            
        }catch(FileNotFoundException e){
            System.out.println("No lee archivo");
        }catch(Exception e){
            System.out.println("ERROR");
        }   
        return contenido;
       
    }

private class regresar implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            
        }
    }
	
}




