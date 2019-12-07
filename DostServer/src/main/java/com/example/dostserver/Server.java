package com.example.dostserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
    private static ServerSocket server;

    public Server(int port) {
        try {
            this.server=new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO: Implement all the functionality to handle all the protocols to and from the client
    @Override
    public void run() {
        while (true) {
            try {
                Socket user = server.accept();
                Duplexer duplexer=new Duplexer(user);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Running the server in the main
     * @param args
     */
    public static void main(String[] args){
        if(args.length!=3){
            System.out.println("Usage: java Server <port>");
        }
        Server server=new Server(Integer.parseInt(args[2]));
        server.run();
    }
}