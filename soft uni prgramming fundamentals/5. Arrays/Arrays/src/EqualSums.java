import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arrNumbers = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (arrNumbers.length == 1)
        {
            System.out.println("0");
            return;
        }

        int leftSum = 0;
        int rightSum = 0;
        boolean isSatisfiedRequirment = false;

        for (int i = 0; i < arrNumbers.length; i++)
        {
            for (int leftCnt = 0; leftCnt < i; leftCnt++)
            {
                leftSum += arrNumbers[leftCnt];
            }

            for (int rightCnt = i + 1; rightCnt < arrNumbers.length; rightCnt++)
            {
                rightSum += arrNumbers[rightCnt];
            }

            if (leftSum == rightSum)
            {
                System.out.println(i);
                isSatisfiedRequirment = true;
            }
            else
            {
                leftSum = rightSum = 0;
            }
        }

        if (!isSatisfiedRequirment)
        {
            System.out.println("no");
        }
    }
}

