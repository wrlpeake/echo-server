package echo;

import java.io.IOException;
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
            Socket clientSocket = this.serverSocket.accept();
            ClientConnection clientConnection = new ClientConnection(clientSocket, io);
            System.out.println("[CLIENT CONNECTED]");
            String inputMessage;
            while ((inputMessage = clientConnection.receiveMessage()) != null) {
                if (inputMessage.equals("end")) {
                    System.out.println("[ECHO SERVER SHUTTING DOWN]");
                    clientConnection.sendMessage("[SHUTTING DOWN ECHO SERVER]");
                    clientConnection.close();
                    return;
                }
                clientConnection.sendMessage(inputMessage);
            }
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
