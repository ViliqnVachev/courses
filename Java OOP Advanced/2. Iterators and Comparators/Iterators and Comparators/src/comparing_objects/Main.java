package comparing_objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();
        String line;

        while (!"END".equals(line = reader.readLine())) {
            String[] token = line.split("\\s+");

            Person person = new Person(token[0], Integer.parseInt(token[1]), token[2]);
            people.add(person);
        }

        int index = Integer.parseInt(reader.readLine());

        if(index<0||index>people.size()-1){
            System.out.println("No matches");
            return;
        }
        Person tempPerson = people.get(index);

        long count = people.stream().filter(person -> person.compareTo(tempPerson) == 0).count();

        if (count == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(String.format("%d %d %d", count, people.size() - count, people.size()));
        }

    }
}
