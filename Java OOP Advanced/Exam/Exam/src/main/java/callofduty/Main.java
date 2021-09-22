package callofduty;

import callofduty.core.MissionManagerImpl;
import callofduty.interfaces.InputReader;
import callofduty.interfaces.MissionManager;
import callofduty.interfaces.OutputWriter;
import callofduty.io.ConsoleInputReader;
import callofduty.io.ConsoleOutputWriter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //TODO: Implement me ...
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        MissionManager manager = new MissionManagerImpl();
        // Mission asd= new Escort()


        while (true) {
            String[] tokens = reader.readLine().split("\\s+");
            String command = tokens[0];
            List<String> arguments = Arrays.stream(tokens).skip(1).collect(Collectors.toList());

            switch (command) {
                case "Agent":
                    writer.println(manager.agent(arguments));
                    break;
                case "Request":
                    writer.println(manager.request(arguments));
                    break;
                case "Complete":
                    writer.println(manager.complete(arguments));
                    break;
                case "Status":
                    writer.println(manager.status(arguments));
                    break;
                case "Over":
                    writer.println(manager.over(arguments));
                    return;
            }
        }

    }
}




