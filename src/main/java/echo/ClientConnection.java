package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientConnection {
    private BufferedReader in;
    private PrintWriter out;
    private final Socket clientSocket;
    private final InputOutput io;

    public ClientConnection(Socket clientSocket, InputOutput io) throws IOException {
        this.io = io;
        this.clientSocket = clientSocket;
        in = io.getSocketInputStream(clientSocket);
        out = io.sendSocketOutputStream(clientSocket);

    }

    public String receiveMessage() throws IOException {
        return io.readClientInputStream(in);
    }

    public void sendMessage(String message) {
        io.writeClientOutputStream(out, message);
    }

    public void close() throws IOException {
        clientSocket.close();
        in = null;
        out = null;
    }
}
