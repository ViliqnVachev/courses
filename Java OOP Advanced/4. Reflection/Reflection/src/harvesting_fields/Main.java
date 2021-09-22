package harvesting_fields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Field> allMethods = new ArrayList<>();

        Collections.addAll(allMethods, RichSoilLand.class.getDeclaredFields());

        String line = reader.readLine();

        while (!"HARVEST".equals(line)) {
            switch (line) {
                case "private":
                    for (Field field : allMethods) {
                        if (Modifier.isPrivate(field.getModifiers())) {
                            System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName());
                        }
                    }
                    break;

                case "protected":
                    for (Field field : allMethods) {
                        if (Modifier.isProtected(field.getModifiers())) {
                            System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName());
                        }
                    }
                    break;

                case "public":
                    for (Field field : allMethods) {
                        if (Modifier.isPublic(field.getModifiers())) {
                            System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName());
                        }
                    }
                    break;

                case "all":
                    for (Field field : allMethods) {
                        System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName());
                    }
                    break;
            }

            line = reader.readLine();
        }
    }
}
