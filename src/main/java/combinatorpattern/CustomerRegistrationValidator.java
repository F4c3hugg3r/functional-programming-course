package combinatorpattern;

import java.time.LocalDate;
import java.util.function.Function;

import static combinatorpattern.CustomerRegistrationValidator.*;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@") ?
                SUCCESS : EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isNumberValid() {
        return customer -> customer.getPhoneNumber().startsWith("+49") ?
                SUCCESS : NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAgeValid() {
        return customer -> (LocalDate.now().getYear()-customer.getDob().getYear()) > 16 ?
                SUCCESS : AGE_NOT_VALID;
    }

    //combinator pattern
    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        AGE_NOT_VALID
    }
}
