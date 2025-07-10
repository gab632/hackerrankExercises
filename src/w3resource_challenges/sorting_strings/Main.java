package w3resource_challenges.sorting_strings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        String path = "C:\\Users\\gabri\\learn to code\\Java\\exercises\\hackerrank\\exercisesWithIntelliJ\\exercises\\src\\w3resource_challenges\\sorting_strings\\test_strings.txt";
        try {
            input = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Write a Java program to implement a lambda expression " +
                "to sort a list of strings in alphabetical order.\n" +
                "\n");
        System.out.println("Sorted:");
        input.stream()
                .map(s -> s.toLowerCase())
                .sorted()
                .forEach(s -> System.out.println(s));


        input.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        input.forEach(s -> System.out.println(s));


        System.out.println("""
                
                ++++++++++++++++++++++++++++++++++++++++++++++++++++
                
                Write a Java program to implement a lambda expression 
                that sorts a list of strings in reverse alphabetical order.
                """);
        System.out.println("Sorted in reverse order:");
        input.sort((s1, s2) -> (s1.compareToIgnoreCase(s2) * -1));
        input.forEach(s -> System.out.println(s));
        System.out.println();
        input.stream()
                .map(s -> s.toLowerCase())
                .sorted(Collections.reverseOrder())
                .forEach(System.out::println);
    }

}
