package unsolved;

import java.util.HashSet;
import java.util.List;

public class NonDivisibleSubset {

    public static void main(String[] args) {

        List<Integer> testList = List.of(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436);

        System.out.println(nonDivisibleSubset(7, testList));

    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        HashSet<Integer> temp = new HashSet<>();
        for(Integer n : s){
            for(Integer m : s){
                if(!m.equals(n)){
                    if((m + n) % k > 0){
                        System.out.println("test");
                        temp.add(n);
                        temp.add(m);
                    } else {
                        System.out.println(m + " " + n + " " + ((m + n) % k));
                    }
                }
            }
        }
        // System.out.println(result.toString());

        return temp.size();
    }

}
