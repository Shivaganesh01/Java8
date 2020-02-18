package com.example.java8;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.*;

public class Stream_forEach {
    public static void main(String[] args) {

        // **** Java forEach and Streams **** //
        ArrayList<Integer> integerArrayList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Consumer<Integer> action = System.out::println;
        integerArrayList.stream().filter(i -> i % 2 == 0).forEach(action);
        // most of the stream operations returns streams only. This help us creating chain of the stream operations. This is called as pipe-lining.
        List<Integer> integerList = integerArrayList.parallelStream().filter(i -> i < 5).map(item -> item * item).distinct().collect(Collectors.toList());
        System.out.println("Post Process : " + integerList);

        HashMap<String, Integer> map = new HashMap<String, Integer>() {
            {
                put("A", 1);
                put("B", 2);
                put("C", 3);
            }
        };
        System.out.println("Map Data");
        Consumer<Map.Entry<String, Integer>> mapAction = stringIntegerEntry -> {

            System.out.println("Key: " + stringIntegerEntry.getKey());
            System.out.println("Value: " + stringIntegerEntry.getValue());
        };
        //Streams are created on a source, e.g. a java.util.Collection like lists or sets (maps are not supported). Stream operations can either be executed sequential or parallel.
        map.entrySet().forEach(mapAction);

        //Create a stream
        Stream<Integer> integerStream = Stream.of(1, 2, 3); // Method 1
        integerStream = Stream.of(new Integer[]{1, 2, 3});  // Method 2
        integerStream = integerArrayList.stream();        // Method 3
        integerStream.forEach(i -> System.out.printf(i + " "));
        System.out.println();
        IntStream stream = "12345ABCDEFG_abcdefg".chars();// Method 4
        stream.forEach(p -> System.out.printf(p + " "));
        //Stream<Date> stream = Stream.generate(() -> { return new Date(); });
        //stream.forEach(p -> System.out.println(p));


        // **** Core Stream Operations **** //
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        // ------- Intermediate operations return the stream itself. filter(), map(), flatMap(), distinct(), sorted(), peek(), limit(), skip()
        // Stream.filter()
        System.out.println();
        memberNames.stream().filter(s -> s.startsWith("A")).forEach(s -> {
            System.out.printf(" " + s);
        });
        // Stream.map()
        System.out.println();
        memberNames.stream().map(String::toUpperCase).forEach(s -> {
            System.out.printf(" " + s);
        });
        // Stream.sorted()
        System.out.println();
        memberNames.stream().map(String::toLowerCase).sorted().forEach(s -> {
            System.out.printf(" " + s);
        });

        // ------ Terminal operations: Return a result of a certain type instead of again a Stream. It includes forEach(), forEachOrdered(), toArray()
        // reduce(), collect(), min(), max(), count(), anyMatch(), allMatch(), noneMatch(), findFirst(), findAny()
        // Stream.match()
        System.out.println();
        boolean matchedResult = memberNames.stream()
                .anyMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);
        matchedResult = memberNames.stream()
                .allMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);
        matchedResult = memberNames.stream()
                .noneMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);
        // Stream.count()
        System.out.println("No. of Elements in the stream: " + memberNames.stream().count());
        // Stream.reduce()
        Optional<String> reduced = memberNames.stream().reduce((s1, s2) -> s1 + " : " + s2);
        System.out.println("Reduced value: ");
        reduced.ifPresent(System.out::println);
        // Stream.min()
        System.out.println("Min: " + memberNames.stream().min((o1, o2) -> o1.compareTo(o2)).get());
        // Stream.max()
        System.out.println("Max: " + memberNames.stream().max((o1, o2) -> o1.compareTo(o2)).get());

        // Short Circuit Operations: Though, stream operations are performed on all elements inside a collection satisfying a predicate,
        // It is often desired to break the operation whenever a matching element is encountered during iteration.
        boolean matched = memberNames.stream().anyMatch(s -> s.startsWith("A"));
        String firstMatchedName = memberNames.stream().filter(s -> s.startsWith("A")).findFirst().get();

        // Boxed Stream
        IntStream intStream = IntStream.of(1, 2, 3);
        intStream.boxed().collect(Collectors.toList());
        LongStream.of(1L, 2l, 3l, 4l, 5l);
        DoubleStream.of(1d, 2D, 3D, 4D, 5D);


    }
}
