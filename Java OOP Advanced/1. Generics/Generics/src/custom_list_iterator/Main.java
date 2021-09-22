package custom_list_iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MyCustomList<String> list = new MyCustomList<>();

        for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    String element = tokens[1];
                    list.add(element);
                    break;

                case "Remove":
                    int index = Integer.parseInt(tokens[1]);
                    list.remove(index);
                    break;

                case "Contains":
                    element = tokens[1];
                    System.out.println(list.contains(element));
                    break;

                case "Swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    list.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    element = tokens[1];
                    System.out.println(list.countGreaterThan(element));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;

                case "Min":
                    System.out.println(list.getMin());
                    break;

                case "Print":
                    for (String s : list) {
                        System.out.println(s);
                    }
                    break;

                case "Sort":
                    list.sort();
                    break;

            }

        }
    }
}
