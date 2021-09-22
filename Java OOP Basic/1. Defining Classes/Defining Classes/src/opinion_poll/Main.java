package opinion_poll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> persons = new ArrayList<>();

        int numbers = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numbers; i++) {
            String[] line = reader.readLine().split(" ");
            String name = line[0];
            int age = Integer.parseInt(line[1]);

            Person person = new Person(name, age);
            persons.add(person);
        }

        persons.stream().filter(p->p.getAge()>30).sorted((p1,p2)->p1.getName().compareTo(p2.getName()))
                .forEach(p-> System.out.println(p.getName()+" - "+p.getAge()));
    }
}
