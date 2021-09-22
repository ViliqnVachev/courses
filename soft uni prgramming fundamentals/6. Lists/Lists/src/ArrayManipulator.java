import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> list = Arrays.stream(s.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String[] comands = s.nextLine().split(" ");


        while (!comands[0].equals("print")) {
            switch (comands[0]) {
                case "add":
                    int index = Integer.parseInt(comands[1]);
                    int element = Integer.parseInt(comands[2]);
                    list.add(index, element);
                    break;

                case "addMany":
                    int indexM = Integer.parseInt(comands[1]);
                    int count = 0;
                    for (int i = 2; i < comands.length; i++) {
                        list.add(indexM + count, Integer.parseInt(comands[i]));
                        count++;
                    }
                    break;
                case "contains":
                    int searchElement = Integer.parseInt(comands[1]);
                    boolean isFound = true;
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).equals(searchElement)) {
                            System.out.println(i);
                            isFound = true;
                            break;
                        }
                        isFound = false;
                    }
                    if (!isFound) {
                        System.out.println("-1");
                    }
                    break;
                case "remove":
                    int removeIndex = Integer.parseInt(comands[1]);
                    list.remove(removeIndex);
                    break;
                case "shift":
                    int n = Integer.parseInt(comands[1]);
                    n = n % list.size();
                    List<Integer> helper = list.subList(n, list.size());
                    for (int i = 0; i < n; i++) {
                        helper.add(list.get(i));
                    }
                    list = helper;
                    break;
                case "sumPairs":
                    int lenght = list.size();
                    for (int i = 0; i < lenght / 2; i++) {
                        list.set(i, list.get(i) + list.get(i + 1));
                        list.remove(i + 1);
                    }
                    break;
                default:
                    break;
            }
            comands = s.nextLine().split(" ");
        }


        if (comands[0].equals("print")) {
            System.out.print("[");
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.print(list.get(i) + ", ");
            }
            System.out.println(list.get(list.size() - 1) + "]");
        }

    }
}
