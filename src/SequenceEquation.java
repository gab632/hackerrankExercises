import java.util.*;

public class SequenceEquation {

    public static void main(String[] args) {

        List<Integer> testOne = List.of(5, 2 , 1, 3, 4);
        List<Integer> testTwo = List.of(4,3,5,1,2);
        List<Integer> testThree = List.of(2,3,1);

        System.out.println(permutationEquation(testOne));
        System.out.println(permutationEquation(testTwo));
        System.out.println(permutationEquation(testThree));

    }

    public static List<Integer> permutationEquation(List<Integer> p) {
        // Write your code here
        int[] perm = new int[p.size()];
        int tempValue = 0;

        for(int i = 0; i < p.size(); i++){
            for( int j = 0; j < p.size(); j++){
                if(p.get(j) == i + 1){
                    tempValue = j + 1;
                    break;
                }
            }
            for(int k = 0; k < p.size(); k++){
                if(p.get(k) == tempValue){
                    perm[i] = k + 1;
                    break;
                }
            }
        }

        List<Integer> permList = new ArrayList<>();
        for(int num : perm){
            permList.add(num);
        }
        return permList;
    }
}
