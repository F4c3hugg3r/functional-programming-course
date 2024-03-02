package combinatorpattern;

import java.time.LocalDate;

public class Customer {
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final LocalDate dob;

    public String getKey() {
        return name+email+phoneNumber+dob.toString();
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Customer(String name, String email, String phoneNumber, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(getClass() != this.getClass()) return false;
        Customer customer = (Customer) o;
        return this.getDob().equals(customer.getDob()) &&
                this.getEmail().equals(customer.getEmail()) &&
                this.getName().equals(customer.getName()) &&
                this.getPhoneNumber().equals(customer.getPhoneNumber());
    }


}
