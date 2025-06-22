package solved.detect_html_links;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class DetectLinks {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Pattern linkPattern = Pattern.compile("<a href=\"[\\S]+\"");
        Pattern endingTagPattern = Pattern.compile(">[.[^<>]]*</.*>");

        Matcher linkMatcher;
        Matcher endTagMatcher;

        String line = "";
        for(int i = 0; i < n; i++){
            line = scanner.nextLine();

            String link = "";
            String content = "";

            if (line.contains("<a href=\"")) {

                linkMatcher = linkPattern.matcher(line);

                while(linkMatcher.find()) {

                    link = linkMatcher.group().substring(9, linkMatcher.group().length() - 1);

                    endTagMatcher = endingTagPattern.matcher(line.substring(linkMatcher.start()));
                    endTagMatcher.find();
                    content = endTagMatcher.group().substring(1, endTagMatcher.group().indexOf("</")).trim();

                    System.out.printf("%s,%s\n", link, content);

                }
            }
        }// for-loop
        scanner.close();
    }
}