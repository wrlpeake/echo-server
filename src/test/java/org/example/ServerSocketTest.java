package org.example;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.net.ServerSocket;

class ServerSocketTest {

    public EchoServerSocket serverSocketTest = new EchoServerSocket();

    @Test
    public void testServerSocketGetsCreated() {
        assertNotNull(serverSocketTest.serverSocketCreator(8080));
    }

    @Test
    public void testServerSocketCreatedWithCorrectPort() {
        int portNumber = 7777;
        ServerSocket testServerSocket = serverSocketTest.serverSocketCreator(portNumber);

        assertEquals(testServerSocket.getLocalPort(), portNumber);
    }

    @Test
    public void testServerSocketCreatorThrowsPortError() {
        int portNumber = -1;
        String errorMessage = "Port value out of range: " + portNumber;
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> serverSocketTest.serverSocketCreator(portNumber)
        );
        assertEquals(errorMessage, exception.getMessage());
    }

}



