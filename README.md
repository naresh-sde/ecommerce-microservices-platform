# E-Commerce Microservices Platform

A simple, production-style e-commerce app using Spring Boot & Spring Cloud showing real microservices concepts.

## What's covered

- **Service Discovery** - Eureka (8761)
- **API Gateway** - Spring Cloud Gateway (8080)
- **Inter-service calls** - OpenFeign
- **Resilience** - Resilience4j CircuitBreaker with fallback
- **Event Driven** - Apache Kafka (configured)
- **Distributed Tracing** - Micrometer + Zipkin
- **Central Config** - Config Server ready
- **Validation** - Bean Validation
- **Exception Handling** - Clean REST flow
- **API Docs** - Swagger/OpenAPI (springdoc)
- **Tests** - JUnit 5, Mockito (unit + context tests)
- **Docker** - docker-compose for Kafka & Zipkin

## Services & Ports

| Service | Port | Purpose |
| --- | --- | --- |
| discovery-server | 8761 | Eureka |
| api-gateway | 8080 | All requests via gateway |
| config-server | 8888 | Central config |
| product-service | 8081 | Products CRUD |
| inventory-service | 8082 | Stock check |
| order-service | 8083 | Place order (calls inventory with Feign + Resilience4j) |
| payment-service | 8084 | Payments |
| user-service | 8085 | Users |
| notification-service | 8086 | Notifications via Kafka |

## Run

```bash
# Infra
docker compose up -d

# Build & test
mvn clean install

# Start: discovery-server -> api-gateway -> others
```

## Test via Gateway

```http
POST http://localhost:8080/api/products
GET  http://localhost:8080/api/inventory?skuCode=IPHONE-15
POST http://localhost:8080/api/orders
```

## Swagger

- Product: http://localhost:8081/swagger-ui.html
- Order: http://localhost:8083/swagger-ui.html
- Inventory: http://localhost:8082/swagger-ui.html

## Notes

- H2 in-memory DB for quick testing
- Constructor injection, DTOs, layered structure
- Positive/negative tests with Mockito
- Ready for extension to real DB/K8s
