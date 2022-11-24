package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientSocket {

    public Socket socketCreator(ServerSocket socket) {
        Socket clientSocket;
        try {
            clientSocket = socket.accept();
            System.out.println("--- Connected to echo server ---");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return clientSocket;
    }
}