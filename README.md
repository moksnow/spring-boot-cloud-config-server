# spring-boot-cloud-config-server
Setup a config server/client by spring boot and spring cloud and fetch properties from database and 
update all clients(or micorservices apps) property sources in enviroment context whit both pull(by client) 
and push(from server) approach.
use @Value or @ConfigurationProperties for read properties

# Technologies
The following technologies are used:
- Hibernate Jpa
- H2 Database 1.4.199
- Maven 4.0.0
- Spring Boot 2.4.3
- Spring Cloud 2020.0.0
- Kafka
- ZooKeeper


# Usage
```shell
mvn clean spring-boot:run
```
after change value of properties:
for pull changes by client:
```shell
curl -H "Content-Type: application/json" -d {} http://localhost:8085/actuator/refresh
```
for notify changes from server:
```shell
curl -H "Content-Type: application/json" -d {} http://localhost:8082/actuator/busrefresh
```

# Install kafka and zookeeper 
https://dzone.com/articles/running-apache-kafka-on-windows-os

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.3/maven-plugin/)
