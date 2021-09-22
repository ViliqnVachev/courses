package listyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = reader.readLine().split("\\s+");
        ListyIterator<String> list = null;

        System.out.println();
        while (!"END".equals(line[0])) {

            switch (line[0]) {

                case "Create":
                    list = new ListyIterator<String>(Arrays.stream(line).skip(1).toArray(String[]::new));
                    break;

                case "Move":
                    System.out.println(list.move());
                    break;

                case "HasNext":
                    System.out.println(list.hasNext());
                    break;

                case "Print":
                    try {
                        list.print();
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;


            }

            line = reader.readLine().split("\\s+", 2);
        }
    }
}
