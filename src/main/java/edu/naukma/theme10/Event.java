package edu.naukma.theme10;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.*;

@AllArgsConstructor
@Getter
public class Event {
    private final String title;
    private final Instant start;
    private final Duration durationInMinutes;
    private final ZoneId zone;
    private final String track;

    public String label() {
        return title + " " + track;
    }

    public LocalDateTime end() {
        return LocalDateTime.ofInstant(start.plus(durationInMinutes), zone);
    }

    public LocalDateTime getStart() {
        return LocalDateTime.ofInstant(start, zone);
    }
}
