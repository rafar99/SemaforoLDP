/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

/**
 *
 * @author anari
 */
public class Casa {
    
    private TipoPeca peca;
    private int index,col;
    
    public Casa(TipoPeca p){
        this.peca = p;
        this.index = index;
        this.col = col;
    }
    
    public void setPeça(TipoPeca p){
        this.peca = p;
    }
    
    public void setIndex(int index){
        this.index = index;
    }
    
    public void setColumn(int column){
        this.col = column;
    }
    
    public TipoPeca getPeça(){
        return this.peca;
    }
    
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
