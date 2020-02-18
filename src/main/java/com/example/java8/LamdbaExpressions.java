package com.example.java8;

public class LamdbaExpressions {
    /**
    Features of Lambda Expressions

    1. A lambda expression can have zero, one or more parameters.
    2. The type of the parameters can be explicitly declared or it can be inferred from the context.
    3. Multiple parameters are enclosed in mandatory parentheses and separated by commas. Empty parentheses are used to represent an empty set of parameters.
    4. When there is a single parameter, if its type is inferred, it is not mandatory to use parentheses. e.g. a -> return a*a.
    5. The body of the lambda expressions can contain zero, one or more statements.
    6. If body of lambda expression has single statement curly brackets are not mandatory and the return type of the anonymous function is the same as that of the body expression.
            When there is more than one statement in body, then these must be enclosed in curly brackets.

     (int a, int b) ->    a * b               // takes two integers and returns their multiplication
     (a, b)          ->   a - b               // takes two numbers and returns their difference
     () -> 99                                // takes no values and returns 99
     (String a) -> System.out.println(a)     // takes a string, prints its value to the console, and returns nothing
     a -> 2 * a                               // takes a number and returns the result of doubling it
     c -> { //some complex statements }   // takes a collection and do some processing
     */

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Function");
            }
        }).start();

        new Thread(
                () ->   {
                    System.out.println("Lambda Expression");
                }
        ).start();

        RunIt runIt = new RunIt(){
            @Override
            public void run() {
                System.out.println("Running a Custom Functional Interface");
            }
        };
        runIt.run();
        runIt.myRun1();
        RunIt.myRun2();
    }

}

// Single Abstract Method interfaces (SAM Interfaces) interfaces with single abstract method. From Java 8, also called as functional interfaces
@FunctionalInterface
interface RunIt {
    public abstract void run();
    // You can have any no. of default Methods
    default void myRun1(){
        System.out.println("default Method Invocation in an Interface");
    }
    // You can have any no. of static Methods
    static void myRun2(){
        System.out.println("static Method Invocation in an Interface");
    }
}
