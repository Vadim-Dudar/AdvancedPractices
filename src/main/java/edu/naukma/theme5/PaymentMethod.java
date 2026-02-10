package edu.naukma.theme5;

public interface PaymentMethod {
    String name();
    boolean pay(int amount);

    default void payWithFee(int amount, int fee) {
        System.out.println("Payment done | Total sum -> " + (amount + fee));
    }
}
