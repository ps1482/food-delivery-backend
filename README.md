# Food Delivery Backend Engine

A modular REST API designed for a food delivery ecosystem. This project focuses on building a scalable backend using a Domain-Driven Design (DDD) approach to manage the business logic between customers, restaurants, and order processing.

### Architecture and Design
The system follows a Layered Architecture to ensure high maintainability and testability:

- API Layer: REST Controllers using JSR-303 validation for request integrity.
- Service Layer: Business logic encapsulation with transactional management.
- Persistence Layer: Spring Data JPA with optimized query execution.
- Data Transfer: Java 21 Records used for immutable DTOs to prevent internal entity leakage.

### Technical Stack
- Runtime: Java 21 LTS
- Framework: Spring Boot 3.4+
- Persistence: Hibernate / Spring Data JPA
- Database: H2 (Development) / PostgreSQL (Production)
- Build Tool: Apache Maven

### Engineering Highlights
- Immutability: Utilized Java Records for all API contracts to ensure thread-safety and reduce memory overhead.
- Error Handling: Centralized exception handling via @ControllerAdvice for consistent API responses.
- Environment Management: Profile-based configuration for seamless switching between Dev and Prod environments.
- Schema Evolution: Managed persistence through Hibernate's ddl-auto, optimized for rapid iteration.

### Core API Endpoints
- GET /health: System heartbeat and status monitoring.
- GET /api/v1/users: Paginated user directory.
- POST /api/v1/users: Secure account registration.
- GET /api/v1/restaurants: Filterable restaurant discovery service.

### Development Setup
1. Clone the repository:
   git clone https://github.com/YOUR_GITHUB_USERNAME/food-delivery-backend.git

2. Build and install dependencies:
   mvn clean install

3. Run the application locally:
   mvn spring-boot:run

The service will be available at http://localhost:8080.

---
Maintained by Prashant 