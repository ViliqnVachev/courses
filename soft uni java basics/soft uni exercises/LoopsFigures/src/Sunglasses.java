import java.util.Scanner;

public class Sunglasses {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

        int hight= n;
        int widrh=5*n;
        int monocle=2*n;
        int middleGap=n;

        int rowGap=-1;
        if(rowGap%2==0){
            rowGap=(n/2)-1;
        }else{
            rowGap=n/2;
        }
        for (int row = 0; row <hight ; row++) {
            // left
            System.out.print("*");
            if(row==0 ||row==hight-1){
                System.out.print(repeatStr("*",monocle-2));
            }else{
                System.out.print(repeatStr("/",monocle-2));
            }
            System.out.print("*");

            //middle
            if(row==((n-1)/2)){
                System.out.print(repeatStr("|",middleGap));
            }else{
                System.out.print(repeatStr(" ",middleGap));
            }

            //right
            System.out.print("*");
            if(row==0 ||row==hight-1){
                System.out.print(repeatStr("*",monocle-2));
            }else{
                System.out.print(repeatStr("/",monocle-2));
            }
            System.out.print("*");
            System.out.println();
        }

    }
    public static String repeatStr(String tex,int count){
        StringBuilder sb =new StringBuilder ();
        for (int i = 0; i < count; i++) {
            sb.append(tex);
        }
        return sb.toString();
    }
}
