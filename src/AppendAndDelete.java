public class AppendAndDelete {

    public static void main(String[] args) {
//        System.out.println(appendAndDelete("y", "yu", 2));
        System.out.println(appendAndDelete("abcdert", "abcd", 10));

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
