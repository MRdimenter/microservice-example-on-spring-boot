package org.example.customer.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.customer.Customer;
import org.example.customer.CustomerRegistrationRequest;
import org.example.customer.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/{id}")
    @ResponseBody
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping()
    @ResponseBody
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }
}
