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
public class Casa implements Serializable {
    
    private TipoPeca peca;
    private int index,col;
    
    /**
     *Construtor inicia a peca, o index e o col
     * @param p
     */
    public Casa(TipoPeca p){
        this.peca = p;
        this.index = index;
        this.col = col;
    }
    
    /**
     *
     * @param p
     */
    public void setPeça(TipoPeca p){
        this.peca = p;
    }
    
    /**
     *
     * @param index
     */
    public void setIndex(int index){
        this.index = index;
    }
    
    /**
     *
     * @param column
     */
    public void setColumn(int column){
        this.col = column;
    }
    
    /**
     *
     * @return
     */
    public TipoPeca getPeça(){
        return this.peca;
    }
    
    /**
     * Este método é responsável pela alteração da peça, por exemplo, passar de 
     * uma peça verde para uma amarela
     */
    public void proximaPeca(){
        if (null != this.peca){
            switch (this.peca) {
                case Casa_Vazia:
                    this.peca = TipoPeca.Verde;
                    break;
                case Verde:
                    this.peca = TipoPeca.Amarela;
                    break;
                case Amarela:
                    this.peca = TipoPeca.Vermelha;
                    break;
            }
        }
    }
}