package edu.naukma.theme13;

import java.util.ArrayList;
import java.util.List;

record Order(long id, int totalCents) {
}

class TaskRunner {
    static void runAndWait(List<Runnable> runnables) throws InterruptedException {
        if (runnables == null) {
            throw new IllegalArgumentException("runnables must not be null");
        }

        List<Thread> threads = new ArrayList<>(runnables.size());
        for (Runnable runnable : runnables) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}

public class Task1 {

    public static void main(String[] args) throws InterruptedException {
        List<Order> orders = List.of(new Order(1, 1000), new Order(2, 2000));

        Runnable r1 = () -> {
            System.out.println("Total sum: " + orders.stream().mapToInt(Order::totalCents).sum());
        };

        Runnable r2 = () -> {
            System.out.println("Max sum: " + orders.stream().mapToInt(Order::totalCents).max().orElseThrow());
        };

        List<Runnable> runnables = List.of(r1, r2);

        TaskRunner.runAndWait(runnables);
    }
}
