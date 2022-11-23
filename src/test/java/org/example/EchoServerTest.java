package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class EchoServerTest {

    public EchoServer echoServerTest = new EchoServer();
    public ClientSocket clientSocketTest = new ClientSocket();

    @Test
    public void testServerSocketGetsCreated() throws IOException {
        assertNotNull(echoServerTest.serverSocketCreator(8080));
    }

    @Test
    public void testServerSocketCreatedWithCorrectPort() throws IOException {
        int portNumber = 7777;
        try (ServerSocket testServerSocket = echoServerTest.serverSocketCreator(portNumber)) {

            assertEquals(testServerSocket.getLocalPort(), portNumber);
        }
    }
    @Test
    public void testClientSocketGetsCreated() throws IOException {
        ServerSocket mockServerSocket = mock(ServerSocket.class);
        when(mockServerSocket.accept()).thenReturn(new Socket());
        assertNotNull(
                clientSocketTest.socketCreator(mockServerSocket));
    }
}



