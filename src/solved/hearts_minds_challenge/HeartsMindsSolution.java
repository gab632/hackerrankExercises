package solved.detect_html_links.hearts_minds_challenge;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

/*
https://www.wearedevelopers.com/
https://puzzles.code100.dev/puzzles/hearts-and-minds
* find out the following details:
How many of the hearts ❤️ and how many of the minds 🧠 are straight?
“straight” means they point fully up, down, left or right at a straight angle
How many minds 🧠 are on the left side of the bunch?
How many hearts ❤️ are on the right side of the bunch?
*/
public class HeartsMindsSolution {

    public static void main(String[] args) throws IOException, URISyntaxException {

        InputStream in = new URI("https://puzzles.code100.dev/code100/puzzles/hearts-and-minds/hearts-and-minds.html").toURL().openStream();
        byte[] bytes = in.readAllBytes();
        String input = new String(bytes);
        String[] lines = input.split("\\n");

        /*
        * result[0] = Straight hearts,
        * result[1] = Straight minds,
        * result[0] = Minds to the left side of the screen,
        * result[0] = Minds to the right side of the screen.
        */
        int[] result = countStraightOnes(lines);

        // If you want to print the result to stout:
        printResult(result);

        in.close();
    }

    public static int[] countStraightOnes(String[] input) {
        int hearts = 0;
        int minds = 0;
        int mindsOnTheLeft = 0;
        int heartsOnTheRight = 0;

        for(String line : input){

            if(hasMind(line)){
                if(isStraight(line)){
                    minds++;
                }
                if(isOnTheLeft(line)){
                    mindsOnTheLeft++;
                }
            }
            if(hasHeart(line)){
                if(isStraight(line)){
                    hearts++;
                }
                if(isOnTheRight(line)){
                    heartsOnTheRight++;
                }
            }

        }
        return new int[]{hearts, minds, mindsOnTheLeft, heartsOnTheRight};
    }
    // helper I
    public static boolean hasHeart(String line){
        return line.contains("\u2665");
    }

    // helper II
    public static boolean hasMind(String line){
        return line.contains("\uD83E\uDDE0");
    }

    // helper III
    public static boolean isStraight(String line){
        return line.contains("rot-90")
                || line.contains("rot-180")
                || line.contains("rot-270")
                || line.contains("rot-0");
    }

    // helper IV
    // I assumed the middle value is 50.
    public static boolean isOnTheLeft(String line){
        int value = Integer.parseInt(line.substring(line.indexOf("left-") + 5, line.indexOf("left-") + 7));
        return value < 50;
    }

    // helper V
    // I assumed the middle value is 50.
    public static boolean isOnTheRight(String line){
        int value = Integer.parseInt(line.substring(line.indexOf("left-") + 5, line.indexOf("left-") + 7));
        return value > 50;
    }

    // helper VI
    public static void printResult(int[] input){
        System.out.println("\nStraight hearts: " + input[0]
                + "\nStraight minds: " + input[1]
                + "\nMinds to the left: " + input[2]
                + "\nHearts to the right: " + input[3]);
    }
}
