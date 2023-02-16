[![Codacy Badge](https://api.codacy.com/project/badge/Grade/341adab11de445fdb5fe482151f58c4a)](https://app.codacy.com/gh/MRdimenter/microservice-example-on-spring-boot?utm_source=github.com&utm_medium=referral&utm_content=MRdimenter/microservice-example-on-spring-boot&utm_campaign=Badge_Grade_Settings)
[![CodeFactor](https://www.codefactor.io/repository/github/mrdimenter/microservice-example-on-spring-boot/badge)](https://www.codefactor.io/repository/github/mrdimenter/microservice-example-on-spring-boot)
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



---
### Запуск Postgres и PgAdmin с помощью docker compose

Необходимо выполнить команду
```
docker compose up -d 
```
Доступ к PgAdmin: ```localhost:5050/browser/```

