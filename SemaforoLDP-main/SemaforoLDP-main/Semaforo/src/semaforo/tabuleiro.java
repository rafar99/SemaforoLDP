/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.io.IOException;
import java.io.ObjectOutputStream;
import javafx.scene.layout.GridPane;

/**
 *
 * @author anari
 */
public class tabuleiro {
    
    private transient GridPane gridJogo;
    private peca[] pecasVerdes;
    private peca[] pecasAmarelas;
    private peca[] pecasVermelhas;
    
    
    peca[][] casa;
    int linhas = 3;
    int colunas = 4;
 
    
     
    //----------contrutor----------------------------------------------
    
    
   tabuleiro() {
        this.casa = new peca[linhas][colunas];
    }
    
    //-------------------------------------------------------------------
     
    public boolean Jogada(int posArray, int linha, int coluna, String nomeJogador){
          boolean jogadaValida = true;
          peca p = casa[linha][coluna];
        
        if (null != p.tipo) 
            switch (p.tipo) {
                case Casa_Vazia:
                    p.tipo = Verde;
                    break;
                case Verde:
                    p.tipo = Amarela;
                    break;
                case Amarela:
                    p.tipo = vermelha;
                    break;
                case Vermelha:
                    jogadaValida=false;
                    break;
                default:
                    break;
            }
        
        return jogadaValida;
    }
    
    
   
   
}
