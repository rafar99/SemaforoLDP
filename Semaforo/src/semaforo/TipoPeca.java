/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.io.InputStream;
import java.net.URL;
import javafx.scene.image.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author rafar
 */
public enum TipoPeca {
    Casa_Vazia("C:\\Users\\anari\\Desktop\\SemaforoLDP\\Semaforo\\resources\\green.png") ,
    Verde("green.png"),
    Amarela("green.png"),
    Vermelha("green.png");
    
    
    private String caminho;
    private Image img;
    
    TipoPeca(String img){
        this.caminho=img;
       // InputStream input = getClass().getClassLoader().getResourceAsStream(img);
       //URL url = getClass().getResource("C:\\Users\\anari\\Desktop\\SemaforoLDP\\Semaforo\\resources\\green.png");
       this.img=new Image(img);
       int i = 5;
    }

    public Image getImg() {
        return img;
    }
    
    
    
    
    
}
