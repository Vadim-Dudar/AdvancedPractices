package edu.naukma.theme9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(2, "2024-06-01T10:00:00"));
        tickets.add(new Ticket(1, "2024-06-01T09:00:00"));
        tickets.add(new Ticket(3, "2024-06-01T11:00:00"));

        tickets.sort(new Comparator<Ticket>() {
            @Override
            public int compare(Ticket t1, Ticket t2) {
                return Integer.compare(t1.getPriority(), t2.getPriority());
            }
        });

        tickets.sort((t1, t2) -> Integer.compare(t1.getPriority(), t2.getPriority()));

        tickets.sort(Comparator.comparing(Ticket::getPriority));
    }
}
