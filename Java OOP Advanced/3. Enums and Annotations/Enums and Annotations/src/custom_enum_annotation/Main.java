package custom_enum_annotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class<?> rankClass = Class.forName("custom_enum_annotation.Card" + reader.readLine());

        CustomAnnotation annotation = rankClass.getAnnotation(CustomAnnotation.class);

        System.out.printf("Type = %s, Description = %s", annotation.type(), annotation.description());

    }
}

