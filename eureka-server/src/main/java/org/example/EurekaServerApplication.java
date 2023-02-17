package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka Server необходим для регистрации автономных приложений или контейнеров
 * А так же для выдачи их локаций (порт, IP) для request и response
 */

@SpringBootApplication
@EnableEurekaServer // помечаем данный микросервис как Eureka Server
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
