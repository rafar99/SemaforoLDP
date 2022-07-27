/*
 */
package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import semaforo.Jogo;

/**
 *
 * @author anari rafa
 */
public class ServerConnection implements Runnable {
    
    private Socket socket;
    private ObjectInputStream incoming;
    private ObjectOutputStream outgoing;
    private int id;
    private Server main_server;
    
    //private Server server;

    /**
     * O construtor trata de enviar a informação dos ids dos jogadores
     * @param s
     * @param main_server
     * @param id
     * 
     */
    
    public ServerConnection(Socket s, Server main_server, int id){
        this.socket = s;
        this.main_server = main_server;
        this.id = id;
        
        System.out.println("Conexão feita ao jogador com ID " + this.id);
        try {
            this.incoming = new ObjectInputStream(this.socket.getInputStream());
            this.outgoing = new ObjectOutputStream(this.socket.getOutputStream());
            
            this.outgoing.writeInt(id);
            this.outgoing.flush();
            System.out.println("Enviado ID ao jogador!");
        } catch (IOException ex) {
            System.out.println("Erro a configurar streams:" + ex.toString());
        } catch (Exception ex) {
            System.out.println("Erro a configurar streams (other):" + ex.toString());
        }
    }
    
    /**
     *
     * @return this.outgoing
     */
    public ObjectOutputStream getObjectOutputStream(){
        return this.outgoing;
    }

    /**
     * Este método é corrido em loop. Verifica qual o jogador atual, se o jogador com id 1 ou 0. 
     * Posteriormente, envia o estado do jogo consoante o jogador que se encontra a jogar
     * 
     * 
     */
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Esperando informação...");
                Jogo j = (Jogo) this.incoming.readObject();  // fica "preso" até alguém enviar informação
                if(j.getJogadorAtual() == 1){
                    ServerConnection pl = this.main_server.getPlayer(1);
                    if(pl != null){
                        System.out.println("A enviar estado do jogo ao jogador 1");
                        ObjectOutputStream oos = pl.getObjectOutputStream();
                        oos.writeObject(j); // envia um tabuleiro completo
                        oos.flush();
                    } else {
                        System.out.println("Falta um jogador...");
                    }                      }
                else if(j.getJogadorAtual() == 0){
                    ServerConnection pl = this.main_server.getPlayer(0);
                    if(pl != null){
                        System.out.println("A enviar estado do jogo ao jogador 0");
                        ObjectOutputStream oos = pl.getObjectOutputStream();
                        oos.writeObject(j);
                        oos.flush();
                    } else {
                        System.out.println("Falta um jogador...");
                    }                    
                }
            } catch (Exception ex) {
                System.out.println("Falha: " + ex.toString());
            }
        }   
    }   
}
