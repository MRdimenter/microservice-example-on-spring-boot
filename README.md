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


---
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

---
### Запуск Postgres и PgAdmin с помощью docker compose

Необходимо выполнить команду
```
docker compose up -d 
```
Доступ к PgAdmin: ```localhost:5050/browser/```

