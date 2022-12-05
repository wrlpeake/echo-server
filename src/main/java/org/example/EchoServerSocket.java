package org.example;

import java.io.IOException;
import java.net.ServerSocket;

public class EchoServerSocket {

    public ServerSocket serverSocketCreator(int portNumber) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("--- Created Server Socket ---");
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.exit(1);
        }
        return serverSocket;
    }
}