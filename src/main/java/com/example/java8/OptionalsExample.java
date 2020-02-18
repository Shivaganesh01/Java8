package com.example.java8;

import java.util.Optional;

public class OptionalsExample {
    public static void main(String[] args) {

        // Creating Optional Object
        Optional<Integer> optionalInteger = Optional.empty();
        System.out.println(optionalInteger);

        optionalInteger.isPresent(); // To check either contains a value or doesn't
        optionalInteger = Optional.of(1);
        System.out.println(optionalInteger.get()); // Get Integer value

        optionalInteger = Optional.ofNullable(null);
        // System.out.println(optionalInteger.get()); // Exception: java.util.NoSuchElementException: No value present
        optionalInteger = Optional.ofNullable(1);

        optionalInteger.ifPresent(System.out::println);
        if(optionalInteger.isPresent()){
            System.out.println(optionalInteger.get());
        }

        // Default/absent values and actions
        System.out.println(optionalInteger.orElse(2));
        optionalInteger = Optional.empty();
        //optionalInteger.orElseThrow(IllegalArgumentException::new);

        // Rejecting certain values using the filter method
        Optional<String> stringOptional = Optional.of("Shivaganesh");
        stringOptional.filter(string -> "Shivaganesh".equals(string))
                .ifPresent(s -> {System.out.println(s+ " Present");});

    }
}
