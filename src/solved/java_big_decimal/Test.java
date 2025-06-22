package solved.java_big_decimal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        String bdString0 = "00.12";
        BigDecimal bd0 = new BigDecimal(bdString0);
        String bdString1 = ".12";
        String bdString2 = "0.12";
        BigDecimal bd1 = new BigDecimal(bdString1);
        BigDecimal bd2 = new BigDecimal(bdString2);

        ArrayList<ArrayList<BigDecimal>> testList = new ArrayList<>();
//        ArrayList<BigDecimal> temp = new ArrayList<>(List.of(bd0));
        testList.add(new ArrayList<>(List.of(bd0)));

        if(testList.get(0).contains(bd1)){
            testList.get(0).add(bd1);
        } else {
            testList.add(new ArrayList<>(List.of(bd1)));
        }
        if(testList.get(0).contains(bd2)){
            testList.get(0).add(bd2);
        } else {
            testList.add(new ArrayList<>(List.of(bd2)));
        }
        System.out.println(testList);


//        System.out.println(bd1);
//        System.out.println(bd2);
//        System.out.println(bd2.scale());
//        System.out.println(bd2.precision());
//        System.out.println(bd2.unscaledValue());


    }
}
