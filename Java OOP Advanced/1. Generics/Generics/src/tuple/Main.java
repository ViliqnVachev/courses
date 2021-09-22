package tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstTokens = reader.readLine().split("\\s+");
        StringBuilder sb = new StringBuilder(firstTokens[0]).append(" ").append(firstTokens[1]);
        Tuple<String, String> firstTuple = new Tuple<>(sb.toString(), firstTokens[2]);
        System.out.println(firstTuple);

        String[] secondTokens = reader.readLine().split("\\s+");
        Tuple<String, Integer> secondTuple = new Tuple<>(secondTokens[0], Integer.parseInt(secondTokens[1]));
        System.out.println(secondTuple);

        String[] thirdTokens = reader.readLine().split("\\s+");
       Tuple<Integer,Double> thirdTuple = new Tuple<>(Integer.parseInt(thirdTokens[0]), Double.parseDouble(thirdTokens[1]));
        System.out.println(thirdTuple);
    }
}
