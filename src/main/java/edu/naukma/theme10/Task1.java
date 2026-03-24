package edu.naukma.theme10;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import java.util.function.Predicate;

public class Task1 {
    public static void main(String[] args) {
        Event e1 = new Event(
                "Lesson 1",
                Instant.now(),
                Duration.ofMinutes(60),
                ZoneId.of("Europe/Kyiv"),
                "Main"
        );

        Event e2 = new Event(
                "Java Basics",
                Instant.now(),
                Duration.ofMinutes(90),
                ZoneId.of("Europe/Kyiv"),
                "Java"
        );

        Event e3 = new Event(
                "Functional Interfaces",
                Instant.now(),
                Duration.ofMinutes(60),
                ZoneId.of("Europe/Kyiv"),
                "Java"
        );

        Event e4 = EventLab.create(() -> new Event(
                "Evening Workshop",
                Instant.now(),
                Duration.ofMinutes(120),
                ZoneId.of("Europe/Kyiv"),
                "Practice"
        ));

        List<Event> events = List.of(e1, e2, e3, e4);

        System.out.println("All events");
        EventLab.notifyAll(events, e ->
                System.out.println(e.label() + " | start: " + e.getStart() + " | end: " + e.end())
        );

        System.out.println("\nLabels");
        List<String> labels = EventLab.labels(events, Event::label);
        labels.forEach(System.out::println);

        System.out.println("\n < 12.00");
        Predicate<Event> morningOnly = e -> e.getStart().toLocalTime().isBefore(java.time.LocalTime.NOON);
        EventLab.pick(events, morningOnly).forEach(e -> System.out.println(e.label()));

        System.out.println("\nCombine");
        Predicate<Event> javaTrack = e -> e.getTrack().equalsIgnoreCase("Java");
        Predicate<Event> shortEvent = e -> e.getDurationInMinutes().toMinutes() <= 90;

        Predicate<Event> combined = morningOnly.and(javaTrack).and(shortEvent);

        EventLab.pick(events, combined).forEach(e -> System.out.println(e.label()));

        System.out.println("\nConflicts");
        List<String> conflicts = EventLab.findConflicts(events);
        if (conflicts.isEmpty()) {
            System.out.println("No conflicts");
        } else {
            conflicts.forEach(System.out::println);
        }
    }
}