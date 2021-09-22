package stack_iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        CustomStack<Integer> stack = new CustomStack<>();

        while (true) {
            String[] tokens = line.split("\\s+", 2);

            switch (tokens[0]) {
                case "Push":
                    for (String token : tokens[1].split(",\\s+")) {

                        stack.push(Integer.valueOf(token.trim()));
                    }

                    break;

                case "Pop":
                    try {
                        stack.pop();
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "END":
                    for (int i = 0; i < 2; i++) {
                        for (Integer integer : stack) {
                            System.out.println(integer);
                        }
                    }
                    return;

            }


            line = reader.readLine();
        }


    }
}
