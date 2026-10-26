# E-Commerce Microservices Platform

A production-style, event-driven e-commerce platform built with Java 17, Spring Boot 3.5.4, Spring Cloud, Apache Kafka, Resilience4j, Zipkin and Docker. Designed to demonstrate real-world microservices patterns: service discovery, centralized config, API gateway, inter-service communication, event streaming, fault tolerance, distributed tracing and observability.

## Architecture

- **API Gateway** – Spring Cloud Gateway with route filtering, CORS
- **Service Discovery** – Netflix Eureka
- **Config Server** – Centralized configuration (Git-backed ready)
- **User Service** – User registration, auth-ready domain model, validation
- **Product Service** – Product catalog with pricing, stock checks
- **Inventory Service** – Real-time inventory tracking with reservation
- **Order Service** – Order orchestration with saga-style flow + Feign calls
- **Payment Service** – Payment processing with idempotent APIs
- **Notification Service** – Kafka consumer for order/payment events (email/SMS ready)

## Tech Stack

- Java 17
- Spring Boot 3.5.4
- Spring Cloud 2025.0.1 (Eureka, Config, Gateway, OpenFeign)
- Spring Data JPA, PostgreSQL/H2
- Apache Kafka
- Resilience4j (CircuitBreaker, Retry, TimeLimiter)
- Micrometer + Zipkin (Distributed Tracing)
- Spring Boot Actuator
- Docker Compose

## Features

- Service-to-service communication via OpenFeign
- Event-driven architecture with Kafka topics
- Fault tolerance with Resilience4j fallbacks
- Centralized configuration & dynamic refresh ready
- Distributed tracing across services
- Input validation & global exception handling
- Clean layered architecture (controller/service/repo/model/dto)
- Constructor injection, DTOs decoupled from entities

## Quick Start

```bash
# Build all modules
mvn clean install

# Start infrastructure
docker compose up -d

# Run services (order: discovery, config, gateway, then others)
```

## Endpoints (via Gateway)

| Service | Route | Notes |
| --- | --- | --- |
| User | /api/users/** | CRUD + validation |
| Product | /api/products/** | Catalog |
| Inventory | /api/inventory/** | Stock check/reserve |
| Order | /api/orders/** | Place order (orchestrates) |
| Payment | /api/payments/** | Process payment |

## Learning Goals

Demonstrates practical implementation of microservices patterns used in production systems.
