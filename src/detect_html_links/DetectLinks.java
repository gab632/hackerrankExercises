package detect_html_links;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class DetectLinks {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        scanner.nextLine();
        File file = new File("src/detect_html_links/testCases01DetectLinks.txt");
        File testCases05 = new File("src/detect_html_links/testCases-05-DetectLinks.txt");

        File expectedResults05 = new File("src/detect_html_links/expectedOutput-05-DetectLinks.txt");

        BufferedReader reader = new BufferedReader(new FileReader(testCases05));
        BufferedReader resultsReader = new BufferedReader(new FileReader(expectedResults05));

        Pattern linkPattern = Pattern.compile("<a href=\"[\\S]+\"");
        Pattern endingTagPattern = Pattern.compile(">.*</.*>");
        // Pattern contentPattern = Pattern.compile(">.+</a>");

        Matcher linkMatcher;
        Matcher endTagMatcher;

        String line = "";
        String expectedLine = "";

        while((line = reader.readLine()) != null) {
//            line = reader.readLine();
            String link = "";
            String content = "";

            /*
            <li style="-moz-float-edge: content-box">... that
            <a href="/wiki/Orval_Overall" title="Orval Overall">Orval Overall</a>
            <i>(pictured)</i> is the only <b>
            <a href="/wiki/List_of_Major_League_Baseball_pitchers_who_have_struck_out_four_batters_in_one_inning" title="List of Major League Baseball pitchers who have struck out four batters in one inning">Major League Baseball player to strike out four batters in one inning</a></b> in the
            <a href="/wiki/World_Series" title="World Series">World Series</a>?</li>
             */

            if (line.contains("<a href=\"")) {
                expectedLine = resultsReader.readLine();
                linkMatcher = linkPattern.matcher(line);

                while(linkMatcher.find()) {

                    link = linkMatcher.group().substring(9, linkMatcher.group().length() - 1);
                    endTagMatcher = endingTagPattern.matcher(line.substring(linkMatcher.start()));
                    endTagMatcher.find();
//                    System.out.println("test: " + linkMatcher.start() + " - " + endTagMatcher.group());
                    content = endTagMatcher.group().substring(1, endTagMatcher.group().indexOf('<'));
                    String resultLine = String.format("%s,%s", link, content);
//                    System.out.printf("%s,%s\n", link, content);
//                    System.out.println(resultLine);
                    if(!resultLine.equals(expectedLine)){
                        System.out.println("result: " + resultLine + " - exp.: " + expectedLine);
                    }
//                    StringBuilder sb = new StringBuilder(line);

//                    while (endTagMatcher.find()) {
//                        // String endTag = m.group();
////                        System.out.println(endTagMatcher.group());
////                        System.out.println();
//                        sb.delete(endTagMatcher.start(), endTagMatcher.end());
//                    }


//                    content = sb.toString();
////                    System.out.println(content);
//                    content = content.substring(content.lastIndexOf(">") + 1);

                    //                System.out.println("test: " + content);
                    //                System.out.println(content.lastIndexOf(">" + 1);
                    //                System.out.println("Test 2: " + content);
                }
            }

        }// while
//            scanner.close();
    }
}