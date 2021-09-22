package generic_swap_method_integers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Box<Integer>> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int line = Integer.parseInt(reader.readLine());
            Box<Integer> box = new Box<>(line);
            boxes.add(box);
        }
        int[] indexes = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Box<Integer>> swapBox = Box.swap(indexes[0], indexes[1], boxes);

        swapBox.forEach(System.out::println);
    }
}
