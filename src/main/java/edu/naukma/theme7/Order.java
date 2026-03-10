package edu.naukma.theme7;

import java.util.Objects;

public record Order (int id, String userEmail, int totalCents) {
    public Order {
        if (id < 0) {
            throw new IllegalArgumentException("id must be non-negative");
        }
        if (userEmail == null || userEmail.isEmpty()) {
            throw new IllegalArgumentException("userEmail must be non-empty");
        }
        if (totalCents < 0) {
            throw new IllegalArgumentException("totalCents must be non-negative");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Order order = (Order) obj;
        return totalCents == order.totalCents && userEmail == order.userEmail;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userEmail, totalCents);
    }
}
