package edu.naukma.theme13;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Account {
    private final int id;
    private float balance;
}

class TransferService {

    static void transfer(Account from, Account to, float amount) {
        Account first = from;
        Account second = to;

        if (from.getId() > to.getId()) {
            first = to;
            second = from;
        }

        synchronized (first) {
            synchronized (second) {
                if (from.getBalance() >= amount) {
                    from.setBalance(from.getBalance() - amount);
                    to.setBalance(to.getBalance() + amount);
                }
            }
        }
    }
}

public class Task3 {

    public static void main(String[] args) throws InterruptedException {
        Account a = new Account(1, 100f);
        Account b = new Account(2, 100f);

        Thread t1 = new Thread(() -> TransferService.transfer(a, b, 60f));
        Thread t2 = new Thread(() -> TransferService.transfer(b, a, 40f));

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("A balance = " + a.getBalance());
        System.out.println("B balance = " + b.getBalance());
    }

}
