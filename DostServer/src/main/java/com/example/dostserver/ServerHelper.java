package com.example.dostserver;

import java.io.IOException;
import java.net.Socket;

public class ServerHelper implements Runnable{

    private Duplexer duplexer;

    public ServerHelper(Socket socket) throws IOException {

        duplexer=new Duplexer(socket);
    }
    @Override
    public void run() {

    }
}
