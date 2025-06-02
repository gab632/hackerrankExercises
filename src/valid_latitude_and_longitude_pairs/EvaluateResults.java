package valid_latitude_and_longitude_pairs;

import java.io.*;

public class EvaluateResults {

    public static void main(String[] args) throws IOException {
//        String testLine = "(-47.153089, -91.153089)";
//        String test2 = "(-16, -158)";
//        System.out.println(ValidPairs.patternChecker(testLine));
//        System.out.println(ValidPairs.patternChecker(test2));


        File inputFile = new File("src/valid_latitude_and_longitude_pairs/testInputValidPairs.txt");
        File expected = new File("src/valid_latitude_and_longitude_pairs/ExpectedOutput.txt");
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedReader readerForExpectedOutput = new BufferedReader(new FileReader(expected));

        String line;
        String expectedResult;
        line = reader.readLine();
        System.out.printf("%15s - %15s - %s\n", "My result", "Expected Result", "input values");

        while((line = reader.readLine()) != null){
//            System.out.print(ValidPairs.patternChecker(line) + " - ");
//            System.out.print(readerForExpectedOutput.readLine() + " - ");
//            System.out.println(line);

            System.out.printf("%15s - %15s - %s\n", ValidPairs.patternChecker(line), readerForExpectedOutput.readLine(), line);
        }


    }
}
