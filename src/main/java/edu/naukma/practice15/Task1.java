package edu.naukma.practice15;

public class Task1 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("VadimDudar1452", 5000);

        account.deposit(1000);
        account.withdraw(70000);
        System.out.println(account);
    }
}
