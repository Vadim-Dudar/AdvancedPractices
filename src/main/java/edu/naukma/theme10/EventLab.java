package edu.naukma.theme10;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.*;
import java.util.ArrayList;

public class EventLab {

    public static List<Event> pick(List<Event> events, Predicate<Event> predicate) {
        List<Event> result = new ArrayList<>();
        for (Event event : events) {
            if (predicate.test(event)) {
                result.add(event);
            }
        }
        return result;
    }

    public static List<String> labels(List<Event> events, Function<Event, String> mapper) {
        List<String> result = new ArrayList<>();
        for (Event event : events) {
            result.add(mapper.apply(event));
        }
        return result;
    }

    public static void notifyAll(List<Event> events, Consumer<Event> consumer) {
        for (Event event : events) {
            consumer.accept(event);
        }
    }

    public static Event create(Supplier<Event> supplier) {
        return supplier.get();
    }

    public static List<String> findConflicts(List<Event> events) {
        List<String> conflicts = new ArrayList<>();

        for (int i = 0; i < events.size(); i++) {
            for (int j = i + 1; j < events.size(); j++) {
                Event a = events.get(i);
                Event b = events.get(j);

                LocalDateTime aStart = a.getStart();
                LocalDateTime aEnd = a.end();
                LocalDateTime bStart = b.getStart();
                LocalDateTime bEnd = b.end();

                boolean overlaps = aStart.isBefore(bEnd) && bStart.isBefore(aEnd);

                if (overlaps) {
                    conflicts.add(a.label() + " <-> " + b.label());
                }
            }
        }

        return conflicts;
    }
}
