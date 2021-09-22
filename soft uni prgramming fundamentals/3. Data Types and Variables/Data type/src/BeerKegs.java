import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        byte n = Byte.parseByte(s.nextLine());
        double sum=0;
        String bigestKeg="";
        double temp=0;

        for (int i = 0; i < n; i++) {
            String name = s.nextLine();
            double r = Double.parseDouble(s.nextLine());
            double height = Double.parseDouble(s.nextLine());
            sum=Math.PI*r*r*height;
            if(sum>temp){
                temp=sum;
                bigestKeg=name;
            }
        }
        System.out.println(bigestKeg);
    }
}
