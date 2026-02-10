package edu.naukma.theme5;

public class Task1 {

    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        CardPayment cardPayment = new CardPayment();

        processor.processPayment(cardPayment, 200);
        cardPayment.payWithFee(400, 20);
    }

}
