package org.example.customer;

import org.example.clients.fraud.FraudCheckResponse;
import org.example.clients.fraud.FraudClient;
import org.example.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate,
                              FraudClient fraudClient) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastname(request.lastName())
                .email(request.email())
                .build();

        customerRepository.saveAndFlush(customer);

        /**
         * Запрашиваем метод get что бы получить объект FraudCheckResponse
         */
        FraudCheckResponse fraudCheckResponse =
                fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        // todo send notification
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).orElseThrow();
    }


    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
