package finalsection;

import java.sql.SQLOutput;
import java.util.concurrent.Flow;
import java.util.function.Consumer;
import java.util.function.Function;

public class Callbacks {
    public static void main(String[] args) {

        hello("Elisa", null, callback);

        helloRunnable("Elisa", null, () -> System.out.println("kein Nachname angegeben"));

    }

    static void hello(String firstname, String lastname, Consumer<String> callback) {
        System.out.println(firstname);
        if(lastname != null) {
            System.out.println(lastname);
        }
        else {
            callback.accept(firstname);
        }
    }

    static Consumer<String> callback = firstname -> System.out.println(firstname + " hat keinen Nachnamen angegeben");

    static void helloRunnable(String firstname, String lastname, Runnable runnable) {
        System.out.println(firstname);
        if(lastname != null) {
            System.out.println(lastname);
        }
        else {
            runnable.run();
        }
    }
}
