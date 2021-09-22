package food_shortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Buyer> buyerMap = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];

            switch (tokens.length) {
                case 3:
                    String age = tokens[1];
                    String group = tokens[2];
                    Buyer rebel = new Rebel(name, age, group);
                    buyerMap.putIfAbsent(name, rebel);
                    break;
                case 4:
                    age = tokens[1];
                    String id = tokens[2];
                    String birthday = tokens[3];
                    Buyer citizen = new Citizen(name, age, id, birthday);
                    buyerMap.putIfAbsent(name, citizen);
                    break;
            }
        }

        String line = reader.readLine();
        while (!"End".equals(line)) {
            if (buyerMap.containsKey(line)) {
                buyerMap.get(line).buyFood();
            }
            line = reader.readLine();
        }

        int sum = buyerMap.entrySet().stream().mapToInt(e -> e.getValue().getFood()).sum();
        System.out.println(sum);

    }
}
