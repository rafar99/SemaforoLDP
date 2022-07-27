package Client;

import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import semaforo.Jogo;

/**
 *
 * @author anari e rafa
 */
public class Client extends Thread {
    
    private ClientConnection conn;
    
    /**
     * 
     * @param conn
     */
    public Client(ClientConnection conn){
        this.conn = conn;
    }
    
    /**
     * A classe executa o método run. Neste método são verificadas duas hipóteses. Ou seja, quando o jogador atual acabou mesmo agora de jogar, ou quando acabou de jogar já há algum tempo. 
     * No primeiro caso, entra no if, ou seja, a flagJogar ainda se encontra a true. Assim que termina a jogada, o estado atual do tabuleiro é escrito e enviado ao meu adversário.
     * No final, a flagJogar volta a tornar-se false para o jogador atual, fazendo o flush no fim. 
     * No caso de o jogador atual ter acabado de jogar há algum tempo e se encontrar à espera de receber informação, entra no else, ou seja, a sua flagJogar já se encontra a false. 
     * Recebe o estado atual do jogo do adversário, faz o update da interface tendo em conta o que recebeu, e a flagJogar muda para true. 
     * 
     * Sleep(60) -> colocado por causa da thread ficar "presa" em algum sitio, ou seja, depois de uma jogada faz o sleep de 1 segundo e evita ficar "preso"
     */
    @Override
    public void run(){
        System.out.println("Thread do cliente a correr...");
        while(true){
            try {
                this.sleep(60);
            } catch (Exception ex) {
                System.out.println("Falha: " + ex.toString());
            }
            try {
                if(this.conn.getJogo().getJogadorAtual() != this.conn.getPlayerId()){
                    if(this.conn.getFlagJogar()){
                        // Finalizei a minha jogada e vou enviar informaçao
                        ObjectOutputStream oos = this.conn.getObjectOutputStream();
                        oos.writeObject(this.conn.getJogo());
                        this.conn.setFlagJogar();   // Torna-se False porque acabei de jogar
                        System.out.println("Estado enviado para o servidor!");
                        oos.flush();
                    } else{
                        // É a vez do outro jogador jogar por isso vou esperar informaçao
                        System.out.println("A aguardar estado do outro jogador...");
                        Jogo j = (Jogo) this.conn.getObjectInputStream().readObject();
                        this.conn.setJogo(j);
                        this.conn.getController().updateWindow();
                        this.conn.setFlagJogar();   // Torna-se Verdadeiro porque estarei a jogar
                    }
                }
            } catch (Exception ex) {
                System.out.println("Falha: " + ex.toString());
            }
        }
    }
}