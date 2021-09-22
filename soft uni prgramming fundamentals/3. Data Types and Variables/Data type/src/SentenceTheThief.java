import java.util.Scanner;

public class SentenceTheThief {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String type = s.nextLine();
        int count = Integer.parseInt(s.nextLine());
        long temp = Long.MIN_VALUE;
        long years=0;
        byte maxByte = Byte.MAX_VALUE;
        byte minByte = Byte.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            long number = Long.parseLong(s.nextLine());

            switch (type) {
                case "sbyte":

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

        if(temp<0){
            years=(long)Math.ceil(1.0*temp/minByte);
        }else{
            years=(long)Math.ceil(1.0*temp/maxByte);
        }

        if(years>1){

            System.out.printf("Prisoner with id %d is sentenced to %d years",temp,years);
        }else {
            System.out.printf("Prisoner with id %d is sentenced to %d year",temp,years);
        }
    }
}

