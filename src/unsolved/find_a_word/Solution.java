package unsolved.find_a_word;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        ArrayList<String> lines = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
//        FileReader reader = new FileReader(0"unsolved.find_a_word/testCase09.txt");
        Path path = Path.of("find_a_word/testCase09.txt");
        BufferedReader reader = Files.newBufferedReader(path);
//        int n = Integer.valueOf(reader.readLine());

        int n = sc.nextInt();
        sc.nextLine();
        int t = sc.nextInt();
        sc.nextLine();

        Matcher m;
        Pattern p;

//        for(int i = 0; i < n; i++){
//            lines.add(sc.nextLine());
//        }


        int counter = 0;
        String word = "";
        for(int i = 0; i < t; i++){
            word = sc.nextLine();
            p = Pattern.compile("(\\W" + word + "\\W)|(^" + word + "\\W)|(\\W" + word + "$)");

            for(String line : lines){

                m = p.matcher(line);
                while(m.find()){
                    counter++;
                }
            }
            System.out.println(counter);
            counter = 0;
        }


        sc.close();
    }
}
