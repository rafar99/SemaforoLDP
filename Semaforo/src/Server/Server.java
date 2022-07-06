/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

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
    
//    final static int serverPort = 1234;
//    ServerSocket ss;
//    Socket s;
//    ObjectInputStream ois;
//    ObjectOutputStream oos;
//    
//    Casa casas[][];
//    
//    public Server() throws Exception{
//        startServer();
//    }
//    public void startServer() throws ClassNotFoundException{
//        try {
//            // Cria o servidor para receber coneções.
//            ss = new ServerSocket(serverPort);
//            while(true){
//                // Aguarda que receba uma coneção
//                System.out.println("ENTROU AQUI");
//                s = ss.accept();
//                System.out.println("Servidor a correr...");
//                // Ao recebr uma coneção obtem o respetivo stream
//                ois = new ObjectInputStream(s.getInputStream());
//                oos = new ObjectOutputStream(s.getOutputStream());
//                receberCasas();
//            }
//            
//            } catch (IOException | ClassNotFoundException e) {
//                System.out.println(e.getMessage());
//            }
//    }
//    
//    public Casa[][] receberCasas() throws IOException, ClassNotFoundException{
//        casas = (Casa[][]) ois.readObject();
//        System.out.println("Casa recebida: ");
//        return casas;
//    }
//
//    public void enviarCasas(Jogo tabuleiro) throws IOException, ClassNotFoundException{
//        oos.writeObject(tabuleiro.getTabuleiro());
//    }
//    
//    public void enviaTeste(String msg) throws IOException {
//        oos.writeUTF(msg);
//    }
//    
//    public void closeServer()throws IOException{
//        ois.close();
//        oos.close();
//        s.close();
//    }
//    
//    public static void main(String[] args) throws IOException, ClassNotFoundException, Exception {
//        Server s = new Server();
////        s.runServer();
//        s.receberCasas();
//    }
    
        public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(6666);
        System.out.println("Aceita conecções ...");
        Socket s = ss.accept();
        System.out.println("Conectando com " + s.getInetAddress().getHostAddress());

        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strCli = "", strSer = "";

        while (!strCli.equals("stop")){
            strCli = din.readUTF();
            System.out.println("Cliente: " + strCli);                        
            strSer = br.readLine();
            dout.writeUTF(strSer);
            dout.flush();
        }

        dout.close();
        s.close();
        ss.close();

    }
}
