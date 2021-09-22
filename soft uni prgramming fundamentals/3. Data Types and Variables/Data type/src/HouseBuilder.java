import java.util.Scanner;

public class HouseBuilder {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String first= s.nextLine();
        String second= s.nextLine();
        long sumInt=0;
        long sumByte=0;
        long sum=0;
        try{
            int n =Integer.parseInt(first);
            byte n2=Byte.parseByte(second);
            sumInt=(long)10*n;
            sumByte=4*n2;
            sum=sumInt+sumByte;
            System.out.println(sum);
        }catch(Exception ex){
            int n =Integer.parseInt(second);
            byte n2=Byte.parseByte(first);
            sumInt=(long)10*n;
            sumByte=4*n2;
            sum=sumInt+sumByte;
            System.out.println(sum);

        }

    }
}
