package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputOutputTest {

    public InputOutput inputOutputTest = new InputOutput();

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

}
