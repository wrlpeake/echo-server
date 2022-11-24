package org.example;

import java.io.IOException;
import java.net.ServerSocket;

public class EchoServer {

    public ServerSocket serverSocketCreator(int portNumber) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("--- Running echo server ---");
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.exit(1);
        }
        return serverSocket;
    }
}