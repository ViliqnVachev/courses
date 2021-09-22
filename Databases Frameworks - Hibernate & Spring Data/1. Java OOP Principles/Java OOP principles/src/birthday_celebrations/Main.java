package birthday_celebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Birthtable> litBirthDate = new ArrayList<>();


        String input = reader.readLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");

            if ("Citizen".equals(tokens[0])) {
                Birthtable human = new Human(tokens[1], tokens[3], tokens[4]);
                litBirthDate.add(human);
            } else if ("Pet".equals(tokens[0])) {
                Pet pet = new Pet(tokens[1], tokens[2]);
                litBirthDate.add(pet);
            }
            input = reader.readLine();
        }
        String year = reader.readLine();

        for (int i = 0; i < litBirthDate.size(); i++) {
            String[] birth = litBirthDate.get(i).getBirthdate().split("\\/");
            String years2 = birth[2];
            if (years2.equals(year)) {
                System.out.println(litBirthDate.get(i).getBirthdate());
            }
        }

    }
}
