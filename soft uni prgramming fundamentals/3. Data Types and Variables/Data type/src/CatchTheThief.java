import java.util.Scanner;

public class CatchTheThief {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String type = s.nextLine();
        int count = Integer.parseInt(s.nextLine());
        long temp = Long.MIN_VALUE;

        for (int i = 0; i < count; i++) {
            long number = Long.parseLong(s.nextLine());

            switch (type) {
                case "sbyte":
                    byte maxByte = Byte.MAX_VALUE;
                    byte minByte = Byte.MIN_VALUE;
                    if (number >= minByte && number > temp && number <= maxByte) {
                        temp = number;
                    }
                    break;
                case "int":
                    int maxInt = Integer.MAX_VALUE;
                    int minInt = Integer.MIN_VALUE;
                    if (number >= minInt && number > temp && number <= maxInt) {
                        temp = number;
                    }
                    break;
                case "long":
                    long maxLong = Long.MAX_VALUE;
                    long minLong = Long.MIN_VALUE;
                    if (number >= minLong && number > temp && number <= maxLong) {
                        temp = number;
                    }
                    break;
            }
        }

        System.out.println(temp);
    }
}

