package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class InputOutput {

    public String getUserInput() throws IOException {
        BufferedReader consoleInput =
                new BufferedReader(
                        new InputStreamReader(System.in));
        return consoleInput.readLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public BufferedReader getSocketInputStream(Socket socket) throws IOException {
        return new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
    }

    public PrintWriter sendSocketOutputStream(Socket socket) throws IOException {
        return new PrintWriter(socket.getOutputStream(), true);
    }

    public String readClientInputStream(BufferedReader inputStream) throws IOException {
        return inputStream.readLine();
    }

    public void writeClientOutputStream(PrintWriter writer, String clientMessage) {
        writer.println(clientMessage);
    }

}
