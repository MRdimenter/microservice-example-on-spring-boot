package org.example.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService() {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastname(request.lastName())
                .email(request.email())
                .build();

    }

    // todo: check if email valid
    // todo: check if email not taken
    // todo: store customer in db
}
