package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientSocket {

    public Socket socketCreator(ServerSocket socket) {
        try {
            return socket.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}