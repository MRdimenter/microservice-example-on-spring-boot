# microservice application example on Spring Boot

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
### Запуск Postgres и PgAdmin с помощью docker compose

Необходимо выполнить команду
```
docker compose up -d 
```
Доступ к PgAdmin: ```localhost:5050/browser/```

