package edu.naukma.practice15;

public class BankAccount {

    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;

        if (initialBalance < 0) throw new IllegalArgumentException("Balance must be greater than zero!");
        else this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount can't be negative!");
        else balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount can't be negative!");
        else if (amount > balance) throw new IllegalArgumentException("Amount can't be greater than balance!");
        else balance -= amount;
    }

    @Override
    public String toString() {
        return "BankAccount -> " + accountNumber +
                " balance: " + balance;
    }
}
