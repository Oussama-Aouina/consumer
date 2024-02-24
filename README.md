# Kafka Consumer Microservice with CQRS and AOP using Spring Boot

This repository contains a Spring Boot microservice designed as a Kafka consumer, implementing the Command Query Responsibility Segregation (CQRS) pattern and Aspect-Oriented Programming (AOP) principles. The microservice is intended to work in conjunction with the producer available in the [producer repository](https://github.com/Oussama-Aouina/producer.git).

## Features

- **Kafka Consumer**: Efficiently consumes messages from the Kafka topic produced by the associated producer.
- **CQRS Pattern**: Separates the command (write) and query (read) operations, allowing for scalability and flexibility.
- **AOP Implementation**: Leverages Aspect-Oriented Programming for modularizing cross-cutting concerns such as logging, security, and performance monitoring.
- **Spring Boot**: Built on the Spring Boot framework, providing a streamlined development experience and easy integration.

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/Oussama-Aouina/consumer.git

2. Navigate to the project directory:

   ```bash
   cd consumer

3. Build and run the application:

   ```bash
   ./mvnw spring-boot:run

## Configuration

Adjust Kafka configuration in application.properties to match your Kafka setup.

## Dependencies

- **Java 8 or later**
- **Spring Boot**
- **Kafka**
- **Mysql**
- **JPA**
- **Lombok**

