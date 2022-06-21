/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author rafar
 */
public class Server {
    static List<ClientHandler> jogadores = new ArrayList<>();
    static int i = 0;
    final static int ServerPort = 1234;

    public static void main(String[] args) throws IOException {
        System.out.println("Servidor aceita conexões.");
        ServerSocket ss = new ServerSocket(ServerPort);

        Socket s;
        while (true) {
            s = ss.accept();
            System.out.println("Novo client recebido : " + s);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            ClientHandler mtch = new ClientHandler(s, "client " + i, dis, dos);
            Thread t = new Thread(mtch);

            System.out.println("Adiciona cliente " + i + " à lista ativa.");
            jogadores.add(mtch);
            t.start();

            i++;
        }
    }

    private static class ClientHandler implements Runnable {

        private String name;
        final DataInputStream dis;
        final DataOutputStream dos;
        Socket s;
        boolean isloggedin;

        private ClientHandler(Socket s, String name,
                DataInputStream dis, DataOutputStream dos) {
            this.s = s;
            this.dis = dis;
            this.dos = dos;
            this.name = name;
            this.isloggedin = true;
        }

        @Override
        public void run() {
            String recebido;

            while (true) {
                try {
                    recebido = dis.readUTF();
                    System.out.println(recebido);
                    if (recebido.endsWith("logout")) {
                        this.isloggedin = false;
                        this.s.close();
                        break; // while
                    }
                    /**/

                    for (ClientHandler ch : Server.jogadores) {
                        if (ch.isloggedin) {
                            ch.dos.writeUTF(recebido);
                            break;
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
