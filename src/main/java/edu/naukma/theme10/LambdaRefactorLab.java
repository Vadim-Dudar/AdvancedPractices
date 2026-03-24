package edu.naukma.theme10;

import java.util.Comparator;
import java.util.List;

public class LambdaRefactorLab {

    public static void sortAnonymous(List<Event> events) {
        events.sort(new Comparator<Event>() {
            @Override
            public int compare(Event a, Event b) {
                return a.getStart().compareTo(b.getStart());
            }
        });
    }

    public static void sortLambda(List<Event> events) {
        events.sort((a, b) -> a.getStart().compareTo(b.getStart()));
    }

    public static void sortMethodRef(List<Event> events) {
        events.sort(Comparator.comparing(Event::getStart));
    }
}