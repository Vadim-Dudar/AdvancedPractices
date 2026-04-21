package edu.naukma.theme15;

import java.lang.annotation.Target;
import java.util.Arrays;

public class ClassInfoPrinter {
    public static void print(Class<?> clazz) {
        System.out.println("Class name: " + clazz.getName());
        System.out.println("Super class name: " + clazz.getSuperclass().getName());
        System.out.println("Is interface: " + clazz.isInterface());
        System.out.println("Declared field: " + Arrays.toString(clazz.getDeclaredFields()));
        System.out.println("Declared methods: " + Arrays.toString(clazz.getDeclaredMethods()));
    }
}
