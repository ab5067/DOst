package com.example.dost;

import java.io.IOException;
import java.net.ServerSocket;

public class Server implements Runnable{
    private static ServerSocket server;
    private int NumberOfUsers;

    public Server(int port){
        try {
            this.server=new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    }
}