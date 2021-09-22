package telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = reader.readLine().split("\\s+");
        String[] URL = reader.readLine().split("\\s+");
        Smartphone smartphone = new Smartphone();

        for (int i = 0; i < numbers.length; i++) {
            try {
                System.out.println(smartphone.calling(numbers[i]));

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        for (int i = 0; i < URL.length; i++) {

            try {
                System.out.println(smartphone.browsing(URL[i]));

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
