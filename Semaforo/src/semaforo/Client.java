/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.io.*;
import java.net.*;
/**
 *
 * @author rafar e rita
 */
public class Client {
    String serverName;
    int serverPort;

    Socket s;
    DataInputStream dis;
    DataOutputStream dos;
    boolean ligado;

    /**
     *O construtor recebe o nome do servidor, ou seja, o ip e a porta.
     * Inicia o socket e o dis, e dos como null
     * @param serverName
     * @param serverPort
     * 
     *
     */
    public Client(String serverName, int serverPort) {
        this.serverName = serverName;
        this.serverPort = serverPort;
        this.s = null;
        this.dis = null;
        this.dos = null;
        this.ligado = false;
    }

    /**
     * Este método liga o utilizador ao servidor
     * @throws IOException
     */
    public void liga() throws IOException {
        if (!ligado) {
            InetAddress ip = InetAddress.getByName(serverName);
            s = new Socket(ip, serverPort);
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
        }
        ligado = true;
    }

    /**
     * Este método desliga o utilizador do servidor
     * @throws IOException
     */
    public void desliga() throws IOException {
        if (ligado) {
            s.close();
            dis = null;
            dos = null;
        }
        ligado = false;
    }
}
