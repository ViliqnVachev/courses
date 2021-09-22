import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
        List<Integer> numbers= Arrays.stream(s.nextLine().split(" "))
                .map(Integer::parseInt)
                .filter(n -> n>0)
                .collect(Collectors.toList());


        if(numbers.size()<=0){
            System.out.println("empty");
        }

        Collections.reverse(numbers);
        for (int num:numbers) {
            System.out.print(num+" ");
        }
    }
}
