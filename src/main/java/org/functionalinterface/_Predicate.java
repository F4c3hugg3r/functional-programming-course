package org.functionalinterface;

import java.util.function.BiPredicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println(containsNumberBiggerThan69
                .test("Meine Kommilitonen können ca. 94 Prompts pro Minute schreiben", 94));

        System.out.println(NumberIsBiggerThan69orInText
                .test("Meine Kommilitonen können ca. 94 Prompts pro Minute schreiben", 70));
    }

    static BiPredicate<String, Integer> doesStringContainInt = (text, number) -> !text.isBlank() && text.contains(number.toString());
    static BiPredicate<String, Integer> numberBiggerThan69 = (text, number) -> number > 69;
    static BiPredicate<String, Integer> containsNumberBiggerThan69 = doesStringContainInt.and(numberBiggerThan69);
    static BiPredicate<String, Integer> NumberIsBiggerThan69orInText = doesStringContainInt.or(numberBiggerThan69);

}
