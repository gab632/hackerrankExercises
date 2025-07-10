package w3resource_challenges.lambda_string_uppercase;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
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
        List<String> testList = List.of("tESt 1", "TESt 2", "TesT 3", "tesT 4");
//        Function<List<String>, List<List<String>>> toListsFunction =
        Function<String, String> stringToUpperCase = s -> s.toUpperCase();
        Function<String, String> stringToLowerCase = s -> s.toLowerCase();
        Function<List<String>, List<String>> listToUpperCase = stringList
                -> stringList
                .stream()
                .map(stringToUpperCase)
                .toList();
        Function<List<String>, List<String>> listToLowerCase = stringList
                -> stringList.stream()
                .map(String::toLowerCase)
                .toList();
        System.out.println(listToLowerCase.apply(testList));
        System.out.println(listToUpperCase.apply(testList));

        Function<List<String>, Map<String, List<String>>> listBothUppercaseAndLowercase = (stringList) -> {

            List<String> uppr = listToUpperCase.apply(stringList);
            List<String> lwr = listToLowerCase.apply(stringList);

            Map<String, List<String>> listMap = new HashMap<>();
            listMap.put("UPPERCASE", uppr);
            listMap.put("LOWERACSE", lwr);
            return listMap;
        };

        Function<List<String>, List<List<String>>> nestedListsBothUppercaseAndLowercase = (stringList) -> List.of(listToUpperCase.apply(stringList), listToLowerCase.apply(stringList));

        Function<List<String>, List<List<String>>> nestedListsSimplified = (stringList) ->
                List.of(
                        stringList
                            .stream()
                            .map(s -> s.toUpperCase())
                            .toList(),
                        stringList
                                .stream()
                                .map(s -> s.toLowerCase())
                                .toList()
                );
        System.out.println("\nUsing stream() map() toList(): 👇");
        nestedListsSimplified.apply(testList).forEach(System.out::println);

        System.out.println("""
                Write a Java program to implement a lambda 
                that maps a list of mixed-case strings 
                to a list of alternating uppercase and lowercase letters.
                """);
        System.out.println("Alternating: 👇");
        List<String> alternating = testList.stream()
                .map( s -> {
                    return ((testList.indexOf(s) % 2 == 0) ? s.toLowerCase() : s.toUpperCase());
                        }
                ).toList();
        alternating.forEach(System.out::println);

        System.out.println("""
                Write a Java program to chain lambda expressions 
                to convert a list of strings first to uppercase 
                and then sort them alphabetically.
                """);
        List<String> uppercaseThenSorted = strings.stream()
                .map(s -> s.toUpperCase())
                .sorted()
                .toList();
        System.out.println("Uppercase, then sorted alphabetically👇");
        uppercaseThenSorted.forEach(s -> System.out.println('\t' + s));
    }

}
