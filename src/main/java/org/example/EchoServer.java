package org.example;

import java.io.IOException;
import java.net.ServerSocket;

public class EchoServer {

    public ServerSocket serverSocketCreator(int portNumber) throws IOException {
        ServerSocket serverSocket = new ServerSocket(portNumber);
        System.out.println("--- Running echo server on port 8080 ---");
        return serverSocket;
    }
}