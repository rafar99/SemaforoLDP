/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.io.InputStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author anari
 */
public class Celula extends ImageView{ //contém info da casa
    
     private Casa elem;
    
    public Celula(Image img, Casa elem){   
        super(img);
        super.setFitHeight(100);
        super.setFitWidth(100);
        super.setLayoutX(20);
        this.elem = elem;
    }
    
    public void atualizaCelula(){
        this.elem.proximaPeca();
        super.setImage(this.elem.getPeça().getImg());
    }
    
}
