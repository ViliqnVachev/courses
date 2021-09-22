import java.util.Scanner;

public class Lutenitsa {
    public static void main(String[] args) {

        int emp=0;

        int a= 7895;
        int b= a%10;
        emp=a/10;
        int c = emp%10;
        emp=emp/10;
        int d= emp%10;
        emp=emp/10;
        int e = emp;

        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

     /*   Scanner s = new Scanner(System.in);
        double tomatoesKg=Double.parseDouble(s.nextLine());
        int cases=Integer.parseInt(s.nextLine());
        int jars=Integer.parseInt(s.nextLine());

        double lutenitsa=tomatoesKg/5;
        double fullJars=lutenitsa/0.535;
        double fullCases=fullJars/jars;

        System.out.printf("Total lutenica: %d kilograms.%n",(int)Math.floor(lutenitsa));

        if(cases<fullCases){
            double left=fullCases-cases;
            double jarsLeft=fullJars-(cases*jars);
            System.out.println((int)Math.floor(left)+" boxes left.");
            System.out.println((int)Math.floor(jarsLeft)+" jars left.");
        }else{
            double left=cases-fullCases;
            double jarsLeft=(cases*jars)-fullJars;
            System.out.println((int)Math.floor(left)+" more boxes needed.");
            System.out.println((int)Math.floor(jarsLeft)+" more jars needed.");
        }

*/

    }
}
