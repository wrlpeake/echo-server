package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TestClient {

    private final int portNumber;
    InputOutput io = new InputOutput();
    Socket socket;

    public TestClient(int portNumber) {
        this.portNumber = portNumber;
    }

    public String start() throws IOException {
        socket = new Socket("localhost", portNumber);
        return "Connected on Port: " + portNumber;
    }

    public String sendAndReceiveMessage(String userInput) {
        String receivedMessage;
        try {
            PrintWriter writer = io.sendSocketOutputStream(socket);
            io.writeClientOutputStream(writer, userInput);

            BufferedReader in = io.getSocketInputStream(socket);
            receivedMessage = io.readClientInputStream(in);
        } catch (IOException e){
            receivedMessage = "ERROR";
        }
        System.out.printf("[FROM ECHO SERVER] %s%n", receivedMessage);
        return receivedMessage;
    }

}
