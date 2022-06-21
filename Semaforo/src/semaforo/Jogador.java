/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

/**
 *
 * @author rafar
 */
public class Jogador {
    
     private int jogou;
     String nome; 

    
    //---------contrutor------------------------------------------ 
     
     
     public Jogador(int jogou, String nome) {
        this.jogou = jogou;
        this.nome = nome;
    }

    
    
    //--------Getters e Setters-------------------------------------
    
    public int getJogou() {
        return jogou;
    }

    public void setJogou(int jogou) {
        this.jogou = jogou;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
     
     
    
}

