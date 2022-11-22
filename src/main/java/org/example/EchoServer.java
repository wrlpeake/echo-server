package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main (String[] args) {
    int portNumber = 8080;

    try {
            // receive message from socket
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            System.out.println("--- Running echo server on port 8080 ---");
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
            String clientMessage = in.readLine();
            System.out.printf("[FROM Client] %s%n", clientMessage);

            // send message back to socket
            PrintWriter writer =                                            // 2nd statement
                new PrintWriter(clientSocket.getOutputStream(), true);
            writer.println(clientMessage);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}}