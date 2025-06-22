package solved;

public class FindDigits {
    public static void main(String[] args) {
        int[] tests = new int[]{ 123456789
                ,114108089
                ,110110015
                ,121
                ,33
                ,44
                ,55
                ,66
                ,77
                ,88
                ,106108048};
        int[] expected = new int[]{

                3
                ,3
                ,6
                ,2
                ,2
                ,2
                ,2
                ,2
                ,2
                ,2
                ,5
        };

        for(int i = 0; i< tests.length; i++){
            System.out.println(findDigits(tests[i]) + " " + expected[i]);
        }

    }
    public static int findDigits(int n) {
        // Write your code here
        int numberOfDivisors = 0;
        int number = n;

//        do {
//            int divisor = number % 10;
//            if(divisor == 1 || (divisor != 0 && n % divisor == 0)){
//                numberOfDivisors++;
//            }
//
//            number = number / 10;
//
//        } while (number / 10 > 0);
        while (number  > 0){
            int divisor = number % 10;
            if(divisor != 0 && n % divisor == 0){
                numberOfDivisors++;
            }

            number = number / 10;

        }
        return numberOfDivisors;
    }
}
