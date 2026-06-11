# Employee REST CRUD API

A Spring Boot REST API for managing an Employee directory. Built as part of the luv2code Spring Boot REST CRUD course (Lab 04).

## Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven

## Architecture

- **Controller** (`EmployeeController`) — REST endpoints
- **Service** (`EmployeeService` / `EmployeeServiceImpl`) — business logic & transactions
- **DAO** (`EmployeeDAO` / `EMployeeDAOImpl`) — JPA data access via `EntityManager`
- **Entity** (`Employee`) — JPA-mapped database entity

## Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/employees` | Get all employees |
| `GET` | `/api/employees/{id}` | Get employee by ID |
| `POST` | `/api/employees` | Add a new employee |
| `PUT` | `/api/employees` | Update an existing employee |
| `DELETE` | `/api/employees/{id}` | Delete employee by ID |

### Example: Create a new employee
```bash
curl -X POST http://localhost:8080/api/employees \
  -H "Content-Type: application/json" \
  -d '{"first_name":"John","last_name":"Doe","email":"john@example.com"}'
```

### Example: Update an employee
```bash
curl -X PUT http://localhost:8080/api/employees \
  -H "Content-Type: application/json" \
  -d '{"id":1,"first_name":"John","last_name":"Smith","email":"john.smith@example.com"}'
```

### Example: Delete an employee
```bash
curl -X DELETE http://localhost:8080/api/employees/1
```

## Running the App

1. Make sure PostgreSQL is running on port **5434** with database `employee`
2. Update credentials in `application.properties` if needed
3. Run:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Test endpoints at `http://localhost:8080/api/employees`

## Database Config (`application.properties`)

```properties
spring.datasource.url=jdbc:postgresql://localhost:5434/employee
spring.datasource.username=postgres
spring.datasource.password=2588
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```