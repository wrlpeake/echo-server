package org.example;

import java.io.IOException;
import java.net.Socket;

public class EchoSocket {

    public Socket socketCreator(int portNumber) throws IOException {
        Socket echoSocket = new Socket("localhost", portNumber);
        System.out.println("--- Connected to echo server on port 8080 ---");
        return echoSocket;
    }
}