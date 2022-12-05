package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClientSocketTest {
    public ClientSocket clientTest = new ClientSocket();

    @Test
    public void testClientSocketGetsCreated() throws IOException {
        ServerSocket mockServerSocket = mock(ServerSocket.class);
        when(mockServerSocket.accept()).thenReturn(new Socket());
        assertNotNull(
                clientTest.socketCreator(mockServerSocket));
        verify(mockServerSocket, times(1)).accept();
    }

    @Test
    public void testClientSocketCreatorIOExceptionError() {
        Throwable exception = assertThrows(
                RuntimeException.class,
                () -> {
                    ServerSocket mockServerSocket = mock(ServerSocket.class);
                    when(mockServerSocket.accept()).thenThrow(IOException.class);
                    clientTest.socketCreator(mockServerSocket);
                }
        );
        assertEquals("java.io.IOException", exception.getMessage());
    }
}
