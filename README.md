# E-Commerce Microservices Platform

A simple e-commerce platform built using Spring Boot and Spring Cloud. It shows how multiple small services work together to place an order.

## What is this?

This project splits an e-commerce app into separate services. Each service has one job and talks to others over REST/Feign or events. 

## Services

| Service | Port | Purpose |
| --- | --- | --- |
| discovery-server (Eureka) | 8761 | Finds other services |
| api-gateway | 8080 | Entry point for all requests |
| product-service | 8081 | Manage products |
| inventory-service | 8082 | Check product stock |
| order-service | 8083 | Place orders using product + inventory |
| payment-service | 8084 | Handle payments (basic) |
| user-service | 8085 | Manage users |
| notification-service | 8086 | Send/order notifications via Kafka |
| config-server | 8888 | Central config (optional) |

## How it works

1. **Add product** in product-service
2. **Add stock** in inventory-service for that SKU
3. **Place order** via API Gateway to order-service
4. Order-service calls inventory-service using **OpenFeign** to check stock
5. If in stock and OK, order is placed. If inventory is down, **Resilience4j** returns a safe fallback
6. Events can go to Kafka for payments/notifications

## Tech Used

- Java 17, Spring Boot 3.5.4
- Spring Cloud (Eureka, Gateway, OpenFeign, Config)
- Spring Data JPA, H2
- Apache Kafka
- Resilience4j
- Micrometer + Zipkin

## How to run

### 1) Start infra (optional but good)
```bash
docker compose up -d
```
(This starts Kafka, Zipkin etc if present.)

### 2) Build all
```bash
mvn clean install
```

### 3) Run in order
1. discovery-server (8761)
2. api-gateway (8080)
3. product-service, inventory-service, order-service (others)

### 4) Test via Gateway
```http
POST http://localhost:8080/api/products
GET  http://localhost:8080/api/inventory?skuCode=IPHONE-15
POST http://localhost:8080/api/orders
```

## Notes

- Uses H2 in-memory DB (easy to test)
- Uses constructor injection
- Clean layers: controller, service, repository, model, dto
- Focuses on real microservices ideas, not just CRUD
