import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int [] nums = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        while (nums.length>1){
            int []sum = new int[nums.length-1];
            for (int i = 0; i < nums.length-1; i++) {
            sum[i] = nums[i] + nums[i + 1];

        }
        nums=sum;

        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        }
    }

