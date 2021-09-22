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

        String input = reader.readLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            if (tokens.length == 2) {
                Population robot = new Human(tokens[0], tokens[1]);
                people.add(robot);
            } else {
                Population human = new Human(tokens[0], tokens[2]);
                people.add(human);
            }
            input = reader.readLine();
        }
        String fakeId=reader.readLine();

        for (int i = 0; i < people.size(); i++) {
            if(people.get(i).getFakeId(fakeId)){
                System.out.println(people.get(i).getId());
            }
        }

    }
}
