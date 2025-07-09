package lambda_empty_string;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        // Write a Java program to implement a lambda expression
        // that checks if a trimmed string is empty or contains only whitespace.
        Predicate<String> isEmptyOrBlank = str -> (str.isEmpty() || str.matches("\\s*"));
        System.out.println(isEmptyOrBlank.test("      "));
        System.out.println(isEmptyOrBlank.test("  .  "));
        System.out.println(isEmptyOrBlank.test(""));

        // Write a Java program to create a lambda that validates a list of strings,
        // returning true only if all are empty.
        Predicate<String> isEmpty = str -> str.isEmpty();

        System.out.println("""
                \nWrite a Java program to create a lambda that validates a list of strings,\s
                returning true only if all are empty.
                """);
        Predicate<List<String>> allEmpty = list -> list.stream().allMatch(isEmpty);
        List<String> testListOne = List.of("", "", ".");
        List<String> testListTwo = List.of("", "", "");
        List<String> testListThree = List.of("", "", "", "", "");
        List<List<String>> lists = List.of(testListOne, testListTwo, testListThree);
        for(List<String> l : lists){
            System.out.println(allEmpty.test(l));
        }

        System.out.println("""
                Write a Java program to implement a lambda expression
                that checks if a string is empty and, if so, returns a default message.
                """);
        
        PrintIfEmpty lambdaTest = isEmptyString -> {
            if(isEmptyString){
                return "Default Message";
            }
            return "";
        };

        String  testCase1 = " 1 ";
        String result = lambdaTest.printDefaultMessage(isEmpty.test(testCase1));
        System.out.println("Should not print the default message: " + result);
        String testCase2 = "";
        String result2 = lambdaTest.printDefaultMessage(isEmpty.test(testCase2));
        System.out.println("Should print the default message: " + result2);

        System.out.println("""
                Write a Java program to compose a lambda that verifies a string’s emptiness and logs an error if it is.
                """);
        LogError testLogError = isEmptyString -> {
            if(isEmptyString){
                System.err.println("Error. String is empty.");
            }
        };

        System.out.println("Should print an error message to stout:");
        testLogError.errorIfEmpty(isEmpty.test(""));

        System.out.println("Should print no message to stout:");
        testLogError.errorIfEmpty(isEmpty.test(" b "));
    }
}
