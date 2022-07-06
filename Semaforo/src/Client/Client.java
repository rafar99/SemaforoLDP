/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.*;
import java.net.*;
import semaforo.Casa;
import semaforo.Jogo;
/**
 * @author rafar e rita
 */
public class Client {
   
    
    String serverName;
    int serverPort;

    Casa casas[][];
    Jogo estado;

    Socket s;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    boolean ligado;

    
   /**
    * O construtor recebe o nome do servidor, ou seja, o ip e a porta.
    * Inicia o socket e o ois, e oos como null
    * @param serverName
    * @param serverPort
   */
            
            
   
     
    public Client() {
        this.serverName = "localhost";
        this.serverPort = 1234;
        this.s = null;
        this.ois = null;
        this.oos = null;
        this.ligado = false;
    }

    /**
     * Este método "iniciar" o utilizador ao servidor
     * @throws IOException
    */
    
     public void iniciar() throws IOException {
        if (!ligado) {
            InetAddress ip = InetAddress.getByName(serverName);
            s = new Socket(ip, serverPort);
            ois = new ObjectInputStream(s.getInputStream());
            oos = new ObjectOutputStream(s.getOutputStream());
        }
        ligado = true;
    }

    public void enviaInfo(Jogo tabuleiro) throws IOException {
        if (ligado) {
            System.out.println(tabuleiro);
            oos.writeObject(tabuleiro.getTabuleiro());
        }
    }

    public Casa[][] recebeInfo() throws IOException, ClassNotFoundException {
        //String mensagem = null;
        if (ligado) {
            casas = (Casa[][]) ois.readObject();
            System.out.println(casas);
        }
        return casas;
    }

    /**
     * Este método desligar o utilizador do servidor
     * @throws IOException
     */
    public void desligar() throws IOException {
        if (ligado) {
            s.close();
            ois = null;
            oos = null;
        }
        ligado = false;
    }



    public static void main(String[] args) throws IOException {
        Client cliente = new Client();

        cliente.iniciar();

        while (true){

        }
    }
    

}
