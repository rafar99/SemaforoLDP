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
    
    private ArrayList<ServerConnection> players;
    
    public Server(){
        System.out.println("Servidor em startup");
        
        this.players = new ArrayList<>();
        try{
            this.server_socket = new ServerSocket(6666);
        } catch (Exception ex){
            System.out.println("Erro ao ligar servidor: " + ex.toString());
        }
    }
    
    public ServerConnection getPlayer(int i){
        try{
            return this.players.get(i);
        } catch (Exception ex){
            return null;
        }
    }
    
    public void executa(){
        System.out.println("A aceitar conexoes...");
        try{
            while(this.players.size() < 2){
                Socket socket = this.server_socket.accept();
                ServerConnection con = new ServerConnection(socket, this, this.players.size());
                this.players.add(con);
                Thread th = new Thread(con);
                th.start();
            }
            System.out.println("Servidor cheio.");
        } catch(IOException ex){
            System.out.println("Erro ao aceitar conexao: " + ex.toString());   
        }
    }
    
    public static void main(String[] args){
        Server server = new Server();
        server.executa();
    }
}
