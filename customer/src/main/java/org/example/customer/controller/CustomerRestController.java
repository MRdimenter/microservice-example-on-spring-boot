package org.example.customer.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.customer.Customer;
import org.example.customer.CustomerRegistrationRequest;
import org.example.customer.CustomerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("getById")
    public Customer getCustomerById(@RequestParam int id) {
        try{
            return customerService.getCustomerById(id);
        } catch (NoSuchElementException e) {
            log.info(e.toString());
            return new Customer();
        }

    }
}
