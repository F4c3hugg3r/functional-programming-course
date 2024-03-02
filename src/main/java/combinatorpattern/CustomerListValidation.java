package combinatorpattern;

import java.security.Key;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static combinatorpattern.CustomerListValidation.*;
import static combinatorpattern.CustomerListValidation.ListValidationResult.*;
import static combinatorpattern.CustomerRegistrationValidator.*;


public interface CustomerListValidation extends Function<List<Customer>, ListValidationResult> {

    static CustomerListValidation isListEmpty () {
        return customers -> !(customers.isEmpty()) ?
                APPLIED : LIST_IS_EMPTY;
    }

    static CustomerListValidation areListElementsValid() {
        return customers -> customers.stream().allMatch(customer ->
                isAgeValid()
                        .and(isNumberValid()
                                .and(isEmailValid()))
                        .apply(customer)
                        .equals(ValidationResult.SUCCESS)) ?
                APPLIED : LIST_CONTAINS_INVALID_CUSTOMERS;
    }

    static CustomerListValidation isListDistinct () {
        return customers ->
            customers.stream()
                    .collect(Collectors.groupingBy(Customer::getKey))
                    .values().stream()
                    .anyMatch(list -> list.size() > 1) ?
                LIST_CONTAINS_DUPLICATES : APPLIED;
    }

    default CustomerListValidation and (CustomerListValidation other) {
        return customers ->
        {
            ListValidationResult result = apply(customers);
            return result.equals(APPLIED) ?
                    other.apply(customers) : result;
        };
    }

    enum ListValidationResult {
        APPLIED,
        LIST_CONTAINS_INVALID_CUSTOMERS,
        LIST_IS_EMPTY,
        LIST_CONTAINS_DUPLICATES
    }

}
