package callofduty.io;

import callofduty.interfaces.OutputWriter;

public class ConsoleOutputWriter implements OutputWriter {

    public ConsoleOutputWriter() {
    }

    @Override
    public void print(String output) {
        System.out.print(output);
    }

    @Override
    public void println(String output) {
        System.out.println(output);
    }
}
