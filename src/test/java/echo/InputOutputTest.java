package echo;

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
