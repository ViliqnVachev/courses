package jar_of_T;

public class Main {
    public static void main(String[] args) {
        Jar<String> jarOfString = new Jar<>();

        jarOfString.add("Hello");
        jarOfString.add("my");

        System.out.println(jarOfString.remove());
        System.out.println(jarOfString.remove());
        System.out.println(jarOfString.remove());
    }
}
