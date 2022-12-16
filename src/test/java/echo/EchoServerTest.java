package echo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.ServerSocket;

import static org.junit.jupiter.api.Assertions.*;

public class EchoServerTest {

    ServerSocket serverSocket;
    TestClient client;
    EchoServer echoServer;

    @BeforeEach
    public void setup() throws IOException {
        int portNumber = 8888;
        serverSocket = new ServerSocket(portNumber);
        echoServer = new EchoServer(serverSocket);
        client = new TestClient(portNumber);
    }

    @Test
    public void echoServerReturnsMessagesTest() throws IOException {
        echoServer.start();
        assertEquals("Connected on Port: 8888", client.start());
        assertEquals("hello", client.sendAndReceiveMessage("hello"));
        assertEquals("world", client.sendAndReceiveMessage("world"));
        assertEquals("[SHUTTING DOWN ECHO SERVER]", client.sendAndReceiveMessage("end"));
        assertEquals("ERROR", client.sendAndReceiveMessage("after shutdown, message should not be returned"));
    }

}
