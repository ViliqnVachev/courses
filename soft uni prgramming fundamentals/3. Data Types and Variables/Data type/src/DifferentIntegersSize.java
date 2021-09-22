import java.util.Scanner;

public class DifferentIntegersSize {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        String number = s.nextLine();
        String message = "";
        boolean canFit= false;
        try {
            byte n = Byte.parseByte(number);
            message +="* sbyte\n";
            canFit = true;
        }catch (Exception ex){

        }
        try {
            short n = Short.parseShort(number);
            message +="* byte\n* short\n";
            canFit = true;
        }catch (Exception ex){}

        try {
            int n = Integer.parseInt(number);
            message +="* ushort\n* int\n";
            canFit = true;
        }catch (Exception ex){}
        try {
            long n = Long.parseLong(number);
            message +="* uint \n* long\n";
            canFit = true;
        }catch (Exception ex){}

        if(canFit){
            System.out.printf("%s can fit in:\n",number);
            System.out.println(message);

        }else{
            System.out.printf("%s can't fit in any type",number);
        }
    }
}
