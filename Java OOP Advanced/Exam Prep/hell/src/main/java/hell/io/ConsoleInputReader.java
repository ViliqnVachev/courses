package hell.io;

import hell.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputReader implements InputReader {
    private BufferedReader reader;

    public ConsoleInputReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() {
        String result = null;
        try {
            result = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
