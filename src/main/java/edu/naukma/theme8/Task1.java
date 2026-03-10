package edu.naukma.theme8;

import java.util.*;

public class Task1 {

    public static void main(String[] args) {
        List rawTypes = new ArrayList();

        rawTypes.add("Hello");
        rawTypes.add(10);

        for (Object el: rawTypes) {
            if (el instanceof String) System.out.println("Is string");
            else System.out.println("Not string");
        }

        List<String> stringList = new ArrayList<>();

        stringList.add("Hello");
        stringList.add("Bye");

        String s = stringList.get(1);
        System.out.println(s);
    }

}
