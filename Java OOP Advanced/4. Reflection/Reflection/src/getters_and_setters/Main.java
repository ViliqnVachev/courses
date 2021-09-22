package getters_and_setters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Method> getters = new TreeSet<>((Comparator.comparing(Method::getName)));
        Set<Method> setters = new TreeSet<>((Comparator.comparing(Method::getName)));

        Method[] methods = Reflection.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().startsWith("get") && !method.getReturnType().equals(void.class) && method.getParameterTypes().length == 0) {
                getters.add(method);
            } else if (method.getName().startsWith("set") && method.getReturnType().equals(void.class) && method.getParameterTypes().length == 1) {
                setters.add(method);
            }
        }

        for (Method getter : getters) {
            System.out.println(getter.getName() + " will return " + getter.getReturnType().getSimpleName());
        }

        for (Method setter : setters) {
            System.out.println(setter.getName() + " and will set field of " + setter.getParameterTypes()[0].getSimpleName());
        }
    }
}
