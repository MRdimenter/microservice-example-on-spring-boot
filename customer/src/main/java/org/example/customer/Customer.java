package org.example.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private Integer id;
    private String firstName;
    private String lastname;
    private String email;
}
