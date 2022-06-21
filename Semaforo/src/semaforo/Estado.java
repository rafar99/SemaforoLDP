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
public class Estado {
    
    private Casa tabuleiro[][];
    private Jogador jogador;

    public Estado() {
        this.tabuleiro = new Casa[3][4];
//        this.Jogador = Jogador;
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
    
    
    public boolean verifica_vitoria(){
        // 1) Verifica existência de uma horizontal com peças iguais
        int i,j;  //i-linhas; j-colunas
        for(i = 0; i < 3; i++){
            for(TipoPeca p : TipoPeca.values()){
                if(p == p.Casa_Vazia)
                    continue;
                int contagem = 0;
                for(j = 0; j < 4; j++){  // verificação horizontal
                    if(this.tabuleiro[i][j].getPeça().equals(p))
                        contagem += 1;
                }
                if (contagem > 2){
                    return true;
                }
            }
        }
        
        for(j=0; j<4; j++){
            for(TipoPeca p : TipoPeca.values()){
                if(p == p.Casa_Vazia)
                    continue;
                int contagem = 0;
                for(i=0; i<3; i++){
                    if(this.tabuleiro[i][j].getPeça().equals(p))
                        contagem += 1;
                }
                
                  if (contagem > 2){
                    return true;
                  }
            }
        }
        return false;
    }
    
    
    public boolean verifica_jogada(int row, int col){
        // 1) Se a peça é vermelha
        if (this.tabuleiro[row][col].getPeça() == TipoPeca.Vermelha){
            return false;
        }
        return true;
    }
    
    
    



    
    
    
}
