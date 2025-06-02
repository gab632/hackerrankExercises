import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CutTheSticks {

    /*
     * Complete the 'cutTheSticks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> cutTheSticks(List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();

        if(arr.isEmpty()){
            return result;
        }

        result.add(arr.size());

        // find the minimum value
        int min = arr.get(0);
        for(Integer number : arr){
            if(number < min){
                min = number;
            }
        }

        // Subtract min from each element.
        // Remove the element if element = 0.
        for(int i = 0; i < arr.size(); i++){
//            int temp = arr.get(i) - min;
            arr.set(i, arr.get(i) - min);
//            if(arr.get(i) == 0){
//                arr.remove(i);
//                i--;
//            }
        }
        int finalMin = min;

        arr.removeIf(num -> num == 0);

        // Recursive calls to the updated arr.
        result.addAll(cutTheSticks(arr));
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 4, 4, 2, 2, 8));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 3, 3, 2, 1
        ));

//                Arrays.asList(5, 4, 4, 2, 2, 8);
        System.out.println(cutTheSticks(list));
        System.out.println(cutTheSticks(list2));




    }

}
