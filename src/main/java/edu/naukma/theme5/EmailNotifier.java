package edu.naukma.theme5;

public interface EmailNotifier {

    default void send() {
        System.out.println("EMAIL send");
    }

}
