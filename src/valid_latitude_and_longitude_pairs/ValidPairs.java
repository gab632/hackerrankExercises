package valid_latitude_and_longitude_pairs;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPairs {
        private static Pattern p = Pattern.compile("^\\([+-]?((90(\\.0+)*)|([1-8][0-9]?(\\.\\d+)*)), [+-]?((180(\\.0+)*)|(1?[1-7][0-9](\\.\\d+)*)|(1[0-7][0-9](\\.\\d+)*)|([1-9][0-9](\\.\\d+)*))\\)$");
        private static Matcher m;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        scanner.nextLine();



//        for(int i = 0; i < n; i++){
//            String line = scanner.nextLine();
//            m = p.matcher(line);
//            System.out.println(m.matches() ? "Valid" : "Invalid");
//
//
//        }
    }

    public static String patternChecker(String line){
        m = getPattern().matcher(line);
        return getMatcher().matches() ? "Valid" : "Invalid";
    }

    public static Pattern getPattern(){
        return p;
    }

    public static Matcher getMatcher(){
        return m;
    }
}
