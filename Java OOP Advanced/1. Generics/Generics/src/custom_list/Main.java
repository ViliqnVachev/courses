package custom_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        MyCustomList<String> myCustomList = new MyCustomList<>();


        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");
            commands(tokens, myCustomList);

            line = reader.readLine();
        }
    }

    private static void commands(String[] tokens, MyCustomList<String> myCustomList) {

        String command = tokens[0];

        switch (command) {
            case "Add":
                myCustomList.add(tokens[1]);
                break;
            case "Remove":
                myCustomList.remove(Integer.parseInt(tokens[1]));
                break;
            case "Contains":
                System.out.println(myCustomList.contains(tokens[1]));
                break;
            case "Swap":
                myCustomList.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                break;
            case "Greater":
                System.out.println(myCustomList.countGreaterThan(tokens[1]));
                break;
            case "Max":
                System.out.println(myCustomList.getMax());
                break;
            case "Min":
                System.out.println(myCustomList.getMin());
                break;
            case "Print":
                for (String s : myCustomList.getItems()) {
                    System.out.println(s);
                }
                break;

        }
    }
}
