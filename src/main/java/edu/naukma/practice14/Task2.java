package edu.naukma.practice14;

public class Task2 {
    public static void main(String[] args) {
        String s1 = new String("hello");
        String s2 = new String("hello");

        System.out.println("By == " + s1==s2);
        System.out.println("By equals() " + s1.equals(s2));

        for (int i = -128; i <= 128; i++) {
            Integer a = i;
            Integer b = i;

            System.out.println(a==b);
        }

        /* від -128 до 127 об'єкти кешуються,
        тому a == b повертає true.
        для значення 128 кешування немає,
        і створюються різні об'єкти,
        тому a == b повертає false.*/


    }
}
