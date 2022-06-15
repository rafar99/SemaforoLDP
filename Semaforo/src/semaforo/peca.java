/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.io.Serializable;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

/**
 *
 * @author anari
 */





public class peca {
    
    enum TipoPeca {
        Casa_Vazia ,
        Verde,
        Amarela,
        Vermelha
    }
    
    
    
    TipoPeca tipo;
    private boolean estadentro=false;
    private transient Ellipse circle;
    private transient Rectangle rect;
    private transient Polygon tri;

    private int x,y=-1;
    private int idArray;
    private String id;
    private int idAtual = 0;
    private String stringId;


    peca(TipoPeca tipo) {
        this.tipo = tipo;
    }
    
    
    
    
    public peca(String id, int idArray){
        
        circle = new Ellipse((double)30,(double)30);
        circle.setFill(Color.GREEN);
        this.idArray = idArray;
        this.id = id;
        circle.setVisible(true);
        
       tri = new Polygon();
       tri.getPoints().addAll(new Double[]{
            0.0, 0.0,
            20.0, 10.0,
            10.0, 20.0 });
        tri.setFill(Color.YELLOW);
        this.idArray = idArray;
        this.id = id;
        tri.setVisible(true);
       
        
        
        
        rect = new Rectangle((double)30,(double)30, Color.RED);
        this.idArray = idArray;
        this.id = id;
        rect.setVisible(true);
        
        
        
        
        
        
        
        
        
        
    }

    public TipoPeca getCorPeca() {
        return tipo;
    }

    public void setCorPeca(TipoPeca tipo) {
        this.tipo = tipo;
    }

    public boolean isEstadentro() {
        return estadentro;
    }

    public void setEstadentro(boolean estadentro) {
        this.estadentro = estadentro;
    }

    public Ellipse getCircle() {
        return circle;
    }

    public void setCircle(Ellipse circle) {
        this.circle = circle;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public Polygon getTri() {
        return tri;
    }

    public void setTri(Polygon tri) {
        this.tri = tri;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getIdArray() {
        return idArray;
    }

    public void setIdArray(int idArray) {
        this.idArray = idArray;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdAtual() {
        return idAtual;
    }

    public void setIdAtual(int idAtual) {
        this.idAtual = idAtual;
    }

    public String getStringId() {
        return stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    
    
    
}
