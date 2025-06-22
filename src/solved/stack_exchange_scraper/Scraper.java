package stack_exchange_scraper;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.*;


public class Scraper {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);
        File testDatei = new File("src/stack_exchange_scraper/TestDatei0.txt");
        BufferedReader reader = new BufferedReader(new FileReader(testDatei));

        Pattern idPattern = Pattern.compile("<a href=\"/questions/[0-9]+/");
        Pattern extractIdPattern = Pattern.compile("/[0-9]+/");
        Pattern descriptionPattern = Pattern.compile("class=\"question-hyperlink\">.+</a>");
        Pattern questionAgePattern = Pattern.compile("(>[0-9]+ hours? ago</span>)|(>yesterday</span>)");

        Matcher mOne;
        Matcher matcherForIdExtracton;

        String line;
        String id = "";
        String description = "";
        String questionAge = "";

        while((line = reader.readLine()) != null){
//            line = reader.readLine();
//            line = scanner.nextLine();
            mOne = idPattern.matcher(line);

            if(mOne.find()){

                matcherForIdExtracton = extractIdPattern.matcher(line);
                matcherForIdExtracton.find();

                id = matcherForIdExtracton.group().substring(1, matcherForIdExtracton.group().length() - 1);

                mOne = descriptionPattern.matcher(line);
                if(mOne.find()){
                    description = mOne.group().substring(27, mOne.group().length() - 4);
                }
            }

            mOne = questionAgePattern.matcher(line);

            if(mOne.find()){
                questionAge = mOne.group().substring(1, mOne.group().length() - 1);
                System.out.printf("%s;%s;%s\n", id, description, questionAge);
                questionAge = "";
                id = "";
                description = "";
            }

        }
        scanner.close();
    }
}
