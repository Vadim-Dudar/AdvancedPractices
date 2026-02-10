package edu.naukma.theme5;

public class PaymentProcessor {

    void processPayment(PaymentMethod method, int amount) {
        System.out.println("Processing payment with " + method.name());
        boolean success = method.pay(amount);
        if (success) {
            System.out.println("Payment successful");
        } else {
            System.out.println("Payment failed");
        }
    }

}
