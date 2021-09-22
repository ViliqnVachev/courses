package threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstTokens = reader.readLine().split("\\s+");
        StringBuilder sb = new StringBuilder(firstTokens[0]).append(" ").append(firstTokens[1]);
        Threeuple<String, String, String> firstTuple = new Threeuple<>(sb.toString(), firstTokens[2], firstTokens[3]);
        System.out.println(firstTuple);

        String[] secondTokens = reader.readLine().split("\\s+");
        boolean isDrunk = secondTokens[2].equals("drunk");
        Threeuple<String, Integer, Boolean> secondTuple = new Threeuple<>(secondTokens[0], Integer.parseInt(secondTokens[1]), isDrunk);
        System.out.println(secondTuple);

        String[] thirdTokens = reader.readLine().split("\\s+");
        Threeuple<String, Double, String> thirdTuple = new Threeuple<>(thirdTokens[0], Double.parseDouble(thirdTokens[1]), thirdTokens[2]);
        System.out.println(thirdTuple);
    }
}
