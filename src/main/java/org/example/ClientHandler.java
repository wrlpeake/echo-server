package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
    private final Socket clientSocket;
    InputOutput io = new InputOutput();

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            System.out.println("[CLIENT CONNECTED]");
            BufferedReader in = io.getSocketInputStream(clientSocket);
            PrintWriter out = io.sendSocketOutputStream(clientSocket);
            String userInput;
            while((userInput = io.readClientInputStream(in)) != null) {
                if (userInput.equals("end")) {
                    io.writeClientOutputStream(out, "[SHUTTING DOWN ECHO SERVER]");
                    System.out.println("[SHUTTING DOWN]");
                    return;
                }
                io.writeClientOutputStream(out, userInput);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}