package org.example;

import java.io.IOException;
import java.net.ServerSocket;

public class App {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        EchoServer echoServer = new EchoServer(serverSocket);
        echoServer.start();
    }

}

