package edu.naukma.theme6.task4;

import java.util.Objects;

class OrderItem {
    private final String sku;
    private final Money price;
    private final int quantity;

    public OrderItem(String sku, Money price, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be > 0");
        }
        this.sku = Objects.requireNonNull(sku, "sku");
        this.price = Objects.requireNonNull(price, "price");
        this.quantity = quantity;
    }

    public Money total() {
        return price.multiply(quantity);
    }
}
