package com.example.java8;

import com.example.java8.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestEmployeePredicate {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<Employee>(Arrays.asList(
                new Employee(1, 23, "M", "Rick", "Beethovan"),
                new Employee(2, 13, "F", "Martina", "Hengis"),
                new Employee(3, 43, "M", "Ricky", "Martin"),
                new Employee(4, 26, "M", "Jon", "Lowman"),
                new Employee(5, 19, "F", "Cristine", "Maria"),
                new Employee(6, 15, "M", "David", "Feezor"),
                new Employee(7, 68, "F", "Nelissa", "Roy"),
                new Employee(8, 79, "M", "Alex", "Gussin"),
                new Employee(9, 15, "F", "Neetu", "Singh"),
                new Employee(10, 45, "M", "Naveen", "Jain")
        ));

        System.out.println(isAdultFemale().test(new Employee(7, 68, "F", "Nelissa", "Roy")));

        System.out.println(filterEmployees(employees, firstNameStartsWith("N")));

        System.out.println(filterEmployees(employees, isMale()));

        System.out.println(filterEmployees(employees, isAdultFemale()));

        System.out.println(filterEmployees(employees, isAdultFemale().negate()));

        System.out.println(filterEmployees(employees, isAdultFemale().and(firstNameStartsWith("N"))));

    }

    public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate){
        return employees.stream().filter(predicate).collect(Collectors.toList());
    }

    public static Predicate<Employee> firstNameStartsWith(String string){
        return employee -> employee.getFirstName().startsWith(string);
    }

    public static Predicate<Employee> isMale(){
        return employee -> employee.getGender().equals("M");
    }

    public static Predicate<Employee> isAdultFemale(){
        return employee -> employee.getGender().equals("F") && employee.getAge() >= 18;
    }
}
