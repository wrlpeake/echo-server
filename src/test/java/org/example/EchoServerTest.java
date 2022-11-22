package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.ServerSocket;

class EchoServerTest {

    public EchoServer echoServerTest = new EchoServer();

    @Test
    public void testServerSocketGetsCreated() throws IOException {
        assertNotNull(echoServerTest.serverSocketCreator(8080));
    }

    @Test
    public void testServerSocketCreatedWithCorrectPort() throws IOException {
        int portNumber = 7777;
        ServerSocket testServerSocket = echoServerTest.serverSocketCreator(portNumber);

        assertEquals(testServerSocket.getLocalPort(), portNumber);
    }
}



