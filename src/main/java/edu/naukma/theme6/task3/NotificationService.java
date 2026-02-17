package edu.naukma.theme6.task3;

import edu.naukma.theme6.task4.Email;
import edu.naukma.theme6.task4.Money;

public interface NotificationService {
    void sendReceipt(Email email, Money total);
}

class EmailNotificationService implements NotificationService {
    @Override
    public void sendReceipt(Email email, Money total) {
        System.out.println("Email sent to " + email + " for " + total);
    }
}
