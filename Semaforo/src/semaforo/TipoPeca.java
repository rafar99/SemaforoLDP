/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import javafx.scene.image.Image;


/**
 * Enumeraçao do TipoPeca que contém as várias possibilidades de peça e as associa ao caminho das
 * respetivas imagens
 * @author rafar e rita
 */
public enum TipoPeca implements Serializable {
    Casa_Vazia("/Images/empty.png") ,
    Verde("/Images/green.png"),
    Amarela("/Images/yellow.png"),
    Vermelha("/Images/red.png");
    
    private String caminho;
    
   /**
    * O construtor recebe uma string da imagem, inicia-a, inicia o file e a img
    */
    
    
    TipoPeca(String img){
        this.caminho=img;
    }    
        
    public Image loadImage(){
        String file = this.getClass().getResource(this.caminho).toString();
        return new Image(file); 
    }
}
