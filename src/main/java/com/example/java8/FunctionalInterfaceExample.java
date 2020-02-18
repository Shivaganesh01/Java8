package com.example.java8;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        RunIt runIt = new RunIt() {
            @Override
            public void runMe() {
                System.out.println("Running a Custom Functional Interface");
            }
        };
        RunIt lambdaWayInitialization = () -> {
            System.out.println("Running a Custom Functional Interface using lambda");
        };
        runIt.runMe();
        lambdaWayInitialization.runMe();
        runIt.myRun1();
        RunIt.myRun2();
    }
}

/*
 * Functional interfaces are new additions in java 8 which permit exactly one abstract method inside them.
 * These interfaces are also called Single Abstract Method interfaces (SAM Interfaces).
 *
 * In Java 8, functional interfaces can be represented using lambda expressions, method reference and constructor references as well.
 * Java 8 introduces an annotation i.e. @FunctionalInterface too, which can be used for compiler level errors when the interface
 * you have annotated violates the contracts of exactly one abstract method.
 *
 * If an interface declares an abstract method overriding one of the public methods of java.lang.Object,
 * that also does not count toward the interface’s abstract method count since any implementation of the interface will have an implementation from java.lang.Object or elsewhere.
 * Eg. Comparator is a functional interface even though it declared two abstract methods.
 * Why? Because one of these abstract methods “equals()” which has signature equal to public method in Object class.
 */
@FunctionalInterface
        // Without this annotation too it is a Functional Interface
interface RunIt {
    public abstract void runMe();

    /* You can have any no. of default methods
     * Why default methods: To enable the functionality of lambda expression in java. Lambda expression are essentially of type of functional interface.
     * To support lambda expressions seamlessly, all core classes have to be modified.
     * But these core classes like java.util.List are implemented not only in JDK classes, but also in thousands of client code as well.
     * Any incompatible change in core classes will back fire for sure and will not be accepted at all.
     * Default methods break this deadlock and allow adding support for functional interface in core classes
     *
     * In java, a class can implement N number of interface. Additionally, a interface can also extend another interface as well.
     * An if any default method is declared in two such interfaces which are implemented by single class. then obviously class will get confused which method to call.
     *
     * Rules for this conflict resolution are as follows:
     * 1) Most preferred are the overridden methods in classes. They will be matched and called if found before matching anything.
     * 2) The method with the same signature in the “most specific default-providing interface” is selected. This means if class Animal implements two interfaces i.e. Moveable and Walkable such that Walkable extends Moveable. Then Walkable is here most specific interface and default method will be chosen from here if method signature is matched.
     * 3) If Moveable and Walkable are independent interfaces then a serious conflict condition happen, and compiler will complain then it is unable to decide. The you have to help compiler by providing extra info that from which interface the default method should be called. e.g.
     *
     * Walkable.super.move();
     * or
     * Moveable.super.move();
     */
    default void myRun1() {
        System.out.println("default Method Invocation in an Interface");
    }

    // You can have any no. of static methods
    static void myRun2() {
        System.out.println("static Method Invocation in an Interface");
    }

    // Overridden from Object class
    @Override
    public boolean equals(Object obj);
}
