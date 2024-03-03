package finalsection;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambda {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;  i<10000; i++) list.add(i);

        String test = testLambda.apply(69, list);
        System.out.println(test);
    }

    static BiFunction<Integer, List<Integer>, String> testLambda = (toBeSearched, intList) -> {
        int index = intList.indexOf(toBeSearched);
        if(index == 69) return "the person you are calling is not available";
        else return "the person is available on slot "+index;
    };

}
