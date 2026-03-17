package edu.naukma.theme9;

import java.util.Comparator;

public final class TicketComparator {

    private TicketComparator() {
    }

    public static final Comparator<Ticket> BY_PRIORITY = Comparator.comparing(Ticket::getPriority);

    public static final Comparator<Ticket> BY_CREATED_AT = Comparator.comparing(Ticket::getCratedAt);

    public static final Comparator<Ticket> BY_PRIORITY_THEN_CREATED = BY_PRIORITY.thenComparing(BY_CREATED_AT);

    public static Comparator<Ticket> strategy(String strategy) {
        switch (strategy) {
            case "priority":
                return BY_PRIORITY;
            case "createdAt":
                return BY_CREATED_AT;
            case "priorityThenCreated":
                return BY_PRIORITY_THEN_CREATED;
            default:
                throw new IllegalArgumentException("Unknown strategy: " + strategy);
        }
    }
}