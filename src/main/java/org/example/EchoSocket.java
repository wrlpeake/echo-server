package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoSocket {

    public Socket socketCreator(ServerSocket socket) throws IOException {
        return socket.accept();
    }
}