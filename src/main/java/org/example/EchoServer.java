package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private final ServerSocket serverSocket;

    public EchoServer(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void start() throws IOException {
        System.out.println("[STARTING ECHO SERVER]");

        while (!serverSocket.isClosed()) {
            try {
                Socket client = this.serverSocket.accept();
                new ClientHandler(client).start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            serverSocket.close();
        }

    }
}
