package border_control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Population> people = new ArrayList<>();

        String line = reader.readLine();
        while (!"End".equals(line)) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            switch (tokens.length) {
                case 2:
                    String id = tokens[1];
                    Population citizen = new Robot(name, id);
                    people.add(citizen);
                    break;
                case 3:
                    id = tokens[2];
                    citizen = new Human(name, id);
                    people.add(citizen);
                    break;
            }
            line = reader.readLine();
        }

        String lastDigit = reader.readLine();
        for (Population person : people) {
            if (person.getFakeId(lastDigit)) {
                System.out.println(person.getId());
            }
        }
    }
}
