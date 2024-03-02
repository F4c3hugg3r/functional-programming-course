package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        //Functions
        Integer number = incrementBy1.apply(1);
        System.out.println(number);

        Integer number2 = multiplyBy10.apply(1);
        System.out.println(number2);

        Function<Integer, Integer> incrementThenMultiply = incrementBy1.andThen(multiplyBy10);
        Integer number3 = incrementThenMultiply.apply(1);
        System.out.println(number3);

        String string = mapIntoString.apply(1);
        System.out.println(string);

        Function<Integer, String> incrementMultiplyToString = incrementBy1.andThen(multiplyBy10.andThen(mapIntoString));
        String string2 = incrementMultiplyToString.apply(1);
        System.out.println(string2);

        //BiFunctions
        System.out.println(incrementAndMultiply.apply(1, 10));

        BiFunction<Integer, Integer, Integer> incrementAndDoubleMultiply = incrementAndMultiply.andThen(multiplyBy10);
        System.out.println(incrementAndDoubleMultiply.apply(1, 10));

    }

    static Function<Integer, Integer> incrementBy1 = number -> number + 1;
    static Function<Integer, Integer> multiplyBy10 = number -> number*10;
    static Function<Integer, String> mapIntoString = number -> number.toString()+" ist nun ein String";

    static BiFunction<Integer, Integer, Integer> incrementAndMultiply=
            (numberToIncrement, numberToMultiply) -> (numberToIncrement + 1) * numberToMultiply;
}