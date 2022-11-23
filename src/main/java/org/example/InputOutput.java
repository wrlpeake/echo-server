package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class InputOutput {

    public String getUserInput(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine();
    }

    public void printUserInput(String userInput) {
        System.out.println(userInput);
    }
}
