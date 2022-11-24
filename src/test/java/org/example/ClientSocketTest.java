package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientSocketTest {
    public ClientSocket clientSocketTest = new ClientSocket();

    @Test
    public void testClientSocketCreatorIOExceptionError() {
        Throwable exception = assertThrows(
                RuntimeException.class,
                () -> {
                    ServerSocket mockServerSocket = mock(ServerSocket.class);
                    when(mockServerSocket.accept()).thenThrow(IOException.class);
                    clientSocketTest.socketCreator(mockServerSocket);
                }
        );
        assertEquals("java.io.IOException", exception.getMessage());
    }

    @Test
    public void testClientSocketGetsCreated() throws IOException {
        ServerSocket mockServerSocket = mock(ServerSocket.class);
        when(mockServerSocket.accept()).thenReturn(new Socket());
        assertNotNull(
                clientSocketTest.socketCreator(mockServerSocket));
    }
}
