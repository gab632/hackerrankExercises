package lambda_string_uppercase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Function<String, String> toUp = str -> str.toUpperCase();
        System.out.println("""
                Write a Java program to implement a lambda expression to convert a list of strings to uppercase and lowercase.
                """);
        ArrayList<String> strings = new ArrayList<>(List.of("one", "Two ", "THREE", "lower CASE"));

        System.out.println("To lower case using lambda exp: ");
        strings.replaceAll(str -> str.toLowerCase());
        strings.forEach(System.out::println);

        System.out.println("\nTo uppercase using lambda expr:");
        for(String s : strings){
            System.out.println(toUp.apply(s));
        }

        System.out.println("""
                Write a Java program to implement a lambda expression that converts a list of strings to title case.
        
                """);

        Function<String, String> toTitleCase = str -> str.substring(0,1).toUpperCase().concat(str.substring(1).toLowerCase());
        System.out.println("To title case: ");
        strings.replaceAll(s -> toTitleCase.apply(s));
        strings.forEach(System.out::println);

        System.out.println("""
                Write a Java program to create a lambda that simultaneously returns two lists: 
                one with uppercase and one with lowercase versions.
                
                """);
//        Function<List<String>, List<List<String>>> toListsFunction =








    }
}
