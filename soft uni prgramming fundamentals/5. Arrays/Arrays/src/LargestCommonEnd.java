import java.util.Scanner;

public class LargestCommonEnd {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] first = s.nextLine().split(" ");
        String[] second = s.nextLine().split(" ");

        int countLeft = 0;
        int countRight = 0;

        for (int i = 0; i < Math.min(first.length, second.length); i++) {
            if (first[i].equals(second[i])) {
                countLeft++;
            } else {
                break;
            }
        }

        for (int i = 0; i < Math.min(first.length, second.length); i++) {
            if (first[first.length - 1 - i].equals(second[second.length - 1 - i])) {
                countRight++;
            } else {
                break;
            }
        }

        System.out.println(Math.max(countRight, countLeft));
    }

}

