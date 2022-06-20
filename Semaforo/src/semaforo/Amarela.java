/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 *
 * @author rafar
 */
public class Amarela extends Polygon{
    
    private transient Polygon tri;
    
    private Casa elem;
        
        public Amarela(){
        tri = new Polygon();
        tri.getPoints().addAll(new Double[]{
            0.0, 0.0,
            20.0, 10.0,
            10.0, 20.0
        });
        tri.setFill(Color.YELLOW);
    }
    public void atualizaCelula(){
        this.elem.proximaPeca();
    }
}
