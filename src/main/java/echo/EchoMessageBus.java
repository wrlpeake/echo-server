package echo;

import java.io.IOException;
import java.io.PrintWriter;

public class EchoMessageBus extends Thread {
    private final PrintWriter out;
    private final InputOutput io;
    private final String userInput;

    public EchoMessageBus(InputOutput io, String userInput, PrintWriter out) throws IOException {
        this.io = io;
        this.userInput = userInput;
        this.out = out;
    }
    public void run() {
        System.out.printf("[FROM CLIENT] %s%n", userInput);
        publishMessage(out, userInput);
    }
    public void publishMessage(PrintWriter out, String message) {
            io.writeClientOutputStream(out, message);
    }

}

