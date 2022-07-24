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
 * @author anari e rafa
 */
public class Celula extends ImageView{ //contém info da casa
    
     private Casa elem;
    
    /**
     * O construtor cria as imagens com o tamanho definido e inicia o elemento
     * @param img
     * @param elem
     */
    public Celula(Image img, Casa elem){   
        super(img);
        super.setFitHeight(100);
        super.setFitWidth(100);
        this.elem = elem;
    }
    
    /**
     * Este método atualiza a peça que está na casa, e coloca a respetiva imagem
     */
    public void atualizaCelula(){
        this.elem.proximaPeca();
        super.setImage(this.elem.getPeça().loadImage());
    }
    
}
