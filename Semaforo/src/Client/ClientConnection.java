/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.*;
import java.net.*;
import semaforo.FXMLDocumentController;
import semaforo.Jogo;
import semaforo.Semaforo;
/**
 *
 * @author rafar e rita
 */
public class ClientConnection {
    
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Client thread;
    private Jogo jogo;
    private int player_id;
    private boolean flag_jogar;
    private FXMLDocumentController controller;
    
    public ObjectInputStream getObjectInputStream(){
        return this.ois;
    }
    
    public ObjectOutputStream getObjectOutputStream() {
        return this.oos;
    }
    
    
    public ClientConnection(FXMLDocumentController controller) throws Exception{
        this.socket = new Socket("0.0.0.0", 6666);
        this.controller = controller;
        this.flag_jogar = false;
  
        System.out.println("conectando com " + this.socket.getInetAddress().getHostAddress());

        this.oos = new ObjectOutputStream(this.socket.getOutputStream());
        this.ois = new ObjectInputStream(this.socket.getInputStream());

        // Id do jogador
        this.player_id = ois.readInt();
        System.out.println("Tenho o ID: " + this.player_id);

        if(this.player_id == 0)
            this.flag_jogar = true;
        
        
        // Estado inicial do jogo
        this.jogo = new Jogo();
        this.thread = new Client(this);

        //this.controller.updateWindow();

        this.thread.start();
    }
    
    public int getPlayerId(){
        return this.player_id;
    }
    
    public Jogo getJogo(){
        return this.jogo;
    }

    public void setJogo(Jogo j) {
        this.jogo = j;
    }
    
    public boolean getFlagJogar(){
        return this.flag_jogar;
    }
    
    public void setFlagJogar(){
        this.flag_jogar = !this.flag_jogar; 
    }
    
    public FXMLDocumentController getController(){
        return this.controller;
    }
    
}
