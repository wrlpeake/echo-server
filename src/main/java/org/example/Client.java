package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        InputOutput io = new InputOutput();
        int portNumber = 8080;
        Socket client = new Socket("localhost", portNumber);
        System.out.println("--- Connected echo server on port 8080 ---");
        while(client.isBound()) try {
            String userInput = io.getUserInput();
            PrintWriter writer = io.sendSocketOutputStream(client);
            io.writeClientOutputStream(writer, userInput);

            BufferedReader in = io.getSocketInputStream(client);
            String returningMessage = io.readClientInputStream(in);
            System.out.printf("[FROM ECHO SERVER] %s%n", returningMessage);
            if (returningMessage.equals("[SHUTTING DOWN ECHO SERVER]")) {
                System.out.println("Shutting down Client...");
                return;
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
