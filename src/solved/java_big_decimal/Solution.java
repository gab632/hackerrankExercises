package solved.java_big_decimal;

import java.math.BigDecimal;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String input = """
                9
                -100
                50
                0
                56.6
                90
                0.12
                .12
                02.34
                000.000
                """;
        String []s= input.split("\\n");

        //Write your code here
        TreeMap<BigDecimal, ArrayList<String>> valuesAndRepresentations = new TreeMap<>(Collections.reverseOrder());
        boolean listContainsTheSameBdValue = false;
        for(String stringRep : s){
            BigDecimal bd = new BigDecimal(stringRep);
            for(BigDecimal bdKey : valuesAndRepresentations.keySet()){
                if(bdKey.compareTo(bd) == 0){
                    listContainsTheSameBdValue = true;
                    valuesAndRepresentations.get(bdKey).add(stringRep);
                    break;
                }
            }
            if(!listContainsTheSameBdValue){
                valuesAndRepresentations.put(bd, new ArrayList<>(List.of(stringRep)));
            }
            listContainsTheSameBdValue = false;
        }
        int index = 0;
        while(index < s.length){
            if(valuesAndRepresentations.get(valuesAndRepresentations.firstKey()).size() == 1){
                s[index] = valuesAndRepresentations.get(valuesAndRepresentations.firstKey()).get(0);
                index++;
            } else {
                for(String rep : valuesAndRepresentations.get(valuesAndRepresentations.firstKey())){
                    s[index] = rep;
                    index++;
                }
            }
            valuesAndRepresentations.remove(valuesAndRepresentations.firstKey());
        }
        //Output
        for(int i = 0; i < s.length; i++)
        {
            System.out.println(s[i]);
        }
    }
}
