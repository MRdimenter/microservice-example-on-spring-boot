package org.example.notification;

import org.example.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "org.example.notification",
                "org.example"
        }
)
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            RabbitMQMessageProducer rabbitMQMessageProducer,
            NotificationConfig notificationConfig
    ) {
        return args -> {
            rabbitMQMessageProducer.publish(
                    "foo",
                    notificationConfig.getInternalExchange(),
                    notificationConfig.getInternalNotificationRoutingKeys());
        };
    }

}
