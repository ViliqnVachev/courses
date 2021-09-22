package cresla;

import cresla.entities.containers.ManagerImpl;
import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;
import cresla.io.ConsoleInputReader;
import cresla.io.ConsoleOutputWriter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        Manager programManager = new ManagerImpl();

        while (true) {
            String line = reader.readLine();
            String[] splitted = line.split("\\s+");
            if (splitted[0].equals("Exit")) {
                System.out.println(programManager.exitCommand(null));
                break;
            }
            switch (splitted[0]) {
                case "Reactor":
                    System.out.println(programManager.reactorCommand(Arrays.asList(splitted)));
                    break;
                case "Module":
                    System.out.println(programManager.moduleCommand(Arrays.asList(splitted)));
                    break;
                case "Report":
                    System.out.println(programManager.reportCommand(Arrays.asList(splitted)));
                    break;

            }
        }
    }
}
