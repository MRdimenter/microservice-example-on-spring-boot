package org.example.customer.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.customer.Customer;
import org.example.customer.CustomerRegistrationRequest;
import org.example.customer.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerRestController(CustomerService customerService) {

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("new customer registration {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }

    @GetMapping()

    public Customer getCustomerById(@RequestParam int id) {
        try{
            return customerService.getCustomerById(id);
        } catch (NoSuchElementException e) {
            log.info(e.toString());
            return new Customer();
        }

    }
}
