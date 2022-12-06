package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandlerTest {
    ClientHandler clientHandler;
    ServerSocket serverSocket;
    Socket socket;
    PrintStream mockPrintStream;

    @BeforeEach
    public void setup() throws IOException {
        int portNumber = 8888;
        serverSocket = new ServerSocket(portNumber);
        socket = new Socket("localhost", portNumber);
        mockPrintStream = Mockito.mock(PrintStream.class);
        System.setOut(mockPrintStream);
    }

    @Test
    public void hasStartBeenCalledTest() {
        String message = "[CLIENT CONNECTED]";
        clientHandler = new ClientHandler(socket);
        clientHandler.start();

        Mockito.verify(mockPrintStream).println(message);
    }

}
