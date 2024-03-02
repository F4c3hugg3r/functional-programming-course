package functionalInterface;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        timesTenConsumer.accept(1);
        incrementPlusCommentConsumer.accept(1, "Super gemacht");
    }

    static Consumer<Integer> timesTenConsumer = number -> System.out.println(number*10);
    static BiConsumer<Integer, String> incrementPlusCommentConsumer = (number, comment) ->
            System.out.println((number+1)+" Kommentar: "+comment);

}
