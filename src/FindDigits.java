public class FindDigits {

    public static int findDigits(int n) {
        // Write your code here
        int numberOfDivisors = 0;
        int number = n;

        do {
            int divisor = number % 10;
            if(divisor == 1 || (divisor != 0 && number % divisor == 0)){
                numberOfDivisors++;
            }

            number = number / 10;

        } while (number / 10 > 0);

        return numberOfDivisors;
    }
}
