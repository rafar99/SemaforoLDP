/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author rafar
 */
public class CasaVazia extends Rectangle{
    
    
    private transient Rectangle recT;
    private Casa elem;
    
    public CasaVazia(){
        recT = new Rectangle((double)30, (double)30, Color.TRANSPARENT);
    }
    public void atualizaCelula(){
        this.elem.proximaPeca();
    }
} 
    
