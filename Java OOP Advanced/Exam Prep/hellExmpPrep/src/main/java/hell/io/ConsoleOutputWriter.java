package hell.io;

import hell.interfaces.OutputWriter;

public class ConsoleOutputWriter implements OutputWriter {

    public ConsoleOutputWriter() {
    }

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void writeLine(String format, Object... params) {
        System.out.printf(format,params);
    }
}
