package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.*;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class InputOutputTest {

    public InputOutput inputOutputTest = new InputOutput();
    Socket mockSocket = Mockito.mock(Socket.class);
    InputStream mockInputStream = Mockito.mock(InputStream.class);
    OutputStream mockOutputStream = Mockito.mock(OutputStream.class);

    @Test
    public void getUserInputTest() throws IOException {
        String userInput = "hello world";
        BufferedReader bufferedReaderTest =                                       // 4th statement
                new BufferedReader(
                        new InputStreamReader(new ByteArrayInputStream(userInput.getBytes())));

        assertEquals(userInput, inputOutputTest.getUserInput(bufferedReaderTest));
    }

    @Test
    public void printUserInputTest() {
        String userInput = "can we print?";

        PrintStream mockPrintStream = Mockito.mock(PrintStream.class);
        System.setOut(mockPrintStream);
        inputOutputTest.printUserInput(userInput);

        Mockito.verify(mockPrintStream).println(userInput);
    }

    @Test
    public void getSocketInputStreamTest() throws IOException {
        when(mockSocket.getInputStream()).thenReturn(mockInputStream);

        assertNotNull(inputOutputTest.getSocketInputStream(mockSocket));
    }

    @Test
    public void sendSocketOutputStreamTest() throws IOException {
        when(mockSocket.getOutputStream()).thenReturn(mockOutputStream);

        assertNotNull(inputOutputTest.sendSocketOutputStream(mockSocket));
    }

    @Test
    public void readClientSocketInputStreamTest() throws IOException {
        String inputStream = "testing 123";
        BufferedReader bufferedReaderTest =                                       // 4th statement
                new BufferedReader(
                        new InputStreamReader(new ByteArrayInputStream(inputStream.getBytes())));

        assertEquals(inputStream, inputOutputTest.readClientInputStream(bufferedReaderTest));
    }

    @Test
    public void writeClientSocketOutputStreamTest() {
        String clientMessage = "mic check 1, 2";
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        PrintWriter writer = new PrintWriter(output, true);

        inputOutputTest.writeClientOutputStream(writer, clientMessage);

        assertEquals((clientMessage + "\n"), output.toString());
    }

}
