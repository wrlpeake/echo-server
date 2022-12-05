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
        ClientSocket clientSocket = new ClientSocket();

        System.out.println("[STARTING ECHO SERVER]");

        while (!serverSocket.isClosed()) {
            try {
                Socket client = clientSocket.socketCreator(this.serverSocket);
                new ClientHandler(client).start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            serverSocket.close();
        }

    }
}
