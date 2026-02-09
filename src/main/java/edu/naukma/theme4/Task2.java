package edu.naukma.theme4;

class A {
    void f() {
        System.out.println("A");
    }

    void process(Object o) {
        System.out.println("A:process object");
    }
}

class B extends A {
    @Override
    void f() {
        System.out.println("B");
    }

    @Override
    void process(Object o) {
        System.out.println("B:Override object");
    }

    void process(String s) {
        System.out.println("B:Ovearload String");
    }
}

public class Task2 {
    public static void main(String[] args) {
        A a = new B();
        a.process("hi");
    }
}
