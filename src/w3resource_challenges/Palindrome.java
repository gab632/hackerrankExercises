package w3resource_challenges;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println("""
                Write a function to check if a given string is a valid palindrome 
                ignoring non-alphanumeric characters and case.
                """);

        System.out.println(isPalindromeAdvanced("an!p!na!"));
        System.out.println(isPalindromeAdvanced("==museum%$uesum!"));
        System.out.println(isPalindromeAdvanced("´+****''''''###"));
        System.out.println(isPalindromeAdvanced(""));
        System.out.println(isPalindromeAdvanced("palin!!drome"));


    }

    public static boolean isPalindromeAdvanced(String str){
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        return isPalindrome(str);
    }

    public static boolean isPalindrome(String str){
        if(str == null){
            return false;
        }

        str = str.toLowerCase();
        if(str.isEmpty() || str.length() == 1){
            return true;
        }

        if(str.charAt(0) == str.charAt(str.length() - 1)){
            return isPalindrome(str.substring(1, str.length() - 1));
        }
        return false;
    }

}
