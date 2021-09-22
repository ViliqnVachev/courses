import java.util.*;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> list = Arrays.stream(s.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println((int)Math.ceil(1.0*8/2));
        int position=0;
        int n =list.size();
        for (int i = 0; i < n/2; i++) {
            list.set(i,list.get(i)+list.get(i+1));
            list.remove(i+1);



        }


    }
}
