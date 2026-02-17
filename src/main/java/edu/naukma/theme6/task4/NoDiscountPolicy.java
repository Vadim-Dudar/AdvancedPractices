package edu.naukma.theme6.task4;

public class NoDiscountPolicy implements DiscountPolicy {
    @Override
    public Money apply(Money basePrice) {
        return basePrice;
    }
}
