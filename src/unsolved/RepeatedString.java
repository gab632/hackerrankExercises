package unsolved;

public class RepeatedString {

    public static void main(String[] args) {
        System.out.println(repeatedString("aab", 882787));
    }

    public static long repeatedString(String s, long n) {
        // Write your code here
        long counter = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a'){
                counter++;
            }
        }

        if(n % s.length() == 0){
            return n / s.length() * counter;
        }

        long intermediateCounter = n / s.length() * counter;
        String remainingChars = s.substring(0, (int) (n % s.length() + 1));
        for(int i = 0; i < remainingChars.length(); i++){
            if(remainingChars.charAt(i) == 'a'){
                intermediateCounter++;
            }
        }
        return intermediateCounter;
    }


}
