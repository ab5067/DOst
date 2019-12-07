package com.example.dost.ServerClientNetwork;

import java.io.IOException;

public class Volunteer extends client{

    public Volunteer(String hostname, int port, String username, String type) throws IOException {
        super(hostname, port, username, type);
    }
}
