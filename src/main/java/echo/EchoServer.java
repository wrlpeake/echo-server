package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer extends Thread {

    private final ServerSocket serverSocket;
    private final InputOutput io;

    public EchoServer(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        io = new InputOutput();
    }

    public void run() {
        try {
            System.out.println("[STARTING ECHO SERVER]");
            Socket client = this.serverSocket.accept();
            System.out.println("[CLIENT CONNECTED]");
            BufferedReader in = io.getSocketInputStream(client);
            PrintWriter out = io.sendSocketOutputStream(client);
            String userInput;
            while ((userInput = io.readClientInputStream(in)) != null) {
                if (userInput.equals("end")) {
                    System.out.println("[ECHO SERVER SHUTTING DOWN]");
                    io.writeClientOutputStream(out, "[SHUTTING DOWN ECHO SERVER]");
                    client.close();
                    return;
                }
                new EchoMessageBus(io, userInput, out).start();
            }
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
