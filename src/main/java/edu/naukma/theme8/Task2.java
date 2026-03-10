package edu.naukma.theme8;

import java.util.*;

public class Task2 {

    private static  <T> T firstOrNull(List<T> list) {
        if (list == null || list.isEmpty()) return null;
        return list.get(0);
    }

    private static double sum(List<? extends Number> list) {
        double sum = 0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public static void addDefaultIds(List<? super Integer> list) {
        list.add(100);
        list.add(200);
        list.add(300);
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Hi", "Hello", "Bye");
        System.out.println("firts of null = "+ firstOrNull(strings));

        List<Integer> ints = Arrays.asList(1, 2, 3, 4);
        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.0);

        System.out.println("sum(ints) = " + sum(ints));
        System.out.println("sum(doubles) = " + sum(doubles));
    }

}
