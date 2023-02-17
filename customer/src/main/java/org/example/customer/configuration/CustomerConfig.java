package org.example.customer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {

    /**
     * Создаём объект restTemplate для передачи запросов между микросервисами
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();

    }

}
