package warning_levels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String level = reader.readLine();
        Logger logger = new Logger(level);

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String[] tokens = line.split(":\\s+");

            Message message = new Message(tokens[0], tokens[1]);
            logger.addMessages(message);
            line = reader.readLine();
        }

        Iterable<Message> messages = logger.getMessage();

        for (Message message : messages) {
            System.out.println(message);
        }
    }
}
