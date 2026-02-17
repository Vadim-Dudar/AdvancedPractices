package edu.naukma.theme6.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private final List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem item) {
        items.add(Objects.requireNonNull(item, "item"));
    }

    public Money total() {
        Money sum = Money.zero();
        for (OrderItem item : items) {
            sum = sum.add(item.total());
        }
        return sum;
    }
}

