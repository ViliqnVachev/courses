import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class RoundingNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
            double [] arr = Arrays.stream(s.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
        DecimalFormat df = new DecimalFormat("0.#########");

        for (double currentNumber:arr  ) {
            int result = (int)rountNUber(currentNumber);
            System.out.printf("%s => %d\n",df.format(currentNumber),result);
        }


    }



    static double rountNUber(double n){
        double result= Math.abs(n)+0.5;
        double resultTrun=Math.floor(result);
        if(n<0){
            resultTrun=resultTrun*-1;
            return resultTrun;
        }
            return resultTrun;
        }
    }

