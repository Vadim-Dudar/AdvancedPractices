package edu.naukma.theme6.task3;

import edu.naukma.theme6.task4.Email;
import edu.naukma.theme6.task4.Money;
import edu.naukma.theme6.task4.Order;

public class TightCheckoutProcessor {
    private final StripePaymentGateway gateway = new StripePaymentGateway();
    private final EmailNotificationService notifier = new EmailNotificationService();

    public PaymentResult checkout(Order order, PaymentDetails details, Email email) {
        Money total = order.total();
        PaymentResult result = gateway.charge(total, details);
        if (result.isSuccess()) {
            notifier.sendReceipt(email, total);
        }
        return result;
    }
}
