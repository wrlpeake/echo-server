package org.example;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketServerFactory {

    public ServerSocket create(int portNumber) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("--- Created Server Socket ---");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return serverSocket;
    }
}