package black_box_integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, IOException, NoSuchFieldException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Class aClass = BlackBoxInt.class;

        Constructor boxConstructor = aClass.getDeclaredConstructor();
        boxConstructor.setAccessible(true);
        BlackBoxInt blackBox = (BlackBoxInt) boxConstructor.newInstance();
        boxConstructor.setAccessible(false);

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String[] tokens = line.split("_");

            String command = tokens[0];
            int parameter = Integer.parseInt(tokens[1]);
            Method method = blackBox.getClass().getDeclaredMethod(command, int.class);
            method.setAccessible(true);
            method.invoke(blackBox, parameter);
            method.setAccessible(false);

            Field innerValue = blackBox.getClass().getDeclaredField("innerValue");
            innerValue.setAccessible(true);
            System.out.println(innerValue.get(blackBox));

            line = reader.readLine();
        }
    }
}
