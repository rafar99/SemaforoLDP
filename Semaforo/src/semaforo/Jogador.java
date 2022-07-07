/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.io.Serializable;

/**
 *
 * @author rafar e rita
 */
public class Jogador implements Serializable {
    
     private boolean jogou;
     String nome; 

    
    //---------contrutor------------------------------------------ 
     
     
     public Jogador(String nome) {
        this.jogou = false;
        this.nome = nome;
    }

    
    
    //--------Getters e Setters-------------------------------------
    
    public boolean getJogou() {
        return jogou;
    }

    public void setJogou(boolean jogou) {
        this.jogou = jogou;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
     
     
    
}

