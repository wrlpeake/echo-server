package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoSocket {

    public static void main (String[] args) {
    int portNumber = 8080;

    try {
            // send message to echo server
            Socket echoSocket = new Socket("localhost", portNumber);
            System.out.println("--- Connected echo server on port 8080 ---");
            BufferedReader stdIn =                                       // 4th statement
                    new BufferedReader(
                            new InputStreamReader(System.in));
            String userInput = stdIn.readLine();
            PrintWriter writer =                                            // 2nd statement
                    new PrintWriter(echoSocket.getOutputStream(), true);
            writer.println(userInput);

            // receive message from echo server
            BufferedReader in = new BufferedReader(
                new InputStreamReader(echoSocket.getInputStream()));
            String returningMessage = in.readLine();
            System.out.printf("[FROM ECHO SERVER] %s%n", returningMessage);
    }
    catch (IOException ex) {
        throw new RuntimeException(ex);
    }
}}