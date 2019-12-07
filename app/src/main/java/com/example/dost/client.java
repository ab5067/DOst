package com.example.dost;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class client implements Runnable {
    public Scanner scanner;
    public PrintWriter writer;
    private ArrayList<String> messages;

    public client(Socket client) throws IOException {
        scanner = new Scanner(client.getInputStream());
        writer = new PrintWriter(client.getOutputStream());
    }

    /*public void main(String[] args) throws IOException {
        // Set the ipaddress to be the IP address of the Device
        final String ipaddress = "localhost";
        //set the port for Server
        final int port = 11267;
        Socket socket = new Socket(ipaddress, port);
        client client = new client(socket);
        new Thread(client).start();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = messages.get(messages.size() - 1);
            if (message.equals("EXIT")) {
                socket.close();
                System.exit(0);
            }
            client.writer.println(message);
            client.writer.flush();
        }
    }*/

    @Override
    public void run() {
        while (true) {
            String message = scanner.nextLine();
            System.out.println(message);
        }
    }
}
