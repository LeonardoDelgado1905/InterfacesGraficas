/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesgraficas;

/**
 *
 * @author Estudiante
 */


import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;

public class LoopJuego extends AnimationTimer{
    
    private GraphicsContext lapiz;
    private double anchoTotalCanvas;
    private double altoTotalCanvas;
    private boolean llegoFinal;
    Carro carro;
    Image fondo;
    Image gato;
    Image hombre;

    public LoopJuego(GraphicsContext lapiz, double anchoTotalCanvas, double altoTotalCanvas, int x, int y, int anchoCarro, int altoCarro, int diametroRueda) {
        this.lapiz = lapiz;
        this.anchoTotalCanvas = anchoTotalCanvas;
        this.altoTotalCanvas = altoTotalCanvas;
        this.fondo = new Image("Imagen/image/fondo.png");
        this.gato = new Image("Imagen/image/cats.gif");
        this.hombre = new Image("Imagen/image/down0.png");
        this.carro = new Carro(x, y, anchoCarro, altoCarro, diametroRueda);
    }

    
    
    int fotograma = 0;
    @Override
    public void handle(long l) {
        
        
        
        
        if((fotograma/10 % 1024) >= 512){
            lapiz.drawImage(fondo, (fotograma/10 % 1024), 0, 2*anchoTotalCanvas - (fotograma/10 % 1024), altoTotalCanvas, 0, 0, 2*anchoTotalCanvas - (fotograma/10 % 1024), altoTotalCanvas);
            lapiz.drawImage(fondo, 0, 0, (fotograma/10 % 1024) - anchoTotalCanvas, altoTotalCanvas, 2*anchoTotalCanvas - (fotograma/10 % 1024), 0, (fotograma/10 % 1024) - anchoTotalCanvas, altoTotalCanvas);
        }
        else{
            lapiz.drawImage(fondo, (fotograma/10 % 1024), 0, anchoTotalCanvas, altoTotalCanvas, 0, 0, anchoTotalCanvas, altoTotalCanvas);
        }
        
        int pos = (fotograma % 794)/132;
        lapiz.drawImage(gato, pos*132, 0, 132, 80, (fotograma/10 % anchoTotalCanvas) /*189.83*/, altoTotalCanvas - 200, 132, 80); //gatito
        lapiz.drawImage(hombre, anchoTotalCanvas - 30, altoTotalCanvas - 200);
        
        //Shape Gato
        lapiz.strokeRect((fotograma/10 % anchoTotalCanvas), altoTotalCanvas - 200, 132, 80);
        Shape g = new Rectangle((fotograma/10 % anchoTotalCanvas), altoTotalCanvas - 200, 132, 80);
        
        //Shape Hombre
        lapiz.strokeRect(anchoTotalCanvas - 30, altoTotalCanvas - 200, 30, 39);
        Shape h = new Rectangle(anchoTotalCanvas - 30, altoTotalCanvas - 200, 30, 39);
        fotograma+= 40;
        
        
        Shape[] = inter = new Shape[3];
        
        inter[0] = SVGPath.intersect(h, g);
        
        //lapiz.clearRect(0, 0, anchoTotalCanvas, altoTotalCanvas);
        //lapiz.setFill(Color.BLACK);
        //lapiz.fillOval(carro.getLlanta()[0].getX(), carro.getLlanta()[0].getY(), carro.getLlanta()[0].getDiametro(), carro.getLlanta()[0].getDiametro()); //Rueda izquierda
        //lapiz.fillOval(carro.getLlanta()[1].getX(), carro.getLlanta()[1].getY(), carro.getLlanta()[1].getDiametro(), carro.getLlanta()[1].getDiametro()); //Rueda derecha
        //lapiz.strokeText("Puntaje: 100", 200, 50, 200); //Puntaje
        //lapiz.setFill(Color.CHOCOLATE);
        //lapiz.fillRect(carro.getChasis().getX(), carro.getChasis().getY(), carro.getChasis().getAncho(), carro.getChasis().getAlto()); //cuerpoCarro        
        //lapiz.setFill(Color.DARKGREY);
        //lapiz.fillRect(anchoTotalCanvas - 30, carro.getyRef() - 30, 20, carro.getAlto() + 60); // ladrillo
        //lapiz.setFill(Color.GREEN);
        //lapiz.fillRect(0, carro.getyRef() + carro.getAlto() + carro.getLlanta()[0].getDiametro(), anchoTotalCanvas, altoTotalCanvas); //Piso
        
        /*
        if(carro.getxRef() + carro.getAncho() == anchoTotalCanvas) llegoFinal = true;
        else if(carro.getxRef() == 0) llegoFinal = false;        
        if(llegoFinal){
            carro.moverAtras();
            llegoFinal = true;
        }
        else{
            carro.moverAdelante();
            llegoFinal = false;
        }*/
        
    }
    
}
