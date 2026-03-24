package edu.naukma.theme10;

import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class DateTimeLab {

    public static Instant toInstant(Event e) {
        return e.getStart().atZone(e.getZone()).toInstant();
    }

    public static long minutesBetween(Event a, Event b) {
        return Duration.between(toInstant(a), toInstant(b)).toMinutes();
    }

    public static ZonedDateTime startInZone(Event e, String zone) {
        return toInstant(e).atZone(ZoneId.of(zone));
    }
}