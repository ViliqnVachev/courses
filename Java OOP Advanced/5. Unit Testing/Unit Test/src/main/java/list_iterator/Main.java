package list_iterator;

import javax.naming.OperationNotSupportedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, OperationNotSupportedException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ListIterator<String> temp = new ListIterator<>(null);
        String line = reader.readLine();
        ListIterator<String> listIterator = null;
        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create":

                    try {
                        listIterator = new ListIterator(Arrays.stream(tokens).skip(1).toArray());

                    } catch (OperationNotSupportedException op) {
                        ;
                    }
                    break;
                case "HasNext":
                    System.out.println(listIterator.hasNext());
                    break;
                case "Move":
                    System.out.println(listIterator.move());
                    break;
                case "Print":
                    try {
                        System.out.println(listIterator.print());

                    } catch (NullPointerException op) {
                        System.out.println(op.getMessage());
                    }
                    break;
            }

            line = reader.readLine();
        }
    }
}
