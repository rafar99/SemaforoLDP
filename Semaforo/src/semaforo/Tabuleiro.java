/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.io.Serializable;

/**
 *
 * @author rafar
 */
public class Tabuleiro implements Serializable
{
    Casa tabuleiro[][];
     
    public Tabuleiro(){
         
        this.tabuleiro = new Casa[3][4];
        int i,j;
        for(i = 0; i < 3; i++){
            for(j = 0; j < 4; j++){
                Peca p = new Peca(TipoPeca.Casa_Vazia);
                Casa elem = new Casa(p.tipo);
                this.tabuleiro[i][j] = elem;
            } 
        }
    }
    
    public Casa[][] getTabuleiro(){
        return this.tabuleiro;
    }
}
