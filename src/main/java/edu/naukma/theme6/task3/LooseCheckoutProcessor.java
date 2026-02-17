package edu.naukma.theme6.task3;

import edu.naukma.theme6.task4.Email;
import edu.naukma.theme6.task4.Money;
import edu.naukma.theme6.task4.Order;

import java.util.Objects;

public class LooseCheckoutProcessor {
    private final PaymentGateway gateway;
    private final NotificationService notifier;

    public LooseCheckoutProcessor(PaymentGateway gateway, NotificationService notifier) {
        this.gateway = Objects.requireNonNull(gateway, "gateway");
        this.notifier = Objects.requireNonNull(notifier, "notifier");
    }

    public PaymentResult checkout(Order order, PaymentDetails details, Email email) {
        Money total = order.total();
        PaymentResult result = gateway.charge(total, details);
        if (result.isSuccess()) {
            notifier.sendReceipt(email, total);
        }
        return result;
    }
}
