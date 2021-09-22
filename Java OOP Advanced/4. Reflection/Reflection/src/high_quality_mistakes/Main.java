package high_quality_mistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<Field> fields = new TreeSet<>(Comparator.comparing(Field::getName));
        Set<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));

        fields.addAll(Arrays.stream(Reflection.class.getDeclaredFields()).filter(p -> !Modifier.isPrivate(p.getModifiers())).collect(Collectors.toList()));

        getters.addAll(Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(m -> !Modifier.isPublic(m.getModifiers()) && !m.getReturnType().equals(void.class) && m.getName().startsWith("get") && m.getParameterTypes().length == 0)
                .collect(Collectors.toList()));

        setters.addAll(Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(m -> !Modifier.isPrivate(m.getModifiers()) && m.getReturnType().equals(void.class) && m.getName().startsWith("set") && m.getParameterTypes().length == 1)
                .collect(Collectors.toList()));

        for (Field field : fields) {
            System.out.println(field.getName()+" must be private!");
        }

        for (Method getter : getters) {
            System.out.println(getter.getName()+"have to be public!");
        }

        for (Method setter : setters) {
            System.out.println(setter.getName()+"have to be private!");
        }
    }
}
