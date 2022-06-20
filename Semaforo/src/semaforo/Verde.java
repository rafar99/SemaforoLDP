/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author rafar
 */
public class Verde extends Circle {
    
    private transient Circle circle;
    private Casa elem;
    
    public Verde(){
        circle = new Circle((double)30, Color.GREEN);
    }
     public void atualizaCelula(){
        this.elem.proximaPeca();
    }
}
