/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.io.InputStream;
import java.net.URL;
import javafx.scene.image.Image;


/**
 *
 * @author rafar
 */
public enum TipoPeca {
    Casa_Vazia("/Images/red.png") ,
    Verde("/Images/green.png"),
    Amarela("/Images/yellow.png"),
    Vermelha("/Images/red.png");
    
    
    private String caminho;
    private Image img;
    
    TipoPeca(String img){
        this.caminho=img;
       String file = this.getClass().getResource(img).toString();
       this.img=new Image(img);
    }

    public Image getImg() {
        return img;
    }
    
    
    
    
    
}
