package edu.naukma.theme11;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task1 {

    // task 4 definitions
    sealed interface Result permits Success, Failure {}
    record Success(String value) implements Result {}
    record Failure(String message) implements Result {}

    public static void main(String[] args) {

        record Book(String title, String author, int year, List<String> tags) {
        }

        List<Book> books = List.of(
                new Book("Clean Code", "Robert Martin", 2008, List.of("clean", "practice", "java")),
                new Book("Effective Java", "Joshua Bloch", 2018, List.of("java", "best", "api")),
                new Book("Modern Java", "Nicolai Parlog", 2020, List.of("java", "streams", "records")),
                new Book("Java Concurrency", "Brian Goetz", 2006, List.of("concurrency", "java"))
        );

        // task 1
        List<String> after2015 = books.stream()
                .filter(b -> b.year() > 2015)
                .map(b -> b.title().toUpperCase())
                .sorted()
                .toList();

        // task 2
        List<String> uniqueSortedTags = books.stream()
                .flatMap(b -> b.tags().stream())
                .distinct()
                .sorted()
                .toList();

        System.out.println("Unique sorted tags: " + uniqueSortedTags);

        Map<String, Long> tagFrequency = books.stream()
                .flatMap(b -> b.tags().stream())
                .collect(Collectors.groupingBy(tag -> tag, Collectors.counting()));

        System.out.println("Tag frequency: " + tagFrequency);

        int topN = 2;
        List<Map.Entry<String, Long>> topTags = tagFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(topN)
                .toList();

        System.out.println("Top " + topN + " tags: " + topTags);

        // task 3
        record Sale(String customerEmail, String product, int cents) {}

        List<Sale> sales = List.of(
                new Sale("a@ex.com", "Tea", 120),
                new Sale("b@ex.com", "Cake", 200),
                new Sale("a@ex.com", "Tea", 120),
                new Sale("c@ex.com", "Coffee", 150),
                new Sale("b@ex.com", "Cake", 200)
        );

        // task 3
        Map<String, Integer> productRevenue = sales.stream()
                .collect(Collectors.toMap(
                        Sale::product,
                        Sale::cents,
                        Integer::sum
                ));

        System.out.println("Product revenue: " + productRevenue);

        Map<String, Long> transactionsCount = sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::customerEmail,
                        Collectors.counting()
                ));

        System.out.println("Transactions count by customer: " + transactionsCount);

        //task 4
        List<Result> results = List.of(
                new Success("Data loaded"),
                new Failure("Connection timeout"),
                new Success("User created"),
                new Failure("Invalid input"),
                new Success("Message sent")
        );

        long successCount = results.stream().filter(r -> r instanceof Success).count();
        long failureCount = results.stream().filter(r -> r instanceof Failure).count();

        System.out.println("Success count: " + successCount);
        System.out.println("Failure count: " + failureCount);

        List<String> failureMessages = results.stream()
                .filter(r -> r instanceof Failure)
                .map(r -> ((Failure) r).message())
                .toList();

        System.out.println("Failure messages: " + failureMessages);

        // task 5
        Map<Boolean, List<Book>> recentVsOld = books.stream()
                .collect(Collectors.partitioningBy(b -> b.year() > 2015));

        System.out.println("Recent vs Old books. true: " + recentVsOld.get(true));
        System.out.println("false: " + recentVsOld.get(false));

        Map<String, Integer> sortedProductRevenue = sales.stream()
                .collect(Collectors.toMap(
                        Sale::product,
                        Sale::cents,
                        Integer::sum,
                        java.util.TreeMap::new
                ));

        System.out.println("Sorted product revenue: " + sortedProductRevenue);

    }
}
