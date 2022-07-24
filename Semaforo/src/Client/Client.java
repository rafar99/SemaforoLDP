package Client;

import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import semaforo.Jogo;

public class Client extends Thread {
    
    private ClientConnection conn;
    
    public Client(ClientConnection conn){
        this.conn = conn;
    }
    
    @Override
    public void run(){
        System.out.println("Client thread running...");
        while(true){
            try {
                this.sleep(60);
            } catch (Exception ex) {
                System.out.println("Fail: " + ex.toString());
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
                        System.out.println("Waiting for state of other player...");
                        Jogo j = (Jogo) this.conn.getObjectInputStream().readObject();
                        this.conn.setJogo(j);
                        this.conn.getController().updateWindow();
                        this.conn.setFlagJogar();   // Torna-se Verdadeiro porque estarei a jogar
                    }
                }
            } catch (Exception ex) {
                System.out.println("Fail: " + ex.toString());
            }
        }
    }
}