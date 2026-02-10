package edu.naukma.theme5;

public interface SmsNotifier {

    default void send() {
        System.out.println("SMS sent!");
    }

}
