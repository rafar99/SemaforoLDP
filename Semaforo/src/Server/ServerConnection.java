/*
 */
package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import semaforo.Jogo;

public class ServerConnection implements Runnable {
    
    private Socket socket;
    private ObjectInputStream incoming;
    private ObjectOutputStream outgoing;
    private int id;
    private Server main_server;
    
    //private Server server;
    
    public ServerConnection(Socket s, Server main_server, int id){
        this.socket = s;
        this.main_server = main_server;
        this.id = id;
        
        System.out.println("Conexao feita ao jogador com ID " + this.id);
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
    
    public ObjectOutputStream getObjectOutputStream(){
        return this.outgoing;
    }
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Esperando informaçao...");
                Jogo j = (Jogo) this.incoming.readObject();
                if(j.getJogadorAtual() == 1){
                    ServerConnection pl = this.main_server.getPlayer(1);
                    if(pl != null){
                        System.out.println("A enviar estado do jogo ao jogador 1");
                        ObjectOutputStream oos = pl.getObjectOutputStream();
                        oos.writeObject(j);
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
                System.out.println("Fail: " + ex.toString());
            }
        }   
    }   
}
