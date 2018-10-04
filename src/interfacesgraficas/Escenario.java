/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesgraficas;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Escenario extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        
        double anchoTotalCanvas = 300, altoTotalCanvas = 300;
        Pane layout = new Pane();
        int anchoCanvas = 1024, altoCanvas = 512;
        Canvas canvas = new Canvas(anchoCanvas, altoCanvas);
        layout.getChildren().add(canvas);
        Scene escena = new Scene(layout, anchoCanvas, altoCanvas, Color.LIGHTSKYBLUE);
        
        GraphicsContext lapiz = canvas.getGraphicsContext2D();
        
        LoopJuego juego = new LoopJuego(lapiz, anchoCanvas, altoCanvas, 20, 200, 60, 40, 10);  
        juego.start();
        
        stage.setScene(escena);
        stage.setTitle("Ejemplo");
        stage.show();
    }
    
    public static void main(String[] args) {
        Application.launch();
    }
    
    
}
