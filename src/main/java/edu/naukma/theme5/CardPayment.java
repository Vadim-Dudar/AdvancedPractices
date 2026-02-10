package edu.naukma.theme5;

public class CardPayment implements PaymentMethod{

    @Override
    public String name() {
        return "Card";
    }

    @Override
    public boolean pay(int amount) {
        System.out.println("Paying " + amount + " with card");
        return true;
    }

}
