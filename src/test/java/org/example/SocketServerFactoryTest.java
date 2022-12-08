package org.example;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.net.ServerSocket;

class SocketServerFactoryTest {

    public SocketServerFactory socketServerFactoryTest = new SocketServerFactory();

    @Test
    public void testServerSocketGetsCreated() {
        assertNotNull(socketServerFactoryTest.create(8080));
    }

    @Test
    public void testServerSocketCreatedWithCorrectPort() {
        int portNumber = 7777;
        ServerSocket testServerSocket = socketServerFactoryTest.create(portNumber);

        assertEquals(testServerSocket.getLocalPort(), portNumber);
    }

    @Test
    public void testServerSocketCreatorThrowsPortError() {
        int portNumber = -1;
        String errorMessage = "Port value out of range: " + portNumber;
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> socketServerFactoryTest.create(portNumber)
        );
        assertEquals(errorMessage, exception.getMessage());
    }

}



