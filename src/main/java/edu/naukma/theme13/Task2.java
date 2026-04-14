package edu.naukma.theme13;

import java.util.concurrent.locks.ReentrantLock;

interface Inventory {
    void reserve(int amount);
    int available();
}

class UnsafeInventory implements Inventory {
    private int a;

    UnsafeInventory(int a) {
        this.a = a;
    }

    @Override
    public void reserve(int amount) {
        if (a >= amount) {
            Thread.yield();
            a -= amount;
        }
    }

    @Override
    public int available() {
        return a;
    }
}

class SynchronizedInventory implements Inventory {
    ReentrantLock lock = new ReentrantLock();

    private int a;

    SynchronizedInventory(int a) {
        this.a = a;
    }

    @Override
    public void reserve(int amount) {
        lock.lock();
        try {
            if (a >= amount)
                a -= amount;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int available() {
        lock.lock();
        try {
            return a;
        } finally {
            lock.unlock();
        }
    }
}

public class Task2 {
    static int run(Inventory i) {
        try {
            Thread t1 = new Thread(() -> i.reserve(60));
            Thread t2 = new Thread(() -> i.reserve(60));
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            return i.available();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("unsafe=" + run(new UnsafeInventory(100)));
        System.out.println("safe=" + run(new SynchronizedInventory(100)));
        int bad = 0;
        for (int i = 0; i < 3000; i++) {
            if (run(new UnsafeInventory(100)) < 0) bad++;
        }
        System.out.println("violations=" + bad);
    }
}
