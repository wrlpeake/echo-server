package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TestClient {

    private final int portNumber;
    InputOutput io = new InputOutput();
    Socket socket;

    public TestClient(int portNumber) {
        this.portNumber = portNumber;
    }

    public String start() throws IOException {
        socket = new Socket("localhost", portNumber);
        return "Connected on Port: " + portNumber;
    }

    public String sendAndReceiveMessage(String userInput) {
        try {
            PrintWriter writer = io.sendSocketOutputStream(socket);
            io.writeClientOutputStream(writer, userInput);

            BufferedReader in = io.getSocketInputStream(socket);
            return io.readClientInputStream(in);
        } catch (IOException e){
            return "ERROR";
        }
    }

}
