import java.util.*;

import java.util.Arrays;

import java.util.stream.Collectors;


public class SumReversedNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
        long sum = 0;
        List<String> reverseNums = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            String num = numbers.get(i);
            char[] arrayChar = num.toCharArray();
            char[] reverseChar = new char[arrayChar.length];
            for (int a = 0; a < arrayChar.length; a++) {
                reverseChar[a] = arrayChar[arrayChar.length - 1 - a];
            }
            sum += Long.parseLong(String.valueOf(reverseChar));
        }
        System.out.println(sum);
    }

}