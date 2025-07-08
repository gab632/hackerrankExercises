package lambda_exercises;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // 1. sum of two integers.
        Addition lambdaAddition = (x, y) -> x + y;
        int z = lambdaAddition.sum(6,5);
        System.out.println("Sum 6 + 5 = " + z);

        // 2. Check if a string is empty using lambda.
        Predicate<String> isEmptyString =  str -> str.isEmpty();
        String str1 = "";
        String str2 = "test string number 2";

        System.out.println(isEmptyString.test(str1));
        System.out.println(isEmptyString.test(str2));

        AddThenMultiplyByConstantFactor lambdaAddMultiply = (x, y) -> (x + y) * 5;
        int result = lambdaAddMultiply.addThenMultiply(3,4);
        System.out.println("Add then multiply: " + result);
        Addition lambdaAdditionThenMultiplication = (x,y) -> (x + y) * 8;
        System.out.println("Add then multiply using Addition interface: " + lambdaAdditionThenMultiplication.sum(3, 4));

        // Write a Java program to create a lambda expression that sums two integers read from a file and returns the result.
        Path path = Path.of("C:\\Users\\gabri\\learn to code\\Java\\exercises\\hackerrank\\exercisesWithIntelliJ\\exercises\\src\\test_input_numbers");
        int a = 0;
        int b = 0;
        try {
            String[] values = Files.readString(path).split(" ");

            a = Integer.parseInt(values[0].trim());
            b = Integer.parseInt(values[1].trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Read from file: " + lambdaAddition.sum(a, b));

        BiFunction<Integer, Integer, Integer> sumInt = (x, y) -> x + y;
        // Write a Java program to chain two lambda expressions:
        // one for summing two integers and another for formatting the output.
        Function<Integer, String> printResult = x -> "Result using lambda chaining: ".concat(String.valueOf(x));
        BiFunction<Integer, Integer, String> chained = sumInt.andThen(printResult);
        System.out.println(chained.apply(a, b));

        // Write a Java program to implement a lambda expression
        // that adds two integers and then subtracts a third value using function composition.
        BiFunction<Integer, Integer, Integer> subtractInt = (x, y) -> x - y;
        BiFunction<Integer, Integer, Integer> sumInts = (x, y) -> x + y;





    }
}
