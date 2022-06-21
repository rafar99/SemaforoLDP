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
    
    Client cs;
    String ServerName = "192.168.0.103";
    int ServerPort = 1234;
    public Estado() {
        
        this.cs = new Client(ServerName, ServerPort);

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
    
    
   
    
    //Metodo que devolve se as casas irão ter as 3 peças da mesma cor
    public boolean verificaPeca(Casa p1, Casa p2, Casa p3) {
        if (p1.getPeça() == TipoPeca.Verde && p2.getPeça() == TipoPeca.Verde && p3.getPeça() == TipoPeca.Verde) {
            return true;
        } else if (p1.getPeça() == TipoPeca.Amarela && p2.getPeça() == TipoPeca.Amarela && p3.getPeça() == TipoPeca.Amarela) {
            return true;
        } else if (p1.getPeça() == TipoPeca.Vermelha && p2.getPeça() == TipoPeca.Vermelha && p3.getPeça() == TipoPeca.Vermelha) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public boolean venceuJogo() {
        boolean resultado;

        //verificar primeiras 3 posiçoes da primeira linha
        if (verificaPeca(tabuleiro[0][0], tabuleiro[0][1], tabuleiro[0][2])) {
            resultado = true;
        } //verificar ultimas 3 posiçoes da primeira linha
        else if (verificaPeca(tabuleiro[0][1], tabuleiro[0][2], tabuleiro[0][3])) {
            resultado = true;
        } //verificar primeiras 3 posiçoes da segunda linha
        else if (verificaPeca(tabuleiro[1][0], tabuleiro[1][1], tabuleiro[1][2])) {
            resultado = true;
        } //verificar ultimas 3 posiçoes da segunda linha
        else if (verificaPeca(tabuleiro[1][1], tabuleiro[1][2], tabuleiro[1][3])) {
            resultado = true;
        } //verificar primeiras 3 posiçoes da terceira linha
        else if (verificaPeca(tabuleiro[2][0], tabuleiro[2][1], tabuleiro[2][2])) {
            resultado = true;
        } //verificar ultimas 3 posiçoes da terceira linha
        else if (verificaPeca(tabuleiro[2][1], tabuleiro[2][2], tabuleiro[2][3])) {
            resultado = true;
        } //verificar a 1ºcoluna
        else if (verificaPeca(tabuleiro[0][0], tabuleiro[1][0], tabuleiro[2][0])) {
            resultado = true;
        } //verificar a 2ºcoluna
        else if (verificaPeca(tabuleiro[0][1], tabuleiro[1][1], tabuleiro[2][1])) {
            resultado = true;
        } //verificar a 3ºcoluna
        else if (verificaPeca(tabuleiro[0][2], tabuleiro[1][2], tabuleiro[2][2])) {
            resultado = true;
        } //verificar a 4ºcoluna
        else if (verificaPeca(tabuleiro[0][3], tabuleiro[1][3], tabuleiro[2][3])) {
            resultado = true;
        } //verificar a 1ºdiagonal
        else if (verificaPeca(tabuleiro[0][0], tabuleiro[1][1], tabuleiro[2][2])) {
            resultado = true;
        } //verificar 2ºdiagonal
        else if (verificaPeca(tabuleiro[0][1], tabuleiro[1][2], tabuleiro[2][3])) {
            resultado = true;
        } //verificar 3ºdiagonal
        else if (verificaPeca(tabuleiro[0][2], tabuleiro[1][1], tabuleiro[2][0])) {
            resultado = true;
        } //verificar 4ºdiagonal 
        else if (verificaPeca(tabuleiro[0][3], tabuleiro[1][2], tabuleiro[2][1])) {
            resultado = true;
        } else {
            resultado = false;
        }
        return resultado;
    }

    
    public boolean verifica_jogada(int row, int col){
        // 1) Se a peça é vermelha
        if (this.tabuleiro[row][col].getPeça() == TipoPeca.Vermelha){
            return false;
        }
        return true;
    }
}
