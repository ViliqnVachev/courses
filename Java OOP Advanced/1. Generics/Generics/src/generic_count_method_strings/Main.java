package generic_count_method_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Box<String>> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            Box<String> box = new Box<>(line);
            boxes.add(box);
        }

        String comp = reader.readLine();
        Box<String> box = new Box<>(comp);
        int count = Box.getBiggerElementCount(boxes, box);
        System.out.println(count);


    }
}
