package optionals;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        String email = input.contains("@") ? input : null;

        Object emailAdress = Optional.ofNullable(email).orElseGet(() -> "no mail available");
        System.out.println(emailAdress);

        Optional.ofNullable(email).ifPresentOrElse(System.out::println,
                () -> System.out.println("no mail available"));
    }
}
