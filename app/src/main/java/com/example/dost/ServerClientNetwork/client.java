package com.example.dost.ServerClientNetwork;

import java.io.IOException;
import java.net.Socket;

public class client implements Runnable,Protocols {
    private Duplexer duplexer;
    private String username;
    private String type;
    public client(String hostname,int port, String username,String type) throws IOException {
        this.duplexer=new Duplexer(new Socket(hostname,port));// creating a new Duplexer object
        this.username=username;
        this.type=type;
    }
    /**
     * Will be implementing the protocols for the server
     */
    @Override
    public void run() {
        boolean serverStatus=true;
        while (serverStatus){
            if(!this.duplexer.nextLine()){
                try {
                    throw new CommException("The server is down");
                } catch (CommException e) {
                    e.printStackTrace();
                }
            }
            String message=this.duplexer.read();
            String[] messages=message.split(" ");
            switch (messages[0]){
                case ONLINE:
                    System.out.println("Connected to the server");
                    break;
                case CONNECT:
                    break;
                case SEND:
                    break;
                case ACTIVE_USERS:
                    break;
                case DISCONNECT:// if they are disconnecting from a user
                    serverStatus=false;
                    break;
                case TYPE:
                    break;
                case ERROR:
                    serverStatus=false;
                    break;
            }
        }
    }

}
