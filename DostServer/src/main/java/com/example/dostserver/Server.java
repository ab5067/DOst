package com.example.dostserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable{
    private static ServerSocket socket;
    /**
     * Enumerator that defines the type of the user
     */
    public enum TYPE{
        VOLUNTEER,AFFLICTED
    }
    public enum STATUS{
        ONLINE,OFFLINE
    }

    public Server(int port) {
        try {
            this.socket=new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO: Implement all the functionality to handle all the protocols to and from the client
    @Override
    public void run() {
        ArrayList<ServerHelper> serverHelpers=new ArrayList<>();
        while (true) {
            try {
                Socket server = socket.accept();
                if(server!=null) {
                    ServerHelper serverHelper = new ServerHelper(server);
                    serverHelpers.add(serverHelper);
                    server=null;
                }
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