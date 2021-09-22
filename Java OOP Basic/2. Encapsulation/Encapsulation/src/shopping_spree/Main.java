package shopping_spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] persons = reader.readLine().split(";");
        Map<String, Person> personMap = new LinkedHashMap<>();
        Map<String, Product> productMap = new LinkedHashMap<>();

        for (int i = 0; i < persons.length; i++) {
            String name = persons[i].split("=")[0];
            Double money = Double.parseDouble(persons[i].split("=")[1]);
            Person person = null;
            try {
                person = new Person(name, money);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
            personMap.putIfAbsent(name, person);
        }

        String[] products = reader.readLine().split(";");
        for (int i = 0; i < products.length; i++) {
            String name = products[i].split("=")[0];
            Double cost = Double.parseDouble(products[i].split("=")[1]);
            Product product = null;
            try {
                product = new Product(name, cost);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
            productMap.putIfAbsent(name, product);
        }
        String line = reader.readLine();
        while (!"END".equals(line)) {
            String[] tokens = line.split(" ");
            String name = tokens[0];
            String nameProduct = tokens[1];

            Person person = personMap.get(name);
            Product product = productMap.get(nameProduct);
            try {
                person.addProduct(product);
                System.out.println(name + " bought " + nameProduct);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            line = reader.readLine();
        }
        personMap.forEach((key, value) -> System.out.println(value));
    }
}
