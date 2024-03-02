package combinatorpattern;

import java.time.LocalDate;
import java.util.List;

import static combinatorpattern.CustomerListValidation.*;
import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Bob",
                "blablagmail.com",
                "+4923487516",
                LocalDate.of(2000, 1, 1)
        );

        //using combinator on customer
        ValidationResult result =
                isAgeValid()
                        .and(isEmailValid()
                        .and(isNumberValid()))
                .apply(customer);

        System.out.println("single customer: "+result);
        System.out.println();

        List<Customer> customerList = List.of(
                new Customer(
                        "Bob",
                        "blabla@gmail.com",
                        "+4923487516",
                        LocalDate.of(2000, 1, 1)),

                new Customer(
                        "Marie",
                        "blabla@gmail.com",
                        "+4923487516",
                        LocalDate.of(2000, 1, 1)),

                new Customer(
                        "Bob",
                        "blabla@gmail.com",
                        "+4923487516",
                        LocalDate.of(2000, 1, 1))
        );

        //using combinator on customer list
        List<Customer> emptyList = List.of();

        ListValidationResult resultNormalList = isListEmpty()
                .and(isListDistinct()
                        .and(areListElementsValid()))
                        .apply(customerList);

        System.out.println("list with duplicates: "+resultNormalList);
        System.out.println();

        ListValidationResult resultEmptyList = isListEmpty()
                .and(isListDistinct()
                        .and(areListElementsValid()))
                .apply(emptyList);

        System.out.println("empty list: "+resultEmptyList);
    }
}
