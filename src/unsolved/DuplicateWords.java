import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWords {

    public static void main(String[] args) {

        String regex = "\\w{2,}";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        String oneLineInput = "Goodbye bye bye world world world\n" +
                "Sam went went to to to his business\n" +
                "Reya is is the the best player in eye eye game\n" +
                "in inthe\n" +
                "Hello hello Ab aB";
        String[] testCases = oneLineInput.split("\\n");

//        Scanner in = new Scanner(System.in);
//        int numSentences = Integer.parseInt(in.nextLine());
        int numSentences = testCases.length;
        while (numSentences-- > 0) {
//            String input = in.nextLine();
            String input = testCases[numSentences];
            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(regex, "");
            }

            // Prints the modified sentence.
            System.out.println(input);
        }

//        in.close();
    }
}