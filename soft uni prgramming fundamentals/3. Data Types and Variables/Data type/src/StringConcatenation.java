import java.util.Scanner;

public class StringConcatenation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char delimiter = s.nextLine().charAt(0);
        String type = s.nextLine();
        byte n = Byte.parseByte(s.nextLine());
        String sum="";
        for (int i = 0; i < n; i++) {
            String input = s.nextLine();
            if (type.equals("odd") && i % 2 == 0){
                sum=sum+input+delimiter;
            }else if(type.equals("even") && i % 2 != 0){
                sum=sum+input+delimiter;
            }

        }

        System.out.println( sum.substring(0,sum.length()-1));
    }
}
