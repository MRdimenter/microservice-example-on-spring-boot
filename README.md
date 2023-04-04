[![Codacy Badge](https://app.codacy.com/project/badge/Grade/4f0a72a3fea243f68101982765be81b8)](https://www.codacy.com/gh/MRdimenter/microservice-example-on-spring-boot/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=MRdimenter/microservice-example-on-spring-boot&amp;utm_campaign=Badge_Grade) [![CodeFactor](https://www.codefactor.io/repository/github/mrdimenter/microservice-example-on-spring-boot/badge)](https://www.codefactor.io/repository/github/mrdimenter/microservice-example-on-spring-boot)
# Пример приложения с микросервисной архитектурой на Spring Boot
----
### Микросервис Customer
**POST-запросы**

Регистрация клиента:
```
localhost:8080/api/v1/customers
```
Пример Json файла: 
```json
{
    "firstName": "Dmitriy",
    "lastName": "Galtsev",
    "email": "example@gmail.com"
}
```


----
### Микросервис Fraud
**GET-запросы**

Получение информации является ли клиент мошенником:
```
http://localhost:8081/api/v1/fraud-check/{customerId}
```
Пример ответа:
```json
{
  "isFraudster": false
}
```

----
### Микросервис Eureka Server 

Знает о всех клиент-приложениях и на каком они порте и IP адресе.

Необходим для того что бы можно было создавать множенство экземпляров приложений (контейнеров) и знать к какому конкретно экземпляру необходимо обращаться.

Пример регистрации микросервиса на Eureka:
```yml
eureka:
  client:
    fetch-registry: true
    register-with-eureka: true
    service-url:
      defaultZone: http://localhost:8761/eureka
```

----
### Микросервис Zipkin 
**Micrometer** используется для сбора метрик приложения JVM и позволяет экспортировать данные в различные системы мониторинга.

**Zipkin** – это распределенная система с открытым исходным кодом, которая предоставляет механизмы для отправки, получения, хранения и визуализации деталей трассировки.

Настройка конфигурации:
``` yml
# Trace every action  
management:  
  tracing:  
    sampling:  
     probability: 1.0 #default 0.1
```

Открыт на порту: 
``` yml
http://localhost:9411/zipkin/
```




----
### Микросервис Apigateway

Используется как Load Balancer и единая точка входа. Реализовано с помощью Spring Cloud.

Простая настройка конфигурации: 
```yml
  cloud:
    gateway:
      routes:
        - id: customer 
          uri: lb://CUSTOMER 
          predicates:
            - Path=/api/v1/customers/**
        - id: fraud 
          uri: lb://FRAUD 
          predicates:
            - Path=/api/v1/fraud-check/** 
```

Пример запроса: 
```
localhost:8083/api/v1/customers # Для микросервиса Сustomer
localhost:8083/api/v1/fraud-check/1 # Для микросервиса Fraud
```

----

### Запуск Postgres и PgAdmin с помощью docker compose

Необходимо выполнить команду:
```
docker compose up -d 
```
Доступ к PgAdmin: ```localhost:5050/browser/```

