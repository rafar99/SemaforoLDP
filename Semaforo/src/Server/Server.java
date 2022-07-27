/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Client.ClientConnection;
import comum.Le;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import semaforo.*;

/**
 *
 * @author rafar e rita
 */
public class Server {
    ServerSocket server_socket;
    /**
     * Guarda todas os objetos/informações ligadas à conexão, ou seja, os sockets, players, inputs, outputs...
     */
    private ArrayList<ServerConnection> players;
    
    /**
     *
     */
    public Server(){
        System.out.println("Servidor em startup");
        
        this.players = new ArrayList<>();
        try{
            this.server_socket = new ServerSocket(6666);
        } catch (Exception ex){
            System.out.println("Erro ao ligar servidor: " + ex.toString());
        }
    }
    
    /**
     *
     * @param i
     * @return
     */
    public ServerConnection getPlayer(int i){
        try{
            return this.players.get(i);
        } catch (Exception ex){
            return null;
        }
    }
    
    /**
     * Assim que o servidor é iniciado, executa este método. 
     * Ou seja, o servidor fica à espera de receber as conexões dos clientes, neste caso definimos apenas dois.
     * Cada vez que um jogador se conecta é gerado um novo servidor ligado a ele
     */
    public void executa(){
        System.out.println("A aceitar conexões...");
        try{
            while(this.players.size() < 2){
                Socket socket = this.server_socket.accept(); // Quando é feita a conexão é gerada uma nova ligação ao servidor
                ServerConnection con = new ServerConnection(socket, this, this.players.size()); // novo servidor do jogador
                this.players.add(con);
                Thread th = new Thread(con);
                th.start();
            }
            System.out.println("Servidor cheio.");
        } catch(IOException ex){
            System.out.println("Erro ao aceitar conexão: " + ex.toString());   
        }
    }
    
    /**
     * Cria e inicia o servidor
     * @param args
     */
    public static void main(String[] args){
        Server server = new Server();
        server.executa();
    }
}
