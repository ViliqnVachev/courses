package birthday_celebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Birthtable> people = new ArrayList<>();

        String line = reader.readLine();
        while (!"End".equals(line)) {
            String[] tokens = line.split("\\s+");
            String type = tokens[0];
            switch (type) {
                case "Citizen":
                    String name = tokens[1];
                    String age = tokens[2];
                    String id = tokens[3];
                    String birthDay = tokens[4];
                    Birthtable citizen = new Citizen(name, age, id, birthDay);
                    people.add(citizen);

                    break;
                case "Pet":
                    name = tokens[1];
                    birthDay = tokens[2];
                    Birthtable pet = new Pet(name, birthDay);
                    people.add(pet);
                    break;
            }
            line = reader.readLine();
        }

        String year = reader.readLine();
        people.stream().filter(e->e.getBirthday().endsWith(year)).forEach(e-> System.out.println(e.getBirthday()));
    }
}
