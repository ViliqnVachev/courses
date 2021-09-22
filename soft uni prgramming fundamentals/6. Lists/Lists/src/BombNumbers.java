import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> list = Arrays.stream(s.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] specialNumber = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bombNumber = specialNumber[0];
        int power = specialNumber[1];
        int sum = 0;

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(bombNumber)) {

                        for (int j = Math.max(i - power, 0); j <= Math.min(i + power, list.size() - 1); j++){
                            int temp=0;
                            list.set(j,0);
                        }

                }
            }



            for (int num : list) {
                sum += num;
            }
            System.out.println(sum);
        }
    }
