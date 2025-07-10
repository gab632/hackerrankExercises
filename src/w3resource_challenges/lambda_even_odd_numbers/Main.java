package w3resource_challenges.lambda_even_odd_numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int n = (int) (Math.random() * 20);
            integers.add(n);
        }

        System.out.println("""
                Write a Java program to implement a lambda expression 
                to filter out even and odd numbers from a list of integers.
                """);

        Function<List<Integer>, List<List<Integer>>> filteredOut = ints ->
                List.of(
                        ints.stream()
                                .filter(n -> n % 2 == 0)
                                .toList(),
                        ints.stream()
                                .filter(n -> n % 2 != 0)
                                .toList()
                );
        System.out.println("Filtered out (even / odd):");
        filteredOut.apply(integers).forEach(System.out::println);

        System.out.println("""
                Write a Java program to implement a lambda expression 
                that filters even numbers and then squares each result.
                """);
        System.out.println("Squared even numbers:");
        integers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .forEach(n -> System.out.println(n));
        System.out.println("""
                Write a Java program to create a lambda that partitions a list of integers into even and odd sublists and prints both.
                """);

        System.out.println("""
                Write a Java program to implement a lambda that filters out odd numbers 
                and calculates the sum of the remaining evens.
                """);
        int sumOfRemainingElements = integers.stream().filter(n -> n % 2 == 0).reduce(0, Integer::sum);
        System.out.println("Initial list: " + integers);
        System.out.println("Sum: " + sumOfRemainingElements);

        System.out.println("""
                Write a Java program to compose lambda expressions 
                that first filter even numbers and then remove duplicates from the result.
                """);

        List<Integer> testList = List.of(3, 2, 2, 5, 2, 6, 7, 4, 6, 12, 45, 45, 0, 12, 42);
        List<Integer> filtered = testList.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .sorted()
                .toList();
        System.out.println("Initial list with duplicates: " + testList);
        System.out.println("With only even numbers and without duplicactes: " + filtered);


    } // main
}
