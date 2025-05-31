public class AppendAndDelete {

    public static void main(String[] args) {
//        System.out.println(appendAndDelete2("y", "yu", 2));
//        System.out.println(appendAndDelete2("abcdert", "abcd", 10));
        System.out.println(appendAndDelete2("hackerhappy", "hackerrank", 9));

    }

    public static String appendAndDelete2(String s, String t, int k) {
        // Write your code here

        int remainingChars = s.length() + t.length();

//        int remainingOperations = k;
//        System.out.println(remainingChars);
        int maxIndex = (s.length() <= t.length()) ? s.length() - 1 : t.length() - 1;
//        System.out.println(maxIndex);
        for(int i = 0; i < maxIndex; i++){

            if(s.charAt(i) != t.charAt(i)){
//                remainingOperations = k - (i * 2);
                break;
            }
            remainingChars -= 2;
            k -= 2;

        }
//        System.out.println(remainingChars);
        return (remainingChars <= k) ? "Yes" : "No";
    }

    public static String appendAndDelete(String s, String t, int k) {
        // Write your code here

        if (t.isEmpty()) {
            return (s.length() <= k) ? "Yes" : "No";
        }

        if (s.isEmpty()) {
            return (t.length() <= k) ? "Yes" : "No";
        }

        if (s.charAt(0) == t.charAt(0)) {
            return appendAndDelete(s.substring(1), t.substring(1), k);
        }

        return (s.length() + t.length() <= k) ? "Yes" : "No";
    }

}
