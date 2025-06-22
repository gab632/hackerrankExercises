package solved;

import java.io.*;

public class LanguageDetection {

    public static void main(String[] args) throws IOException {
        /* Enter your code here.
        Read input from STDIN.
        Print output to STDOUT.
        Your class should be named Solution. */

//        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter code snippet:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        boolean stillUnsure = true;
        while((line = reader.readLine()) != null){
            if(line.matches("^#include")){
                System.out.println("C");
                stillUnsure = false;
                break;
            }
            if(line.matches("^\\s*public static void main|^import java")){
                System.out.println("Java");
                stillUnsure = false;
                break;
            }
            if(line.matches("^\\s*def\\s[a-z]+:$")){
                System.out.println("Python");
                stillUnsure = false;
                break;
            }

        }
        if(stillUnsure){
            System.out.println("Python");
        }
    }
}