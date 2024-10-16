package io.matheusvictor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> items = new ArrayList<String>();

        items.add("A");
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("C");

        for (String item : items) {
            if (item.startsWith("A")) System.out.println(item.toLowerCase());
        }

        items.stream()
                .filter(item -> item.startsWith("A")) // intermediates
                .map(String::toUpperCase) // intermediates
                .forEach(System.out::println); // finally

        // finally operation: forEach, collect, reduce

        Set<String> modifiedItems = items.stream()
                .filter(item -> item.startsWith("A")) // intermediates
                .map(String::toUpperCase)
                .collect(Collectors.toSet());

        System.out.println(modifiedItems);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        Integer reduce = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(reduce);

        items.parallelStream()
                .forEach(item -> System.out.println(Thread.currentThread() + " - " + item));
    }
}