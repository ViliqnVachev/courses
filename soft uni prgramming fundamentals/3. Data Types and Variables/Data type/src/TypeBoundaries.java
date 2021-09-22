

import java.util.Scanner;




public class TypeBoundaries {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();



        switch (input){
            case "int":
                System.out.println(Integer.MAX_VALUE);
                System.out.println(Integer.MIN_VALUE);
                break;
            case "long":
                System.out.println(Long.MAX_VALUE);
                System.out.println(Long.MIN_VALUE);
                break;
            case "sbyte":
                System.out.println(Byte.MAX_VALUE);
                System.out.println(Byte.MIN_VALUE);
                break;

            case "byte":
                System.out.println("255");
                System.out.println("0");
                break;
                case "uint":
                    System.out.println("4294967295");
                    System.out.println("0");
                    break;
        }
    }
}
