import java.util.ArrayList;
import java.util.List;

public class BetweenArrays {

        /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
        List<Integer> between = new ArrayList<>();
        a.sort(null);
        b.sort(null);
        
        Integer firstNumber = a.get(a.size()-1);

        for(int i=a.size()-1; i>=0; i--){
            

        }
        return null;
    }

    public static boolean isEvenlyDivisible(int n, List<Integer> a){
        int count = 0;
        for(int i=0; i<a.size(); i++){
            if(n%a.get(i) == 0){
                count++;
            }
        }
        if(count == a.size()){
            return true;
        }
        return false;
    }

    
    public static void main(String[] args) {
        
    }


}
