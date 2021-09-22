package mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] infoStudent = reader.readLine().split("\\s+");
        String[] infoWorker = reader.readLine().split("\\s+");
        try {
            Human student = new Student(infoStudent[0], infoStudent[1], infoStudent[2]);
            Human worker = new Worker(infoWorker[0], infoWorker[1], Double.parseDouble(infoWorker[2]), Integer.parseInt(infoWorker[3]));

            System.out.println(student.toString());
            System.out.println(worker.toString());

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }


    }
}
