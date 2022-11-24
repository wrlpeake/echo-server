package org.example;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.ServerSocket;

class EchoServerTest {

    public EchoServer echoServerTest = new EchoServer();

    @Test
    public void testServerSocketGetsCreated() {
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
    public void testServerSocketCreatorThrowsPortError() {
        int portNumber = -1;
        String errorMessage = "Port value out of range: " + portNumber;
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> echoServerTest.serverSocketCreator(portNumber)
        );
        assertEquals(errorMessage, exception.getMessage());
    }

}



