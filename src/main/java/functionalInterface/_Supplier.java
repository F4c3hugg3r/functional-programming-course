package functionalInterface;

import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(websiteURL.get());
    }

    static Supplier<String> websiteURL = () -> "https://www.youtube.com/";
}
