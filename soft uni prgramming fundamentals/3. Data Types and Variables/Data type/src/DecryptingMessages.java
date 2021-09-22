import java.util.Scanner;

public class DecryptingMessages {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        byte key =Byte.parseByte(s.nextLine());
        byte n =Byte.parseByte(s.nextLine());
        String result="";

        for (int i = 0; i < n; i++) {

            char symbol=s.next().charAt(0);
            int resul=(int)symbol+key;
            char symbol2=(char)resul;
            result+=symbol2;
        }
        System.out.println(result);
    }
}
